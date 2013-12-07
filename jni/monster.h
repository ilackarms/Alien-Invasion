#ifndef MONSTER_H
#define MONSTER_H
#include "game_item.h"
#include <string>
#include <iostream>
using namespace std;


class monster
{
public:
    int max_health;
    int current_health;
    int exp; //experience given
    int damage;
    game_item* loot; //what player receives after killing it
    string name;
    int resistance;
    bool spell_resistant;
    int special_effect;
    int gold;

int deal_damage();
void kill();
monster();
monster(char); //create specific types of monsters
};

#endif // MONSTER_H
