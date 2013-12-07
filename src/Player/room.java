package Player;
import gamepackage.rpg_test_1.MainActivity;

import java.util.Random;

import android.view.View;


public class room extends MainActivity
{
 public String name;
 public int difficulty;
 public int x;
 public int y;
 public monster[] monster_list;
 public int numberofmonsters;
 public int image2;
 public room()
 {
 }
 public room(int room_difficulty, String in_name, String in_description)
 {
  difficulty = room_difficulty;
  name = in_name;
  description = in_description;
  numberofmonsters = 0;
  //image2 = com.example.rpg_test_1.R.drawable.room00;

  if (room_difficulty != 0)
  {
    Random generator = new Random();
  int r = Math.abs(generator.nextInt());
   numberofmonsters = ((r % 5 + 1));
   monster_list = new monster[numberofmonsters];
   generate_monsters();
  }
 }
 public String description;
 
 
 public final void room_info()
 {
   lay.setBackgroundResource(image2);
   

   
   
   if (can_move_up)
     north.setVisibility(View.VISIBLE);
   else
     north.setVisibility(View.INVISIBLE);
   
   if (can_move_down)
     south.setVisibility(View.VISIBLE);
   else
     south.setVisibility(View.INVISIBLE);
   
   if (can_move_right)
     east.setVisibility(View.VISIBLE);
   else
     east.setVisibility(View.INVISIBLE);
   
   if (can_move_left)
     west.setVisibility(View.VISIBLE);
   else
     west.setVisibility(View.INVISIBLE);
   
   if ((x==1 && y==3)||(x==5 && y==4))
   {
     store.setVisibility(View.VISIBLE);
   }
   else
   {
     store.setVisibility(View.INVISIBLE);
   }
   
   if ((x==1 && y==3)||(x==5 && y==4))
   {
     sell.setVisibility(View.VISIBLE);
   }
   else
   {
     sell.setVisibility(View.INVISIBLE);
   }
   
   
   
   
   
  //MainActivity.appendTextAndScroll(name);
  //MainActivity.appendTextAndScroll("\n");
  MainActivity.appendTextAndScroll(description);
  MainActivity.appendTextAndScroll("\n");
  //MainActivity.appendTextAndScroll(Integer.toString(x)+Integer.toString(y));
 /* if (difficulty != 0)
  {
   MainActivity.appendTextAndScroll("Monster List: ");
   MainActivity.appendTextAndScroll("\n");
   for (int i = 0; i < numberofmonsters; i++)
   {
    MainActivity.appendTextAndScroll(Integer.toString(i+1));
    MainActivity.appendTextAndScroll(". ");
    MainActivity.appendTextAndScroll(monster_list[i].name);
    MainActivity.appendTextAndScroll("\n");
   }
  }*/
 }
 
 public final void generate_new_monsters()
 {
   if (difficulty!=0){
   for (int i = 0; i < numberofmonsters;i++)
   {
     monster_list[i]=null;  
   }
   Random generator = new Random();
   int r = Math.abs(generator.nextInt());
   numberofmonsters = ((r % 5 + 1));
   monster_list = new monster[numberofmonsters];
   generate_monsters();}
 }
 
 public final void generate_monsters()
 {


  switch (difficulty)
  {
  case 0:
   break;
  case 1:
   for (int i = 0; i < numberofmonsters;i++)
   {
    Random generator = new Random();
    if (Math.abs(generator.nextInt()) % 2 == 1)
    {
     monster_list[i] = new monster('g');
    }
    else
    {
     monster_list[i] = new monster('w');
    }
   }
   break;
  case 2:
   for (int i = 0; i < numberofmonsters;i++)
   {
    Random generator = new Random();
    int chance = Math.abs(generator.nextInt()) % 2;
    if (chance == 1)
    {
     monster_list[i] = new monster('o');
    }
    else
    {
     monster_list[i] = new monster('g');
    }
   }
   break;
  case 3:
   for (int i = 0; i < numberofmonsters;i++)
   {
    Random generator = new Random();
    int chance = Math.abs(generator.nextInt()) % 3;
    if (chance == 1)
    {
     monster_list[i] = new monster('o');
    }
    if (chance == 2)
    {
     monster_list[i] = new monster('g');
    }
    if (chance == 0)
    {
     monster_list[i] = new monster('f');
    }
   }
   break;
  case 4:
   for (int i = 0; i < numberofmonsters;i++)
   {
    Random generator = new Random();
    int chance = Math.abs(generator.nextInt()) % 3;
    if (chance == 1)
    {
     monster_list[i] = new monster('o');
    }
    if (chance == 2)
    {
     monster_list[i] = new monster('f');
    }
    if (chance == 0)
    {
     monster_list[i] = new monster('h');
    }
   }
   break;
  case 5:
   for (int i = 0; i < numberofmonsters;i++)
   {
    Random generator = new Random();
    int chance = Math.abs(generator.nextInt()) % 4;
    if (chance == 1 || chance == 3)
    {
     monster_list[i] = new monster('z');
    }
    if (chance == 2)
    {
     monster_list[i] = new monster('f');
    }
    if (chance == 0)
    {
     monster_list[i] = new monster('g');
    }
   }
   break;


case 6:
	//KRAKEN ROOM
	numberofmonsters = 1;
   monster_list = new monster[numberofmonsters];
   for (int i = 0; i < numberofmonsters;i++)
   {
    
     monster_list[i] = new monster('k');
    
   }
   break;
   
case 7:
	numberofmonsters = 2;
	monster_list = new monster[numberofmonsters];
	   for (int i = 0; i < numberofmonsters;i++)
	   {	    
	     monster_list[i] = new monster('s');	    
	   }
	   break;

case 8:
	numberofmonsters = 3;
	monster_list = new monster[numberofmonsters];
	   monster_list[0] = new monster('d');
	   monster_list[1] = new monster('z');
	   monster_list[2] = new monster('z');
	   break;
	   
case 9:
	numberofmonsters = 3;
	monster_list = new monster[numberofmonsters];
	   monster_list[0] = new monster('d');
	   monster_list[1] = new monster('s');
	   monster_list[2] = new monster('d');
	   break;
	   
	   
case 10:
	//BOSS ROOM
	numberofmonsters = 1;
	monster_list = new monster[numberofmonsters];
   for (int i = 0; i < numberofmonsters;i++)
   {
    
     monster_list[i] = new monster('m');
    
   }
   break; 




  }
 }
 public boolean can_move_up;
 public boolean can_move_down;
 public boolean can_move_left;
 public boolean can_move_right;
}