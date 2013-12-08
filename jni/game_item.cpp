#include "game_item.h"
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//EMPTY INVENTORY SLOT
empty_slot::empty_slot()
{
    name = "empty slot";
    type = '0';
}

int weapon::deal_damage()
{
    srand(time(NULL));
    return((rand()%damage+damage/2));
}

weapon::weapon()
{
    special_effect = 0;
    value = 0;
    type = 'w';
}

stick::stick()
{
    name = "a hard stick";
    damage = 3;
    value = 0;
}

dagger::dagger()
{
    name = "a dagger";
    damage = 4;
    value = 4;
}

club::club()
{
    name = "a club";
    damage = 6;
    value = 10;
}

sword::sword()
{
    name = "a sword";
    damage = 8;
    value = 25;
}

wand::wand()
{
     damage = 4;
     int effect = rand()%3;
    value = 100;
     if (effect == 0)
    {
        name = "wand of fire";
        special_effect = 'f';
    }
    if (effect == 1)
    {
        name = "wand of protection";
        special_effect = 'p';
    }
    if (effect == 2)
    {
        name = "chaos wand"; //does randomly high damage
        special_effect = 'c';
    }
}

two_handed_sword::two_handed_sword()
{
    name = "two-handed sword";
    damage = 14;
    value = 80;
}

staff::staff()
{
     damage = 7;
    value = 250;
     int effect = rand()%3;
     if (effect == 0)
    {
        name = "staff of inferno";
        special_effect = 'F';
    }
    if (effect == 1)
    {
        name = "staff of invunerability";
        special_effect = 'P';
    }
    if (effect == 2)
    {
        name = "entropy staff"; //does randomly high damage
        special_effect = 'C';
    }
}

greataxe::greataxe()
{
    name = "greataxe";
    damage = 20;
    value = 300;
}

rainbow::rainbow()
{
    damage = 25;
    value = 1000;
    //name = "Rainbow";
    int effect = rand()%3;
     if (effect == 0)
    {
        name = "Suzuku";
        special_effect = 'F';
    }
    if (effect == 1)
    {
        name = "Rainbow";
        special_effect = 'P';
    }
    if (effect == 2)
    {
        name = "Dreamseeker"; //does randomly high damage
        special_effect = 'C';
    }
}

/////////////armors

armor::armor()
{
    spell_resistant = false;
    type = 'a';
}
cloth::cloth()
{
name = "cloth armor";
resistance = 1;
    value = 1;
}

leather::leather()
{
    name = "leather armor";
    resistance = 4;
    value = 6;
}

ring::ring()
{
    name = "ring mail";
    resistance = 6;
    value = 12;
}

spell_resistant_leather::spell_resistant_leather()
{
    name = "enchanted leather armor";
    resistance = 4;
    spell_resistant = true;
    value = 40;

}

plate::plate()
{
    name = "plate armor";
    resistance = 8;
    value = 80;
}

spell_resistant_plate::spell_resistant_plate() // AT SOME POINT PLAYER HAS TO CHOOSE BETWEEN ULTIMATE ARMOR OR ULTIAMTE WEAPON XD
{
    name = "Divine Shroud";
    resistance = 9;
    spell_resistant = true;
    value = 500;
}



/////////potions


potion::potion(char thistype, int hp)
{
    type = 'p';
    pot_type = thistype;
    if (pot_type=='h')
    {
        heals_for = hp;
        if (hp == 10)
            name = "lesser potion of healing";
        if (hp == 35)
            name = "potion of healing";
        if (hp == 60)
            name = "greater potion of healing";
    }
    if (pot_type=='i')
    {
        name = "potion of invisibility";
    }
    if (pot_type=='c')
    {
        name = "potion of cure poison";
    }
}







