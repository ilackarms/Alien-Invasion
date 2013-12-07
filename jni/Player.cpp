#include "Player.h"
#include <iostream>
#include <time.h>
#include <algorithm>
#include "map.h"
//////////////////////
void delay(double d)
{
    clock_t start=clock();
    while(clock() - start < d); //loop until time's up
}

Player::Player()
{
    max_health = 100;
    current_health = 100;
    exp = 0;
    level = 0;
    gold = 0;
    game_world_map = create_world_map();
    current_room = game_world_map[0][0];
    inventory = new game_item *[40]; //size of inventory is 40
    inventory[0] = new game_item;
    inventory[0]->name = "barley";
    sizeof_inventory = 0;
    levelupexp = 100;
    cout << "Enter a name, brave warrior: ";
    cin >> name;
    cout << endl;
    equipped_armor = new cloth;
    equipped_weapon = new staff; //MEMORY LEAK?? LINK THIS TO INVENTORY
}

void Player::fight_target(monster* m1)
{
    target = m1;
    cout << name << " is attacking " << (*target).name << "!" << endl;
    cout << name << "'s health: " << max(0,current_health) << "     ";
    cout << (*target).name << "'s health: "<<  max(0,(*target).current_health) << endl <<endl;
    while (current_health > 0 && (*target).current_health > 0)
        {
            int damage_dealt_by_player = max(1,(*equipped_weapon).deal_damage() - (*target).resistance);
            int damage_dealt_by_monster = max(1,(*target).deal_damage() - (*equipped_armor).resistance);
            cout << name << " attacks " << (*target).name << " with "<< equipped_weapon->name << " for "<< damage_dealt_by_player << " damage."<< endl;
            (*target).current_health -= damage_dealt_by_player;
            cout << (*target).name << " deals " << damage_dealt_by_monster << " damage to " << name << endl;
            current_health -= damage_dealt_by_monster;

            //INSERT SPELL EFFECTS HERE!
            special_effects();
            //

            delay(200);
            cout << name << "'s health: " << current_health  << "     ";
            cout << (*target).name << "'s health: "<< (*target).current_health << endl <<endl;
            delay(400);
        }
    if (current_health <= 0)
    {
        cout << name << " has died! Game over :(((";
    }
    else
        if ((*target).current_health <= 0)
    {
        cout << name << " has slain " << (*target).name << "!" << endl << endl;
        if (target->loot != 0)
        {
            cout << (*target).name << " dropped a " << (target->loot)->name << endl;

            if (sizeof_inventory>=39)
            {
                cout << "Inventory is too large! Discarding an item..." << endl;
                sizeof_inventory = 0;
            }

            inventory[sizeof_inventory] = ((*target).loot); //adds loot to inventory
            sizeof_inventory++; //set inventory marker to next inventory slot

        }
        cout << (*target).name << " dropped " << (target->gold) << " gold." <<endl;
          gold+=target->gold;
        cout << name << " has gained " << (*target).exp << "exp." << endl << endl;
            exp+=(*target).exp;
        levelup();
    }

}

void Player::equip(weapon* w1)
{
    equipped_weapon = w1;
}

void Player::equip(armor* a1)
{
    equipped_armor = a1;
}

void Player::show_inventory()
{
    cout << name << "'s Inventory: " << endl;
    for (int i = 0; i<sizeof_inventory; i++)
    {
        cout << i << ". " << (inventory[i])->name << endl;
    }
    cout << endl;
}

void Player::levelup()
{
    if (exp >= levelupexp)
    {
        cout << name << " has leveled up!" << endl;
         max_health+=25;
         current_health=max_health;
         level++;
         exp=0;
         levelupexp*=3;
    }
    else
    {
        cout << name << " has " << exp << " exp. You need " << levelupexp << " to level up." << endl << endl;
    }
}

void Player::show_status()
{
    cout << "HP: " << current_health<<"/"<<max_health << endl;
    cout << "EXP: " << exp << "/"<<levelupexp<< endl;
    cout << "Level: " << level << endl;
    cout << "Gold: " << gold << endl;
    cout << "Weapon: " << equipped_weapon->name << "       Base Damage: " << equipped_weapon->damage << endl;
    cout << "Armor: " << equipped_armor->name << "       Physical Resistance: " << equipped_armor->resistance << endl;
    cout << "Current location: ";
    current_room->room_info();
    show_inventory();
}

