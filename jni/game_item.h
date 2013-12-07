#ifndef GAME_ITEM_H
#define GAME_ITEM_H
#include <string>
#include <iostream>
using namespace std;


class game_item
{
    public:
        string name;
        int value;
        char type;
};

//empty slot
class empty_slot: public game_item
{
public:
    empty_slot();
};


///////////weapons

class weapon: public game_item
{
public:
char special_effect;
int damage;
int deal_damage();
weapon();
};

class stick: public weapon
{
public:
    stick();
};

class dagger: public weapon
{
    public:
    dagger();
};

class club: public weapon
{
public:
    club();
};

class sword: public weapon
{
public:
    sword();
};

class wand: public weapon
{
public:
    wand();
};

class two_handed_sword: public weapon
{
public:
    two_handed_sword();
};

class staff: public weapon
{
public:
    staff();
};

class greataxe: public weapon
{
public:
    greataxe();
};

class rainbow: public weapon
{
public:
    rainbow();
};


//////////////armor


class armor: public game_item
{
public:
    armor();
    int resistance;
    bool spell_resistant;
};

class cloth: public armor
{
public:
    cloth();
};

class leather: public armor
{
public:
    leather();
};

class ring: public armor
{
public:
    ring();
};

class spell_resistant_leather: public armor
{
public:
    spell_resistant_leather();
};

class plate: public armor
{
public:
    plate();
};

class spell_resistant_plate: public armor
{
public:
    spell_resistant_plate();
};


///////potions
class potion: public game_item
{
public:
    char pot_type;
    int heals_for;
    potion(char,int);
   // virtual int use_potion();
};


#endif // GAME_ITEM_Hf
