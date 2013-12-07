#include "map.h"


room*** create_world_map()
{

room*** world_map= new room ** [WORLD_ROWS];

for (int i=0; i<WORLD_ROWS;i++)
{
    world_map[i] = new room* [WORLD_COLS];
}



world_map[0][0] = new room(0,"Your home","This is your house. To your left is your bed.\n A note has been left under your door.");
    world_map[0][0]->can_move_up = 1;
    world_map[0][0]->can_move_down = 0;
    world_map[0][0]->can_move_left = 0;
    world_map[0][0]->can_move_right = 0;
    world_map[0][0]->x=0;
    world_map[0][0]->y=0;
world_map[0][1] = new room(0,"The yard","Outside it is a cool night. You cannot hear any noise, \nbut the atmosphere is still ominous.");
    world_map[0][1]->can_move_up = 1;
    world_map[0][1]->can_move_down = 1;
    world_map[0][1]->can_move_left = 0;
    world_map[0][1]->can_move_right = 1;
    world_map[0][1]->x=0;
    world_map[0][1]->y=1;
world_map[0][2] = new room(1,"The road","The road has been captured by goblins.");
    world_map[0][2]->can_move_up = 1;
    world_map[0][2]->can_move_down = 1;
    world_map[0][2]->can_move_left = 0;
    world_map[0][2]->can_move_right = 1;
    world_map[0][2]->x=0;
    world_map[0][2]->y=2;
world_map[0][3] = new room(0,"The Village","The village is held from the outside invasion, but beyond its walls \nsafety is not guaranteed.");
    world_map[0][3]->can_move_up = 1;
    world_map[0][3]->can_move_down = 1;
    world_map[0][3]->can_move_left = 0;
    world_map[0][3]->can_move_right = 1;
    world_map[0][3]->x=0;
    world_map[0][3]->y=3;
world_map[0][4] = new room(0,"A farm","The peasants of this farm refuse to leave. \nFor the moment, they have peace.");
    world_map[0][4]->can_move_up = 1;
    world_map[0][4]->can_move_down = 1;
    world_map[0][4]->can_move_left = 0;
    world_map[0][4]->can_move_right = 0;
    world_map[0][4]->x=0;
    world_map[0][4]->y=4;
world_map[0][5] = new room(2,"The river","On the outskirts of town, monsters gather their ranks.");
    world_map[0][5]->can_move_up = 0;
    world_map[0][5]->can_move_down = 1;
    world_map[0][5]->can_move_left = 0;
    world_map[0][5]->can_move_right = 1;
    world_map[0][5]->x=0;
    world_map[0][5]->y=5;
world_map[1][1] = new room(2,"Edge of the forest","Danger is abundant here.");
    world_map[1][1]->can_move_up = 1;
    world_map[1][1]->can_move_down = 0;
    world_map[1][1]->can_move_left = 1;
    world_map[1][1]->can_move_right = 1;
    world_map[1][1]->x=1;
    world_map[1][1]->y=1;
world_map[1][2] = new room(0,"The fence","This fence surrounds the town.");
    world_map[1][2]->can_move_up = 0;
    world_map[1][2]->can_move_down = 1;
    world_map[1][2]->can_move_left = 1;
    world_map[1][2]->can_move_right = 1;
    world_map[1][2]->x=1;
    world_map[1][2]->y=2;
world_map[1][3] = new room(0,"The shop","The shopkeep is keeping his store open for those in need.");
    world_map[1][3]->can_move_up = 0;
    world_map[1][3]->can_move_down = 0;
    world_map[1][3]->can_move_left = 1;
    world_map[1][3]->can_move_right = 0;
    world_map[1][3]->x=1;
    world_map[1][3]->y=3;
world_map[1][5] = new room(2,"Cave entrance","The river flows into a rock formation that appears \nto open up below the surface.");
    world_map[1][5]->can_move_up = 0;
    world_map[1][5]->can_move_down = 0;
    world_map[1][5]->can_move_left = 1;
    world_map[1][5]->can_move_right = 1;
    world_map[1][5]->x=1;
    world_map[1][5]->y=5;
world_map[2][0] = new room(3,"Deep forest", "An enchanted river flows here"); //healing
    world_map[2][0]->can_move_up = 1;
    world_map[2][0]->can_move_down = 0;
    world_map[2][0]->can_move_left = 0;
    world_map[2][0]->can_move_right = 0;
    world_map[2][0]->x=2;
    world_map[2][0]->y=0;
world_map[2][1] = new room(2,"Heart of the forest","A lone tree in a clearing seems to have something written on it"); //puzzle
    world_map[2][1]->can_move_up = 1;
    world_map[2][1]->can_move_down = 1;
    world_map[2][1]->can_move_left = 1;
    world_map[2][1]->can_move_right = 0;
    world_map[2][1]->x=2;
    world_map[2][1]->y=1;
world_map[2][2] = new room(1,"Edge of the forest","The land begins to climb upwards");
    world_map[2][2]->can_move_up = 1;
    world_map[2][2]->can_move_down = 1;
    world_map[2][2]->can_move_left = 1;
    world_map[2][2]->can_move_right = 0;
    world_map[2][2]->x=2;
    world_map[2][2]->y=2;
world_map[2][3] = new room(1,"Wilderness","All you see is an open plain");
    world_map[2][3]->can_move_up = 1;
    world_map[2][3]->can_move_down = 1;
    world_map[2][3]->can_move_left = 0;
    world_map[2][3]->can_move_right = 0;
    world_map[2][3]->x=2;
    world_map[2][3]->y=3;
world_map[2][4] = new room(2,"Boulders","A heap of boulders blocks your path"); //requires ring to pass
    world_map[2][4]->can_move_up = 0;
    world_map[2][4]->can_move_down = 1;
    world_map[2][4]->can_move_left = 0;
    world_map[2][4]->can_move_right = 0;
    world_map[2][4]->x=2;
    world_map[2][4]->y=4;
world_map[2][5] = new room(4,"The shrine","You encounter a group of monsters in the midst of an unholy sermon."); //ring of strength to activate can_move_right
    world_map[2][5]->can_move_up = 0;
    world_map[2][5]->can_move_down = 0;
    world_map[2][5]->can_move_left = 1;
    world_map[2][5]->can_move_right = 0;
    world_map[2][5]->x=2;
    world_map[2][5]->y=5;


return world_map;
}
