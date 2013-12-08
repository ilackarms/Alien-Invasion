#ifndef PLAYER_H
#define PLAYER_H
#include "game_item.h"
#include "monster.h"
#include "spell.h"
#include "room.h"
#include <string>
#include <iostream>
using namespace std;

class Player
{
 public:
    string name;
    int max_health;
    int current_health;
    int gold;
    int exp, level, levelupexp;
    game_item** inventory; //this is an array of game_items!
    spell** spellbook;
    char char_class;
    monster* target; //change with every fight
    weapon* equipped_weapon;
    armor* equipped_armor;
    spell* equipped_spell;
    char status; //default = n (normal) use this for diff status like poisoned, paralyzed, sleeping, etc.
    //int locationx, locationy;
    room* current_room;
    room** discovered_rooms; //(discoveredx[n],discoveredy[n] = shows up on player map)
    int sizeof_inventory; //so we can add
    room*** game_world_map;

//functions
void fight_target(monster*);
void show_inventory();
void special_effects();
void use_item(game_item*, int);
void use_item_w(weapon*, int);
void use_item_a(armor*, int);
void use_item_p(potion*, int);
void remove_from_inventory(potion*, int);


void user_input();
void cast_spell(); //cast spell
void change_location(char);

//void show_spellbook();
void equip(weapon*);
void equip(armor*);
void levelup(); //check if exp>=levelupexp, if so, level up

void show_status();

//constructor
Player();
Player(room*);
//Player(char) additional constructor by class?
};

#endif // PLAYER_H

