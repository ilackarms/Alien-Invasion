package Player;

import gamepackage.rpg_test_1.MainActivity;

import java.util.Random;

import android.graphics.Color;
import android.view.View;

import gamepackage.rpg_test_1.R;


public class Player extends MainActivity
{
	
 public String name;
 public int max_health;
 public int current_health;
 public int gold;
 public int exp;
 public int level;
 public int levelupexp;
 public game_item[] inventory; //this is an array of game_items!
 public spell[] spellbook;
 public char char_class;
 public monster target; //change with every fight
 public weapon equipped_weapon;
 public armor equipped_armor;
 public spell equipped_spell;
 public char status; //default = n (normal) use this for diff status like poisoned, paralyzed, sleeping, etc.
 //int locationx, locationy;
 public room current_room;
 public room[] discovered_rooms; //(discoveredx[n],discoveredy[n] = shows up on player map)
 public int sizeof_inventory; //so we can add
 public room[][] game_world_map;
 public buy_sell store;
 public char has_defeated_kraken;
//functions
 
     
 
 
 
 
 
 
 
 
 

 
public final void fight_target(monster m1)
{
 target = m1;
 
 MainActivity.appendTextAndScroll(name);
 MainActivity.appendTextAndScroll(" is attacking ");
 MainActivity.appendTextAndScroll(target.name);
 MainActivity.appendTextAndScroll("!");
 MainActivity.appendTextAndScroll("\n");
 MainActivity.appendTextAndScroll(name);
 MainActivity.appendTextAndScroll("'s health: ");
 MainActivity.appendTextAndScroll(Integer.toString(Math.max(0,current_health)));
 MainActivity.appendTextAndScroll("     ");
 MainActivity.appendTextAndScroll(target.name);
 MainActivity.appendTextAndScroll("'s health: ");
 MainActivity.appendTextAndScroll(Integer.toString(Math.max(0,target.current_health)));
 MainActivity.appendTextAndScroll("\n");
 
   int damage_dealt_by_player = Math.max(1,equipped_weapon.deal_damage() - target.resistance);
   int damage_dealt_by_monster = Math.max(1,target.deal_damage() - equipped_armor.resistance);
   MainActivity.appendTextAndScroll(name);
   MainActivity.appendTextAndScroll(" attacks ");
   MainActivity.appendTextAndScroll(target.name);
   MainActivity.appendTextAndScroll(" with ");
   MainActivity.appendTextAndScroll(equipped_weapon.name);
   MainActivity.appendTextAndScroll(" for ");
   MainActivity.appendTextAndScroll(Integer.toString(damage_dealt_by_player));
   MainActivity.appendTextAndScroll(" damage.");
   MainActivity.appendTextAndScroll("\n");
   target.current_health -= damage_dealt_by_player;
   MainActivity.appendTextAndScroll(target.name);
   MainActivity.appendTextAndScroll(" deals ");
   MainActivity.appendTextAndScroll(Integer.toString(damage_dealt_by_monster));
   MainActivity.appendTextAndScroll(" damage to ");
   MainActivity.appendTextAndScroll(name);
   MainActivity.appendTextAndScroll("\n");
   current_health -= damage_dealt_by_monster;

   //INSERT SPELL EFFECTS HERE!
   special_effects();
   //

   //GlobalMembersPlayer.delay(200);
   MainActivity.appendTextAndScroll(name);
   MainActivity.appendTextAndScroll("'s health: ");
   MainActivity.appendTextAndScroll(Integer.toString(current_health));
   MainActivity.appendTextAndScroll("     ");
   MainActivity.appendTextAndScroll(target.name);
   MainActivity.appendTextAndScroll("'s health: ");
   MainActivity.appendTextAndScroll(Integer.toString(target.current_health));
   MainActivity.appendTextAndScroll("\n");
   MainActivity.appendTextAndScroll("\n");
   //GlobalMembersPlayer.delay(400);
   
   update_player_health();
   update_monster_health();
 
 if (current_health <= 0)
 {
  MainActivity.appendTextAndScroll(name);
  MainActivity.appendTextAndScroll(" has died! Game over :(((\n");
  lay.setBackgroundResource(gamepackage.rpg_test_1.R.drawable.deathscreen);
  text.setVisibility(View.INVISIBLE);
  north.setVisibility(View.INVISIBLE);
  east.setVisibility(View.INVISIBLE);
  west.setVisibility(View.INVISIBLE);
  status_button.setVisibility(View.INVISIBLE);
  south.setVisibility(View.INVISIBLE);
  monster_1.setVisibility(View.INVISIBLE);
  monster_2.setVisibility(View.INVISIBLE);
  monster_3.setVisibility(View.INVISIBLE);
  monster_4.setVisibility(View.INVISIBLE);
  monster_5.setVisibility(View.INVISIBLE);
  player_health.setVisibility(View.INVISIBLE);
  monster_health.setVisibility(View.INVISIBLE);
  
  
 }
 else
 {
  if (target.current_health <= 0)
  {
  MainActivity.appendTextAndScroll(name);
  MainActivity.appendTextAndScroll(" has defeated ");
  MainActivity.appendTextAndScroll(target.name);
  MainActivity.appendTextAndScroll("!");
  MainActivity.appendTextAndScroll("\n");
  if (target.name.equals("the krakken"))
  {
	  has_defeated_kraken = 'y';
  }
  if (target.name.equals("mother alien"))
  {
	  end_game();
  }
  
  if (target.loot.type != '0')
  {
   MainActivity.appendTextAndScroll(target.name);
   MainActivity.appendTextAndScroll(" dropped a ");
   MainActivity.appendTextAndScroll((target.loot).name);
   MainActivity.appendTextAndScroll("\n");

  
   int has_empty = -1;
   for (int i = 0;  i< sizeof_inventory; i++)
    {
      if (inventory[i].type =='0')
      {
        has_empty=i;
      }
    }
   if (has_empty==-1)
   {
	   
   inventory[Math.min(15,sizeof_inventory)] = (target.loot); //adds loot to inventory
   if ((sizeof_inventory<15)) sizeof_inventory++;
   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
   } //set inventory marker to next inventory slot
   else inventory[has_empty] = (target.loot);
  }
  MainActivity.appendTextAndScroll(target.name);
  MainActivity.appendTextAndScroll(" dropped ");
  MainActivity.appendTextAndScroll((Integer.toString(target.gold)));
  MainActivity.appendTextAndScroll(" gold.");
  MainActivity.appendTextAndScroll("\n");
    gold += target.gold;
  MainActivity.appendTextAndScroll(name);
  MainActivity.appendTextAndScroll(" has gained ");
  MainActivity.appendTextAndScroll(Integer.toString(target.exp));
  MainActivity.appendTextAndScroll("exp.");
  MainActivity.appendTextAndScroll("\n");
   exp += target.exp;
  levelup();
  }
 }

}
public final void show_inventory()
{
 
 MainActivity.appendTextAndScroll(name);
 MainActivity.appendTextAndScroll("'s Inventory: ");
 MainActivity.appendTextAndScroll("\n");
 for (int i = 0; i < sizeof_inventory; i++)
 {
  MainActivity.appendTextAndScroll(Integer.toString(i+1));
  MainActivity.appendTextAndScroll(". ");
  MainActivity.appendTextAndScroll((inventory[i]).name);
  MainActivity.appendTextAndScroll("\n");
 }
}
public final void special_effects()
{
 if (equipped_weapon.special_effect == 'f') //fire effect
 {
   Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  //int r2 = generator.nextInt();
  if (r % 5 == 4)
  {
   MainActivity.appendTextAndScroll(name);
   MainActivity.appendTextAndScroll(" hurls a fireball at ");
   MainActivity.appendTextAndScroll(target.name);
   MainActivity.appendTextAndScroll("!!");
   MainActivity.appendTextAndScroll("\n");
    if (!(target.spell_resistant))
    {
      Random generator2 = new Random();
      int r7 = Math.abs(generator2.nextInt());
 
     int temp = (r7 % 30) + 1;
     target.current_health -= temp;
     MainActivity.appendTextAndScroll("The fireball scorches ");
     MainActivity.appendTextAndScroll(target.name);
     MainActivity.appendTextAndScroll(" for ");
     MainActivity.appendTextAndScroll(Integer.toString(temp));
     MainActivity.appendTextAndScroll("damage.");
     MainActivity.appendTextAndScroll("\n");
    }
    else
    {
     MainActivity.appendTextAndScroll("The fireball bounces off of ");
     MainActivity.appendTextAndScroll(target.name);
     MainActivity.appendTextAndScroll("'s chest!");
     MainActivity.appendTextAndScroll("\n");
    }
  }
 }

 if (equipped_weapon.special_effect == 'F') //fire effect
 {
       Random generator2 = new Random();
  int r8 = Math.abs(generator2.nextInt());
  if (r8 % 6 == 5)
  {
   MainActivity.appendTextAndScroll(name);
   MainActivity.appendTextAndScroll(" immolates ");
   MainActivity.appendTextAndScroll(target.name);
   MainActivity.appendTextAndScroll("!!");
   MainActivity.appendTextAndScroll("\n");
    if (!(target.spell_resistant))
    {
      Random generator = new Random();
      int r = Math.abs(generator.nextInt());
     int temp = (r % 31) + 20;
     target.current_health -= temp;
     MainActivity.appendTextAndScroll("The blast smolders ");
     MainActivity.appendTextAndScroll(target.name);
     MainActivity.appendTextAndScroll(" for ");
     MainActivity.appendTextAndScroll(Integer.toString(temp));
     MainActivity.appendTextAndScroll("damage.");
     MainActivity.appendTextAndScroll("\n");
    }
    else
    {
     MainActivity.appendTextAndScroll(target.name);
     MainActivity.appendTextAndScroll("doesn't flinch.");
     MainActivity.appendTextAndScroll("\n");
    }
  }
 }

 if (equipped_weapon.special_effect == 'p') //healing effect
 {
       Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  if (r % 5 == 4)
  {
        
  r = Math.abs(generator.nextInt());
   int temp = (r % 20) + 1;
   MainActivity.appendTextAndScroll(equipped_weapon.name);
   MainActivity.appendTextAndScroll(" bestows healing magic upon ");
   MainActivity.appendTextAndScroll(name);
   MainActivity.appendTextAndScroll(".");
   MainActivity.appendTextAndScroll("\n");
   current_health = Math.min(current_health + temp,max_health);
  }
 }

 if (equipped_weapon.special_effect == 'P') //healing effect
 {
       Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  if (r % 4 == 3)
  {
    r = generator.nextInt();
   int temp = Math.abs((r % 30)) + 10;
   MainActivity.appendTextAndScroll("Life essence flows out of ");
   MainActivity.appendTextAndScroll(equipped_weapon.name);
   MainActivity.appendTextAndScroll(".");
   MainActivity.appendTextAndScroll("\n");
   current_health = Math.min(current_health + temp,max_health);
  }
 }

 if (equipped_weapon.special_effect == 'c') //fire effect
 {
   Random generator = new Random();
   int r = Math.abs(generator.nextInt());
  if (r % 6 == 5)
  {
   MainActivity.appendTextAndScroll(equipped_weapon.name);
   MainActivity.appendTextAndScroll(" radiates dark energy.");
   MainActivity.appendTextAndScroll("\n");
    if (!(target.spell_resistant))
    {
      r = Math.abs(generator.nextInt());
     int temp = r % 15 + 10;
     target.current_health -= temp;
     current_health = Math.min(max_health,current_health + temp);
     MainActivity.appendTextAndScroll(target.name);
     MainActivity.appendTextAndScroll(" shrieks in pain ");
     MainActivity.appendTextAndScroll("\n");
     MainActivity.appendTextAndScroll(name);
     MainActivity.appendTextAndScroll(" feels stronger");
     MainActivity.appendTextAndScroll("\n");
    }
    else
    {
     MainActivity.appendTextAndScroll(target.name);
     MainActivity.appendTextAndScroll(" is unaffected.");
     MainActivity.appendTextAndScroll("\n");
    }
  }
 }

 if (equipped_weapon.special_effect == 'C') //fire effect
 {
   Random generator = new Random();
   int r = Math.abs(generator.nextInt());
  if (r % 7 == 6)
  {
   MainActivity.appendTextAndScroll(equipped_weapon.name);
   MainActivity.appendTextAndScroll(" radiates dark energy.");
   MainActivity.appendTextAndScroll("\n");
    if (!(target.spell_resistant))
    {
      r = Math.abs(generator.nextInt());
     int temp = r % 35 + 10;
     target.current_health -= temp;
     current_health = Math.min(max_health,current_health + temp);
     MainActivity.appendTextAndScroll(target.name);
     MainActivity.appendTextAndScroll(" shrieks in pain ");
     MainActivity.appendTextAndScroll("\n");
     MainActivity.appendTextAndScroll(name);
     MainActivity.appendTextAndScroll(" feels stronger");
     MainActivity.appendTextAndScroll("\n");
    }
    else
    {
     MainActivity.appendTextAndScroll(target.name);
     MainActivity.appendTextAndScroll(" is unaffected.");
     MainActivity.appendTextAndScroll("\n");
    }
  }
 }

}
//void use_item(game_item NamelessParameter1, int NamelessParameter2);Tangible Method Implementation Not FoundPlayer-use_item
public final void use_item_w(weapon w1, int index)
{
weapon temp = equipped_weapon;
equipped_weapon = w1;
inventory[index] = temp;
MainActivity.appendTextAndScroll(name);
MainActivity.appendTextAndScroll(" has equipped the ");
MainActivity.appendTextAndScroll(w1.name);
MainActivity.appendTextAndScroll(" and placed ");
MainActivity.appendTextAndScroll(temp.name);
MainActivity.appendTextAndScroll(" in the inventory.");
MainActivity.appendTextAndScroll("\n");
}
public final void use_item_a(armor a1, int index)
{
armor temp = equipped_armor;
equipped_armor = a1;
inventory[index] = temp;
MainActivity.appendTextAndScroll(name);
MainActivity.appendTextAndScroll(" has equipped the ");
MainActivity.appendTextAndScroll(a1.name);
MainActivity.appendTextAndScroll(" and placed ");
MainActivity.appendTextAndScroll(temp.name);
MainActivity.appendTextAndScroll(" in the inventory.");
MainActivity.appendTextAndScroll("\n");

}
public final void use_item_p(potion p1, int index)
{
if (p1.pot_type == 'h')
{
  Random generator = new Random();
 int healsfor = Math.abs(generator.nextInt()) % (p1.heals_for + 1) + 20;
 MainActivity.appendTextAndScroll(name);
 MainActivity.appendTextAndScroll(" drinks ");
 MainActivity.appendTextAndScroll(p1.name);
 MainActivity.appendTextAndScroll(" restoring ");
 MainActivity.appendTextAndScroll(Integer.toString(healsfor));
 MainActivity.appendTextAndScroll(" health points.");
 MainActivity.appendTextAndScroll("\n");
 current_health = Math.min(max_health,current_health + healsfor);
 remove_from_inventory(p1, index);
update_player_health();
}

}
public final void remove_from_inventory(potion p1, int index)
{
if (p1 != null)
 p1.value=-1;
inventory[index] = new empty_slot();
}


public final void user_input()
{
 current_room.room_info();
 
 MainActivity.appendTextAndScroll("What do you wish to do? ");
 //cin >> c;
 //Scanner s = new Scanner(System.in);
 //c = s.next().charAt(0);
 
 
 
 MainActivity.appendTextAndScroll("\n");
 
  
}
 
 
//C++ TO JAVA CONVERTER WARNING: The following line was determined to be a copy constructor call - this should be verified and a copy constructor should be created if it does not yet exist:
//ORIGINAL LINE: fight_target(current_room->monster_list[q]);


 
 
 

