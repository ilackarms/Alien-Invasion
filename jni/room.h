#ifndef ROOM_H
#define ROOM_H
#include <string>
#include <iostream>
#include "monster.h"

class room
{
    public:
    std::string name;
    int difficulty;
    int x,y;
    monster** monster_list;
    int numberofmonsters;
    room();
    room(int, std::string, std::string);
    std::string description;
    void room_info();
    void generate_monsters();
    bool can_move_up;
    bool can_move_down;
    bool can_move_left;
    bool can_move_right;
};

#endif // ROOM_H
