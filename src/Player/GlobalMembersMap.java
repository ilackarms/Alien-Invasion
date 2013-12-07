package Player;
import gamepackage.rpg_test_1.MainActivity;

//import java.util.*;

public class GlobalMembersMap extends MainActivity
{
 public static final int WORLD_ROWS = 6;
 public static final int WORLD_COLS = 6;
 
 public static room[][] create_world_map()
 {

 room[][] world_map = new room [WORLD_ROWS][WORLD_COLS];

/* for (int i = 0; i < WORLD_ROWS;i++)
 {
   for (int j = 0; j<WORLD_COLS; j++){
     world_map[i][j] = room;}
 }*/

 

 world_map[0][0] = new room(0, "Your house", "It is a spooky night outside.");
  world_map[0][0].can_move_up = true;
  world_map[0][0].can_move_down = false; 
  world_map[0][0].can_move_left = false;
  world_map[0][0].can_move_right = false;
  world_map[0][0].x = 0;
  world_map[0][0].y = 0;
  world_map[0][0].image2 = gamepackage.rpg_test_1.R.drawable.room00;
 world_map[0][1] = new room(0, "Yard", "An eerie chill fills the air.");
  world_map[0][1].can_move_up = true;
  world_map[0][1].can_move_down = true;
  world_map[0][1].can_move_left = false;
  world_map[0][1].can_move_right = false;
  world_map[0][1].x = 0;
  world_map[0][1].y = 1;
  world_map[0][1].image2 = gamepackage.rpg_test_1.R.drawable.room01;
 world_map[0][2] = new room(1, "Road into town", "Strange creatures have taken over the road!");
  world_map[0][2].can_move_up = true;
  world_map[0][2].can_move_down = true;
  world_map[0][2].can_move_left = false;
  world_map[0][2].can_move_right = true;
  world_map[0][2].x = 0;
  world_map[0][2].y = 2;
  world_map[0][2].image2 = gamepackage.rpg_test_1.R.drawable.room02;
 world_map[0][3] = new room(0, "Town", "Most people's windows are boarded up.\nThe shop is still open.");
  world_map[0][3].can_move_up = true;
  world_map[0][3].can_move_down = true;
  world_map[0][3].can_move_left = false;
  world_map[0][3].can_move_right = true;
  world_map[0][3].x = 0;
  world_map[0][3].y = 3;
  world_map[0][3].image2 = gamepackage.rpg_test_1.R.drawable.room03;
 world_map[0][4] = new room(0, "Outskirts", "Safety is not guaranteed.");
  world_map[0][4].can_move_up = true;
  world_map[0][4].can_move_down = true;
  world_map[0][4].can_move_left = false;
  world_map[0][4].can_move_right = false;
  world_map[0][4].x = 0;
  world_map[0][4].y = 4;
  world_map[0][4].image2 = gamepackage.rpg_test_1.R.drawable.room04;
 world_map[0][5] = new room(2, "Highway", "More strange creatures!");
  world_map[0][5].can_move_up = false;
  world_map[0][5].can_move_down = true;
  world_map[0][5].can_move_left = false;
  world_map[0][5].can_move_right = true;
  world_map[0][5].x = 0;
  world_map[0][5].y = 5;
  world_map[0][5].image2 = gamepackage.rpg_test_1.R.drawable.room05;
 world_map[1][1] = new room(2, "DEAD ROOM", "");
  world_map[1][1].can_move_up = false;
  world_map[1][1].can_move_down = false;
  world_map[1][1].can_move_left = false;
  world_map[1][1].can_move_right = false;
  world_map[1][1].x = 1;
  world_map[1][1].y = 1;
  //world_map[1][1].image2 = gamepackage.rpg_test_1.R.drawable.room02;
 world_map[1][2] = new room(0, "Field", "Alien goo covers the field.");
  world_map[1][2].can_move_up = false;
  world_map[1][2].can_move_down = false;
  world_map[1][2].can_move_left = true;
  world_map[1][2].can_move_right = true;
  world_map[1][2].x = 1;
  world_map[1][2].y = 2;
  world_map[1][2].image2 = gamepackage.rpg_test_1.R.drawable.room12;
 world_map[1][3] = new room(0, "Store", "The manager is stubborn as hell\nand refuses to close.");
  world_map[1][3].can_move_up = false;
  world_map[1][3].can_move_down = false;
  world_map[1][3].can_move_left = true;
  world_map[1][3].can_move_right = false;
  world_map[1][3].x = 1;
  world_map[1][3].y = 3;
  world_map[1][3].image2 = gamepackage.rpg_test_1.R.drawable.room13;
 world_map[1][5] = new room(3, "Industrial Park", "Glowing alien goo is everywhere. Prepare for battle!");
  world_map[1][5].can_move_up = false;
  world_map[1][5].can_move_down = false;
  world_map[1][5].can_move_left = true;
  world_map[1][5].can_move_right = true;
  world_map[1][5].x = 1;
  world_map[1][5].y = 5;
  world_map[1][5].image2 = gamepackage.rpg_test_1.R.drawable.room15;
 world_map[2][0] = new room(3, "Dead end", "You have to turn around. And fight!"); //healing
  world_map[2][0].can_move_up = true;
  world_map[2][0].can_move_down = false;
  world_map[2][0].can_move_left = false;
  world_map[2][0].can_move_right = false;
  world_map[2][0].x = 2;
  world_map[2][0].y = 0;
  world_map[2][0].image2 = gamepackage.rpg_test_1.R.drawable.room20;
 world_map[2][1] = new room(2, "Forest encampment", "You stumble upon some aliens enjoying\na campfire story!"); //puzzle
  world_map[2][1].can_move_up = true;
  world_map[2][1].can_move_down = true;
  world_map[2][1].can_move_left = false;
  world_map[2][1].can_move_right = false;
  world_map[2][1].x = 2;
  world_map[2][1].y = 1;
  world_map[2][1].image2 = gamepackage.rpg_test_1.R.drawable.room21;
 world_map[2][2] = new room(0, "Woods", "The deep woods are spooky here");
  world_map[2][2].can_move_up = true;
  world_map[2][2].can_move_down = true;
  world_map[2][2].can_move_left = true;
  world_map[2][2].can_move_right = false;
  world_map[2][2].x = 2;
  world_map[2][2].y = 2;
  world_map[2][2].image2 = gamepackage.rpg_test_1.R.drawable.room22;
 world_map[2][3] = new room(1, "Wilderness", "All you see is an open plain");
  world_map[2][3].can_move_up = true;
  world_map[2][3].can_move_down = true;
  world_map[2][3].can_move_left = false;
  world_map[2][3].can_move_right = false;
  world_map[2][3].x = 2;
  world_map[2][3].y = 3;
  world_map[2][3].image2 = gamepackage.rpg_test_1.R.drawable.room23;
 world_map[2][4] = new room(3, "Barricade", "An alien structure blocks your path!"); //requires ring to pass
  world_map[2][4].can_move_up = false;
  world_map[2][4].can_move_down = true;
  world_map[2][4].can_move_left = false;
  world_map[2][4].can_move_right = false;
  world_map[2][4].x = 2;
  world_map[2][4].y = 4;
  world_map[2][4].image2 = gamepackage.rpg_test_1.R.drawable.room24;
 world_map[2][5] = new room(4, "Factory", "Aliens have taken over the factory! Goo everywhere."); //ring of strength to activate can_move_right
  world_map[2][5].can_move_up = false;
  world_map[2][5].can_move_down = false;
  world_map[2][5].can_move_left = true;
  world_map[2][5].can_move_right = true;
  world_map[2][5].x = 2;
  world_map[2][5].y = 5;
  world_map[2][5].image2 = gamepackage.rpg_test_1.R.drawable.room25;

  world_map[3][1] = new room(5, "Fortress entrance", "The fortress is crawling with monsters! You must be crazy!"); //ring of strength to activate can_move_right
  world_map[3][1].can_move_up = true;
  world_map[3][1].can_move_down = false;
  world_map[3][1].can_move_left = false;
  world_map[3][1].can_move_right = true;
  world_map[3][1].x = 3;
  world_map[3][1].y = 1;
  world_map[3][1].image2 = gamepackage.rpg_test_1.R.drawable.room31;
  
  world_map[3][2] = new room(5, "Fortress entrance", "You approach the door"); //ring of strength to activate can_move_right
  world_map[3][2].can_move_up = true;
  world_map[3][2].can_move_down = true;
  world_map[3][2].can_move_left = false;
  world_map[3][2].can_move_right = false;
  world_map[3][2].x = 3;
  world_map[3][2].y = 2;
  world_map[3][2].image2 = gamepackage.rpg_test_1.R.drawable.room32;
  
  world_map[3][3] = new room(4, "Inside gate2", "You see a fortress in the distance. Battle!"); //ring of strength to activate can_move_right
  world_map[3][3].can_move_up = true;
  world_map[3][3].can_move_down = true;
  world_map[3][3].can_move_left = false;
  world_map[3][3].can_move_right = false;
  world_map[3][3].x = 3;
  world_map[3][3].y = 3;
  world_map[3][3].image2 = gamepackage.rpg_test_1.R.drawable.room33;
  
  world_map[3][4] = new room(0, "Inside gate", "You are past the barricade and approach their base."); //ring of strength to activate can_move_right
  world_map[3][4].can_move_up = false;
  world_map[3][4].can_move_down = true;
  world_map[3][4].can_move_left = true;
  world_map[3][4].can_move_right = false;
  world_map[3][4].x = 3;
  world_map[3][4].y = 4;
  world_map[3][4].image2 = gamepackage.rpg_test_1.R.drawable.room34;
  
  world_map[3][5] = new room(0, "Break Room", "Take a moment to rest. A great foe lies ahead!"); //ring of strength to activate can_move_right
  world_map[3][5].can_move_up = false;
  world_map[3][5].can_move_down = false;
  world_map[3][5].can_move_left = true;
  world_map[3][5].can_move_right = true;
  world_map[3][5].x = 3;
  world_map[3][5].y = 5;
  world_map[3][5].image2 = gamepackage.rpg_test_1.R.drawable.room35;
  
  world_map[4][0] = new room(0, "Break Room", "A safe place. Save your game!"); //ring of strength to activate can_move_right
  world_map[4][0].can_move_up = true;
  world_map[4][0].can_move_down = false;
  world_map[4][0].can_move_left = false;
  world_map[4][0].can_move_right = false;
  world_map[4][0].x = 4;
  world_map[4][0].y = 0;
  world_map[4][0].image2 = gamepackage.rpg_test_1.R.drawable.room40;
  
  world_map[4][1] = new room(8, "Hallway", "More monsters. Light shines ahead!"); //ring of strength to activate can_move_right
  world_map[4][1].can_move_up = true;
  world_map[4][1].can_move_down = true;
  world_map[4][1].can_move_left = true;
  world_map[4][1].can_move_right = false;
  world_map[4][1].x = 4;
  world_map[4][1].y = 1;
  world_map[4][1].image2 = gamepackage.rpg_test_1.R.drawable.room41;
  
  world_map[4][2] = new room(7, "Hallway", "Powerful robots guard something special!"); //ring of strength to activate can_move_right
  world_map[4][2].can_move_up = true;
  world_map[4][2].can_move_down = true;
  world_map[4][2].can_move_left = false;
  world_map[4][2].can_move_right = false;
  world_map[4][2].x = 4;
  world_map[4][2].y = 2;
  world_map[4][2].image2 = gamepackage.rpg_test_1.R.drawable.room42;
  
  world_map[4][3] = new room(0, "Teleporter", "A brilliant light radiates from this pod."); //ring of strength to activate can_move_right
  world_map[4][3].can_move_up = true;
  world_map[4][3].can_move_down = true;
  world_map[4][3].can_move_left = false;
  world_map[4][3].can_move_right = false;
  world_map[4][3].x = 4;
  world_map[4][3].y = 3;
  world_map[4][3].image2 = gamepackage.rpg_test_1.R.drawable.room43;
  
  world_map[4][4] = new room(9, "Homeworld1", "You have been teleported to the alien home world!"); //ring of strength to activate can_move_right
  world_map[4][4].can_move_up = false;
  world_map[4][4].can_move_down = true;
  world_map[4][4].can_move_left = false;
  world_map[4][4].can_move_right = true;
  world_map[4][4].x = 4;
  world_map[4][4].y = 4;
  world_map[4][4].image2 = gamepackage.rpg_test_1.R.drawable.room44;
  
  world_map[4][5] = new room(6, "Control Room", "Hark the kraken!!!!"); //ring of strength to activate can_move_right
  world_map[4][5].can_move_up = false;
  world_map[4][5].can_move_down = false;
  world_map[4][5].can_move_left = true;
  world_map[4][5].can_move_right = false;
  world_map[4][5].x = 4;
  world_map[4][5].y = 5;
  world_map[4][5].image2 = gamepackage.rpg_test_1.R.drawable.room45;
  
  world_map[5][2] = new room(10, "Final Boss", "The mother alien!! DEFEAT HER TO SAVE THE HUMAN RACE"); //ring of strength to activate can_move_right
  world_map[5][2].can_move_up = false;
  world_map[5][2].can_move_down = false;
  world_map[5][2].can_move_left = false;
  world_map[5][2].can_move_right = false;
  world_map[5][2].x = 5;
  world_map[5][2].y = 2;
  world_map[5][2].image2 = gamepackage.rpg_test_1.R.drawable.room52;
  
  world_map[5][3] = new room(9, "HomeWorld2", "You approach the summit"); //ring of strength to activate can_move_right
  world_map[5][3].can_move_up = true;
  world_map[5][3].can_move_down = true;
  world_map[5][3].can_move_left = false;
  world_map[5][3].can_move_right = false;
  world_map[5][3].x = 5;
  world_map[5][3].y = 3;
  world_map[5][3].image2 = gamepackage.rpg_test_1.R.drawable.room53;
  
  world_map[5][4] = new room(0, "Alien store", "Save and buy before you die!"); //ring of strength to activate can_move_right
  world_map[5][4].can_move_up = false;
  world_map[5][4].can_move_down = true;
  world_map[5][4].can_move_left = true;
  world_map[5][4].can_move_right = false;
  world_map[5][4].x = 5;
  world_map[5][4].y = 4;
  world_map[5][4].image2 = gamepackage.rpg_test_1.R.drawable.room54;
  
  
  
 return world_map;
 }
}