 //////////////EXTRA BUTTONS FOR INVENTORY
 /*case 'b':
     store_function();
     break;*/
 
 ///////NEW ACTIVITY FOR INVENTORY ITEM USE
/* show_inventory();
  MainActivity.appendTextAndScroll("Which item do you wish to use? ");
  int index;
  //cin >> index;
  Scanner s2 = new Scanner(System.in);
  index = s2.nextInt();
  MainActivity.appendTextAndScroll("\n");

  if (index < 0 || index >= sizeof_inventory)
  {
   MainActivity.appendTextAndScroll("That is not a valid item.");
   MainActivity.appendTextAndScroll("\n");
  }
  else
  {
     if (inventory[index].type == 'w')
     {
     
     weapon w1 = (weapon)(inventory[index]);
     use_item_w(w1, index);
     }
   if (inventory[index].type == 'a')
   {
     armor a1 = (armor)(inventory[index]);
     use_item_a(a1, index);
   }
   if (inventory[index].type == 'p')
   {
     potion p1 = (potion)(inventory[index]);
     use_item_p(p1, index);
   }
  }
  break;*/
 
 ///	quit buttons
/* case 'q':
  MainActivity.appendTextAndScroll("Goodbye.");
  MainActivity.appendTextAndScroll("\n");
  return;
 default:
  change_location(c);
  break;
 }
 
}*/
//void cast_spell();Tangible Method Implementation Not FoundPlayer-cast_spell //cast spell
public final boolean monsters_remain()
{
	boolean temp = false;
 for (int i = 0; i < current_room.numberofmonsters;i++)
 {
	 
  if (current_room.monster_list[i].current_health > 0)
  {
   //MainActivity.appendTextAndScroll("You must defeat all enemies before you can leave!");
   //MainActivity.appendTextAndScroll("\n");
   temp = true;
  }
 }
 return temp;
}

 
//void show_spellbook();
public final void equip(weapon w1)
{
 equipped_weapon = w1;
}
public final void equip(armor a1)
{
 equipped_armor = a1;
}
public final void levelup()
{
 if (exp >= levelupexp)
 {
  MainActivity.appendTextAndScroll(name);
  MainActivity.appendTextAndScroll(" has leveled up!");
  MainActivity.appendTextAndScroll("\n");
  
  level++;
  max_health += (50+level*level*10);
  current_health = max_health;
   
   exp = 0;
   levelupexp += (300*level);
   update_player_health();
 }
 else
 {
  MainActivity.appendTextAndScroll(name);
  MainActivity.appendTextAndScroll(" has ");
  MainActivity.appendTextAndScroll(Integer.toString(exp));
  MainActivity.appendTextAndScroll(" exp. You need ");
  MainActivity.appendTextAndScroll(Integer.toString(levelupexp));
  MainActivity.appendTextAndScroll(" to level up.");
  MainActivity.appendTextAndScroll("\n");
 }
}

public final void show_status()
{
 MainActivity.appendTextAndScroll("HP: ");
 MainActivity.appendTextAndScroll(Integer.toString(current_health));
 MainActivity.appendTextAndScroll("/");
 MainActivity.appendTextAndScroll(Integer.toString(max_health));
 MainActivity.appendTextAndScroll("\n");
 MainActivity.appendTextAndScroll("EXP: ");
 MainActivity.appendTextAndScroll(Integer.toString(exp));
 MainActivity.appendTextAndScroll("/");
 MainActivity.appendTextAndScroll(Integer.toString(levelupexp));
 MainActivity.appendTextAndScroll("\n");
 MainActivity.appendTextAndScroll("Level: ");
 MainActivity.appendTextAndScroll(Integer.toString(level));
 MainActivity.appendTextAndScroll("\n");
 MainActivity.appendTextAndScroll("Gold: ");
 MainActivity.appendTextAndScroll(Integer.toString(gold));
 MainActivity.appendTextAndScroll("\n");
 MainActivity.appendTextAndScroll("Weapon: ");
 MainActivity.appendTextAndScroll(equipped_weapon.name);
 MainActivity.appendTextAndScroll("       Base Damage: ");
 MainActivity.appendTextAndScroll(Integer.toString(equipped_weapon.damage));
 MainActivity.appendTextAndScroll("\n");
 MainActivity.appendTextAndScroll("Armor: ");
 MainActivity.appendTextAndScroll(equipped_armor.name);
 MainActivity.appendTextAndScroll("       Physical Resistance: ");
 MainActivity.appendTextAndScroll(Integer.toString(equipped_armor.resistance));
 MainActivity.appendTextAndScroll("\n");
 MainActivity.appendTextAndScroll("Current location: ");
 current_room.room_info();
 show_inventory();
}

//constructor
public Player()
{
 max_health = 100;
 current_health = 100;
 name = "Player";
 exp = 0;
 level = 0;
 gold = 0;
 game_world_map = GlobalMembersMap.create_world_map();
 current_room = game_world_map[0][0];
 inventory = new game_item[16]; //size of inventory is 40
 //inventory[0] = new game_item();
 //inventory[0].name = "barley";
 sizeof_inventory = 0;
 levelupexp = 100;
 store = new buy_sell();
 equipped_armor = new cloth();
 equipped_weapon = new stick();
has_defeated_kraken = 'n';
 
 
}
//Player(room NamelessParameter);Tangible Method Implementation Not FoundPlayer-Player
//Player(char) additional constructor by class?


/*public final void store_function()
{
 /* if (current_room.x!=1 && current_room.y!=3)
  {
    MainActivity.appendTextAndScroll("You cannot buy here.\n");
  }
  else
  {
  /*  MainActivity.appendTextAndScroll("Would you like to 0.buy or 1.sell?");
    int i;
    Scanner s5 = new Scanner(System.in);
    i = s5.nextInt();
    if (i==0) 
    {
      MainActivity.appendTextAndScroll(name);
      MainActivity.appendTextAndScroll("has ");
      MainActivity.appendTextAndScroll(Integer.toString(gold));
      MainActivity.appendTextAndScroll("gold.\n");
      store.list_inventory();
      GlobalMembersPlayer.delay(1000);
      MainActivity.appendTextAndScroll("\n Which item would you like to buy?\n");
      Scanner s6 = new Scanner(System.in);
      int j = s6.nextInt();
      if (store.store_inventory[j].value > gold)
         {
            MainActivity.appendTextAndScroll("You do not have enough gold for that.\n");
         }
      else
      {
        int has_empty = 0;
   
        
        
        for (int k = 0;  k< sizeof_inventory; k++)
        {
          if (inventory[k].value ==-1)
          {
            inventory[k] = store.store_inventory[j];
            has_empty=1;
            break;
          }
        }
        if (has_empty!=1)
        {
          inventory[sizeof_inventory] = store.store_inventory[j]; //adds loot to inventory
          sizeof_inventory++;
        }
        
        gold-=store.store_inventory[j].value;
        
        MainActivity.appendTextAndScroll(store.store_inventory[j].name);
        MainActivity.appendTextAndScroll(" purchased.\n");
        MainActivity.appendTextAndScroll(name);
        MainActivity.appendTextAndScroll("has ");
        MainActivity.appendTextAndScroll(Integer.toString(gold));
        MainActivity.appendTextAndScroll("gold remaining.\n");
        
      }
    }
    if (i==1)
    {
      MainActivity.appendTextAndScroll(name);
      MainActivity.appendTextAndScroll(" has ");
      MainActivity.appendTextAndScroll(Integer.toString(gold));
      MainActivity.appendTextAndScroll(" gold.\n");
      for (int index = 0; index < sizeof_inventory; index++)
      {
        MainActivity.appendTextAndScroll(Integer.toString(index));
        MainActivity.appendTextAndScroll(". ");
        MainActivity.appendTextAndScroll(inventory[index].name);
        MainActivity.appendTextAndScroll("      sale price: ");
        MainActivity.appendTextAndScroll(Integer.toString((int)(inventory[index].value/3)));
        MainActivity.appendTextAndScroll("\n");
      }
      
       TODO: BUY SEL SYSTEM
       * MainActivity.appendTextAndScroll("\n Which item would you like to sell?\n");
       
      Scanner s6 = new Scanner(System.in);
      int j = s6.nextInt();
      gold+=(int)(inventory[j].value/3);
      inventory[j] = new empty_slot();
      MainActivity.appendTextAndScroll("Item sold.\n");
        MainActivity.appendTextAndScroll(name);
        MainActivity.appendTextAndScroll(" now has ");
        MainActivity.appendTextAndScroll(Integer.toString(gold));
        MainActivity.appendTextAndScroll(" gold.\n");
    }
  
  }
}*/
public void user_input_north()
{
		
	if (!monsters_remain())
	{
		if (current_room.can_move_up == true)
	
		 {
			current_room.generate_new_monsters();
		  current_room = game_world_map[(current_room.x + 0)][(current_room.y + 1)];
		  
		  if (current_room.x==2 && current_room.y==4)
		   {
		     if (has_defeated_kraken=='y')
		     {
		    	 current_room.can_move_right=true;
		    	 MainActivity.appendTextAndScroll("The wall opens to your kraken-slaying touch.\n");
		     }
		   }
		   
		  
		  current_room.room_info();
		 }
		 else
		 {
		  MainActivity.appendTextAndScroll("You cannot go that way");
		  MainActivity.appendTextAndScroll("\n");
		 }
	}
	else
		 MainActivity.appendTextAndScroll("You cannot leave before killing all the monsters in this area.\n");
}

public void user_input_south()
{
	if (!monsters_remain())
	{
		if (current_room.can_move_down == true)
		 {
		  current_room.generate_new_monsters();
		  current_room = game_world_map[(current_room.x + 0)][(current_room.y - 1)];
		  
		  if (current_room.x==2 && current_room.y==4)
		   {
		     if (has_defeated_kraken=='y')
		     {
		    	 current_room.can_move_right=true;
		    	 MainActivity.appendTextAndScroll("The wall opens to your kraken-slaying touch.\n");
		     }
		   }
		  
		  current_room.room_info();
		 }
		 else
		 {
		  MainActivity.appendTextAndScroll("You cannot go that way");
		  MainActivity.appendTextAndScroll("\n");
		 }
	}
	else
		 MainActivity.appendTextAndScroll("You cannot leave before killing all the monsters in this area.\n");
}


public void user_input_east()
{
	if (!monsters_remain())
	{
		if (current_room.can_move_right == true)
		 {
			current_room.generate_new_monsters();
			current_room = game_world_map[(current_room.x + 1)][(current_room.y)];
			
			
			if (current_room.x==2 && current_room.y==4)
			   {
			     if (has_defeated_kraken=='y')
			     {
			    	 current_room.can_move_right=true;
			    	 MainActivity.appendTextAndScroll("The wall opens to your kraken-slaying touch.\n");
			     }
			   }
			current_room.room_info();
		  
		 }
		 else
		 {
		  MainActivity.appendTextAndScroll("You cannot go that way");
		  MainActivity.appendTextAndScroll("\n");
		 }
	}
	else
		 MainActivity.appendTextAndScroll("You cannot leave before killing all the monsters in this area.\n");
}

public void user_input_west()
{
	if (!monsters_remain())
	{
		if (current_room.can_move_left == true)
	
		 {
		  current_room.generate_new_monsters();
		  current_room = game_world_map[(current_room.x - 1)][(current_room.y)];
		  
		  
		  if (current_room.x==2 && current_room.y==4)
		   {
		     if (has_defeated_kraken=='y')
		     {
		    	 current_room.can_move_right=true;
		    	 MainActivity.appendTextAndScroll("The wall opens to your kraken-slaying touch.\n");
		     }
		   }
		  current_room.room_info();
		 }
		 else
		 {
		  MainActivity.appendTextAndScroll("You cannot go that way");
		  MainActivity.appendTextAndScroll("\n");
		 }
	}
	else
		 MainActivity.appendTextAndScroll("You cannot leave before killing all the monsters in this area.\n");
}

public void user_input_fight()
{
	switch (current_room.numberofmonsters)
	{
	case 1:
		if (current_room.monster_list[0].current_health>0)
		{
			monster_1.setVisibility(View.VISIBLE);
			monster_1.setImageResource(current_room.monster_list[0].image);
		}
		break;
	case 2:
		if (current_room.monster_list[0].current_health>0)
		{
			monster_1.setVisibility(View.VISIBLE);
			monster_1.setImageResource(current_room.monster_list[0].image);
		}
		if (current_room.monster_list[1].current_health>0)
		{
			monster_2.setVisibility(View.VISIBLE);
			monster_2.setImageResource(current_room.monster_list[1].image);
			
		}
		break;
	case 3:
		if (current_room.monster_list[0].current_health>0)
		{
			monster_1.setVisibility(View.VISIBLE);
			monster_1.setImageResource(current_room.monster_list[0].image);
		}
		if (current_room.monster_list[1].current_health>0)
		{
			monster_2.setVisibility(View.VISIBLE);
			monster_2.setImageResource(current_room.monster_list[1].image);
		}
		if (current_room.monster_list[2].current_health>0)
		{
			monster_3.setVisibility(View.VISIBLE);
			monster_3.setImageResource(current_room.monster_list[2].image);
		}
		break;
	case 4:
		if (current_room.monster_list[0].current_health>0)
		{
			monster_1.setVisibility(View.VISIBLE);
			monster_1.setImageResource(current_room.monster_list[0].image);
		}
		if (current_room.monster_list[1].current_health>0)
		{
			monster_2.setVisibility(View.VISIBLE);
			monster_2.setImageResource(current_room.monster_list[1].image);
		}
		if (current_room.monster_list[2].current_health>0)
		{
			monster_3.setVisibility(View.VISIBLE);
			monster_3.setImageResource(current_room.monster_list[2].image);
		}
		if (current_room.monster_list[3].current_health>0)
		{
			monster_4.setVisibility(View.VISIBLE);
			monster_4.setImageResource(current_room.monster_list[3].image);
		}
		break;
	case 5:
		if (current_room.monster_list[0].current_health>0)
		{
			monster_1.setVisibility(View.VISIBLE);
			monster_1.setImageResource(current_room.monster_list[0].image);
		}
		if (current_room.monster_list[1].current_health>0)
		{
			monster_2.setVisibility(View.VISIBLE);
			monster_2.setImageResource(current_room.monster_list[1].image);
		}
		if (current_room.monster_list[2].current_health>0)
		{
			monster_3.setVisibility(View.VISIBLE);
			monster_3.setImageResource(current_room.monster_list[2].image);
		}
		if (current_room.monster_list[3].current_health>0)
		{
			monster_4.setVisibility(View.VISIBLE);
			monster_4.setImageResource(current_room.monster_list[3].image);
		}
		if (current_room.monster_list[4].current_health>0)
		{
			monster_5.setVisibility(View.VISIBLE);
			monster_5.setImageResource(current_room.monster_list[4].image);
		}
		break;
	}
}

public void user_input_fight_monster(int q)
{
	if (current_room.monster_list[q].current_health <= 0)
	 {
	  MainActivity.appendTextAndScroll("That is already dead.");
	  MainActivity.appendTextAndScroll("\n");
	
	 }
	 fight_target(current_room.monster_list[q]);
	 if (current_room.monster_list[q].current_health<=0)
	 {switch (q)
	 {
	 case 0:
			monster_1.setVisibility(View.INVISIBLE);
			break;
		case 1:
			monster_2.setVisibility(View.INVISIBLE);
			break;
		case 2:
			monster_3.setVisibility(View.INVISIBLE);
			break;
		case 3:
			monster_4.setVisibility(View.INVISIBLE);
			break;
		case 4:
			monster_5.setVisibility(View.INVISIBLE);
	 }
	 current_room.monster_list[q].kill();
	 }
}


public void update_monster_health()
{
	double a = (double) target.current_health;
	double b = (double) target.max_health;
	double percent = a/b;
	int health_image;
	
	if (percent>=.95)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_100;
		monster_health.setImageResource(health_image);
	}
	if (percent<.95 && percent >=.85)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_90;
		monster_health.setImageResource(health_image);
	}

	if (percent<.85 && percent >=.75)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_80;
		monster_health.setImageResource(health_image);
	}
	
	if (percent<.75 && percent >=.65)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_70;
		monster_health.setImageResource(health_image);
	}
	
	if (percent<.65 && percent >=.55)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_60;
		monster_health.setImageResource(health_image);
	}
	
	
	if (percent<.55 && percent >=.45)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_50;
		monster_health.setImageResource(health_image);
	}
	if (percent<.45 && percent >=.35)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_40;
		monster_health.setImageResource(health_image);
	}
	if (percent<.35 && percent >=.25)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_30;
		monster_health.setImageResource(health_image);
	}
	if (percent<.25 && percent >=.15)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_20;
		monster_health.setImageResource(health_image);
	}
	
	if (percent<.15 && percent >=.05)
	{
		monster_health.setVisibility(View.VISIBLE);
		health_image = gamepackage.rpg_test_1.R.drawable.monster_10;
		monster_health.setImageResource(health_image);
	}
	

	if (percent<=0)
	{
		monster_health.setVisibility(View.INVISIBLE);
	}
	
}

