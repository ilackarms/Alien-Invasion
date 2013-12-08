#include "monster.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

monster::monster()
{
    //ctor
}

monster::monster(char type)
{
    spell_resistant = false;
    special_effect = 0;
    if (type=='g')
    {
        name="Goblin";
        max_health = 40;
        current_health=40;
        damage=4;
        resistance = 1;
        gold = rand()%6;
        int chance = rand()%3;
        if (chance == 2)
            loot = 0;
        if (chance==1)
            loot = new dagger;
        if (chance==0)
            loot = new potion('h',10);
        exp = 25;
    }

    if (type == 'o')
    {
        name="Orc";
        max_health = 60;
        current_health=60;
        damage=8;
        resistance = 3;
        gold = rand()%10+1;
        int chance = rand()%3;
        if (chance == 2)
            loot = 0;
        if (chance == 1)
            loot = new potion('h',35);
        if (chance == 0)
            loot = new club;
        exp = 45;
    }

    if (type == 'w')
    {
        name="Wolf";
        max_health = 40;
        current_health=40;
        damage=3;
        resistance = 0;
        loot = 0;
        gold = 0;
        exp = 15;
    }

    if (type == 'f')
    {
        name="Fiend";
        max_health = 80;
        current_health=80;
        damage=8;
        resistance = 5;
        gold = rand()%40+1;
        int chance = rand()%3;
        if (chance == 2)
            loot = 0;
        if (chance==1)
            loot = new sword;
        if (chance==0)
            loot = new leather;
        exp = 120;
    }

    if (type == 'h')
    {
        name="Evil Wizard";
        max_health = 80;
        current_health=80;
        damage=15;
        resistance = 3;
        gold = rand()%70+1;
        spell_resistant = true;
        special_effect = rand()%3 + 1;
       int  chance = rand()%3;
        if (chance == 2)
            loot = new club;
        if (chance==1)
            loot = new leather;
        if (chance==0)
            loot = new potion('h',35);
        exp = 15;
    }

}

void monster::kill()
{
    current_health = 0;
    max_health = 0;
    loot = 0;
    name = "dead " + name;
    exp = 0;
}

int monster::deal_damage()
{
    srand(time(NULL));
    return((rand()%damage+damage/2));
}
