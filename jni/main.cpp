#include <iostream>
#include <string>
#include "Player.h"
//#include "include/game_item.h"
#include "monster.h"
#include "room.h"
#include "spell.h"
#include "map.h"

using namespace std;
//TODO: CREATE ALL OBJECTS, MONSTERS, ROOMS, ETC ON GAME START! WE ONLY USE POINTERS

int main()
{

Player p1;

//p1.fight_target(&m1);

p1.show_status();
p1.user_input();

/*
// Create 2D array of pointers:
int*** array2d = new (int**)[rows];
for (int i = 0; i < rows; ++i) {
  array2d[i] = new (int*)[cols];
}

// Null out the pointers contained in the array:
for (int i = 0; i < rows; ++i) {
  for (int j = 0; j < cols; ++j) {
    array2d[i][j] = NULL;
  }
}*/







}