void Player::special_effects()
{
    if (equipped_weapon->special_effect == 'f') //fire effect
    {
        if (rand()%5 == 4)
        {
            cout << name << " hurls a fireball at " << target->name << "!!" << endl;
                if (!(target->spell_resistant))
                {
                    int temp = (rand()%30)+1;
                    target->current_health-=temp;
                    cout << "The fireball scorches " << target->name << " for " << temp << "damage." << endl;
                }
                else
                {
                    cout << "The fireball bounces off of " << target->name <<"'s chest!"<<endl;
                }
        }
    }

    if (equipped_weapon->special_effect == 'F') //fire effect
    {
        if (rand()%6 == 5)
        {
            cout << name << " immolates " << target->name << "!!" << endl;
                if (!(target->spell_resistant))
                {
                    int temp = (rand()%31)+20;
                    target->current_health-=temp;
                    cout << "The blast smolders " << target->name << " for " << temp << "damage." << endl;
                }
                else
                {
                    cout << target->name <<"doesn't flinch."<<endl;
                }
        }
    }

    if (equipped_weapon->special_effect == 'p') //healing effect
    {
        if (rand()%5 == 4)
        {
            int temp = (rand()%20)+1;
            cout << equipped_weapon->name << " bestows healing magic upon " << name << "." << endl;
            target->current_health=min(target->current_health+temp,target->max_health);
        }
    }

    if (equipped_weapon->special_effect == 'P') //healing effect
    {
        if (rand()%6 == 5)
        {
            int temp = (rand()%30)+10;
            cout << "Life essence flows out of " << equipped_weapon->name << "." << endl;
            current_health=min(current_health+temp,max_health);
        }
    }

    if (equipped_weapon->special_effect == 'c') //fire effect
    {
        if (rand()%6 == 5)
        {
            cout << equipped_weapon->name << " radiates dark energy." << endl;
                if (!(target->spell_resistant))
                {
                    int temp = rand()%15+1;
                    target->current_health-=temp;
                    current_health=min(max_health,current_health+temp);
                    cout << target->name << " shrieks in pain " << endl;
                    cout << name << " feels stronger" << endl;
                }
                else
                {
                    cout << target->name << " is unaffected."<<endl;
                }
        }
    }

    if (equipped_weapon->special_effect == 'C') //fire effect
    {
        if (rand()%7 == 6)
        {
            cout << equipped_weapon->name << " radiates dark energy." << endl;
                if (!(target->spell_resistant))
                {
                    int temp = rand()%25+1;
                    target->current_health-=temp;
                    current_health+=temp;
                    cout << target->name << " shrieks in pain " << endl;
                    cout << name << " feels stronger" << endl;
                }
                else
                {
                    cout << target->name << " is unaffected."<<endl;
                }
        }
    }

}


void Player::user_input()
{
    current_room->room_info();
    char c;
    cout << "What do you wish to do? " ;
    cin >> c;
    cout << endl;

    switch (c)
    {
    case 'S':
        show_status();
        break;
    case 'i':
        show_inventory();
        cout << "Which item do you wish to use? " ;
        int index;
        cin >> index;
        cout << endl;
        if (index < 0 || index >= sizeof_inventory )
        {
            cout << "That is not a valid item." << endl;
        }
        else
        {
           if (inventory[index]->type == 'w')
                {
                    cout << "w";
                    weapon*w1 = static_cast<weapon*>(inventory[index]);
                    use_item_w(w1, index);
                }
            if (inventory[index]->type == 'a')
                {
                    armor*a1 = static_cast<armor*>(inventory[index]);
                    use_item_a(a1, index);
                }
            if (inventory[index]->type == 'p')
                {
                    potion*p1 = static_cast<potion*>(inventory[index]);
                    use_item_p(p1, index);
                }
        }
        break;
    case 'f':
        cout << "Who do you wish to fight? " ;
        int q;
        cin >> q;
        if (current_room->monster_list[q]->current_health<=0)
        {
            cout<< "That is already dead." << endl;
            break;
        }
        fight_target(current_room->monster_list[q]);
        current_room->monster_list[q]->kill();
        break;
    case 'q':
        cout << "Goodbye." << endl;
        return;
    default:
        change_location(c);
        break;
    }
    user_input();
}



void Player::change_location(char c)
{
    for (int i = 0; i<current_room->numberofmonsters;i++)
    {
        if (current_room->monster_list[i]->current_health>0)
        {
            cout << "You must defeat all enemies before you can leave!" << endl;
            return;
        }
    }

 switch (c)
 {
 case 'n':
    if (current_room->can_move_up==true)
    {
        current_room = game_world_map[(current_room->x+0)][(current_room->y+1)];
    }
    else
        cout << "You cannot go that way" << endl;
    break;
case 's':
    if (current_room->can_move_down==true)
    {
        current_room = game_world_map[(current_room->x+0)][(current_room->y-1)];
    }
    else
        cout << "You cannot go that way" << endl;
    break;

case 'e':
    if (current_room->can_move_right==true)
    {
        current_room = game_world_map[(current_room->x+1)][(current_room->y)];
    }
    else
        cout << "You cannot go that way" << endl;
    break;

 case 'w':
    if (current_room->can_move_left==true)
    {
        current_room = game_world_map[(current_room->x-1)][(current_room->y)];
    }
    else
        cout << "You cannot go that way" << endl;
    break;
 }
}

void Player::use_item_w(weapon* w1, int index)
{
weapon* temp = equipped_weapon;
equipped_weapon = w1;
inventory[index] = temp;
cout << name << " has equipped the " << w1->name << " and placed " << temp->name << " in the inventory." << endl;
}


void Player::use_item_a(armor* a1, int index)
{
armor* temp = equipped_armor;
equipped_armor = a1;
inventory[index] = temp;

}

void Player::use_item_p(potion* p1, int index)
{
if (p1->pot_type == 'h')
{
    int healsfor = rand()%(p1->heals_for+1)+20;
    cout << name << " drinks " << p1->name << " restoring " << healsfor << " health points." << endl;
    current_health=min(max_health,current_health+healsfor);
    remove_from_inventory(p1, index);
}

}

void Player::remove_from_inventory(potion* p1, int index)
{
delete p1;
inventory[index] = new empty_slot;
}

/*void Player::show_map()
{

}*/