public void update_player_health()
{
	double a = (double) current_health;
	double b = (double) max_health;
	double percent = a/b;
	int health_image;
	
	if (percent>=.95)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_100;
		player_health.setImageResource(health_image);
	}
	if (percent<.95 && percent >=.85)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_90;
		player_health.setImageResource(health_image);
	}

	if (percent<.85 && percent >=.75)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_80;
		player_health.setImageResource(health_image);
	}
	
	if (percent<.75 && percent >=.65)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_70;
		player_health.setImageResource(health_image);
	}
	
	if (percent<.65 && percent >=.55)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_60;
		player_health.setImageResource(health_image);
	}
	
	
	if (percent<.55 && percent >=.45)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_50;
		player_health.setImageResource(health_image);
	}
	if (percent<.45 && percent >=.35)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_40;
		player_health.setImageResource(health_image);
	}
	if (percent<.35 && percent >=.25)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_30;
		player_health.setImageResource(health_image);
	}
	if (percent<.25 && percent >=.15)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_20;
		player_health.setImageResource(health_image);
	}
	
	if (percent<.15 && percent >=.05)
	{
		health_image = gamepackage.rpg_test_1.R.drawable.user_10;
		player_health.setImageResource(health_image);
	}
	
	
}


public void end_game()
{
	player_health.setVisibility(View.INVISIBLE);
    monster_health.setVisibility(View.INVISIBLE);
    load.setVisibility(View.INVISIBLE);
    save.setVisibility(View.INVISIBLE);
    load.setVisibility(View.INVISIBLE);
    south.setVisibility(View.INVISIBLE);
    north.setVisibility(View.INVISIBLE);
    east.setVisibility(View.INVISIBLE);
    west.setVisibility(View.INVISIBLE);
    lay.setBackgroundResource(gamepackage.rpg_test_1.R.drawable.finalscreen);
    status_button.setVisibility(View.INVISIBLE);  
    monster_1.setVisibility(View.INVISIBLE);
    monster_2.setVisibility(View.INVISIBLE);
    monster_3.setVisibility(View.INVISIBLE);
    monster_4.setVisibility(View.INVISIBLE);
    monster_5.setVisibility(View.INVISIBLE);
    text.setVisibility(View.INVISIBLE);
    edit_name.setTextColor(Color.WHITE);
    sell.setVisibility(View.INVISIBLE);
}


public void sell_item(int index)
{
	
	if (inventory[index].value>=0)
		 {
			gold+=inventory[index].value;
			MainActivity.appendTextAndScroll("You have sold " + inventory[index].name +" for $"+Integer.toString(inventory[index].value)+"\n");
			inventory[index] = new empty_slot();
		 }

		
}


	 
}







/*void Player::show_map()
{

}*/
