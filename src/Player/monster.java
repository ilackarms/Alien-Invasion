package Player;
import gamepackage.rpg_test_1.MainActivity;

import java.util.Random;


public class monster extends MainActivity
{
 public int max_health;
 public int current_health;
 public int exp; //experience given
 public int damage;
 public game_item loot; //what player receives after killing it
 public String name;
 public int resistance;
 public boolean spell_resistant;
 public int special_effect;
 public int gold;
 public int image;

public final int deal_damage()
{
  Random generator = new Random();
  int r = Math.abs(generator.nextInt());
 return (r % damage + damage / 2);
}

public final void kill()
{
 current_health = 0;
 max_health = 0;
 name = "dead " + name;
 exp = 0;
}
public monster()
{
 //ctor
}
public monster(char type)
{
	image = gamepackage.rpg_test_1.R.drawable.book;
//	String uri = "@drawable/ic_launcher";
//	int image_id  = getResources().getIdentifier(uri, null, getPackageName());
	//image = getResources().getDrawable(id);
			
 spell_resistant = false;
 special_effect = 0;
 if (type == 'g')
 {
  name = "Li'l Alien";
  max_health = 30;
  current_health = 30;
  damage = 3;
  resistance = 1;
  Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  int r2 = Math.abs(generator.nextInt());
  gold = r % 6 + 1;
  int chance = r2 % 3;
  image = gamepackage.rpg_test_1.R.drawable.lilalien  ;
  if (chance == 2)
  {
   loot= new empty_slot();
  }
  if (chance == 1)
  {
   loot = new dagger();
  }
  if (chance == 0)
  {
   loot = new potion('h', 10);
  }
  exp = 25;
 }

 if (type == 'o')
 {
  name = "Crazy Martian";
  max_health = 45;
  current_health = 45;
  damage = 6;
  resistance = 1;
  Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  int r2 = Math.abs(generator.nextInt());
  gold = r % 10 + 1;
  int chance = r2 % 3;
  image = gamepackage.rpg_test_1.R.drawable.crazyalien;
  if (chance == 2)
  {
   loot = new empty_slot();;
  }
  if (chance == 1)
  {
   loot = new potion('h', 35);
  }
  if (chance == 0)
  {
   loot = new club();
  }
  exp = 45;
 }

 if (type == 'w')
 {
  name = "angry rhombus";
  max_health = 25;
  current_health = 25;
  damage = 3;
  resistance = 0;
  loot= new empty_slot();
  gold = 0;
  exp = 15;
  image = gamepackage.rpg_test_1.R.drawable.math_monster;
 }

 if (type == 'f')
 {
  name = "two headed alien";
  max_health = 60;
  current_health = 60;
  damage = 8;
  spell_resistant = true;
  resistance = 5;
  Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  int r2 = Math.abs(generator.nextInt());
  gold = r % 40 + 1;
  int chance = r2 % 3;
  if (chance == 2)
  {
   loot = new empty_slot();;
  }
  if (chance == 1)
  {
   loot = new sword();
  }
  if (chance == 0)
  {
   loot = new leather();
  }
  exp = 120;
  image = gamepackage.rpg_test_1.R.drawable.two_headed_alien;
 }

 if (type == 'h')
 {
  name = "flying saucer";
  max_health = 80;
  current_health = 80;
  damage = 15;
  resistance = 3;
  Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  int r2 = Math.abs(generator.nextInt());
  int r3 = Math.abs(generator.nextInt());
  gold = r % 70 + 50;
  spell_resistant = true;
  special_effect = r3 % 3 + 1;
    int chance = r2 % 3;
  if (chance == 2)
  {
   loot = new two_handed_sword();
  }
  if (chance == 1)
  {
   loot = new leather();
  }
  if (chance == 0)
  {
   loot = new potion('h', 35);
  }
  exp = 150;
  image = gamepackage.rpg_test_1.R.drawable.flying_saucer;
 }


if (type == 'z')
 {
  name = "zombie alien";
  max_health = 220;
  current_health = 220;
  damage = 15;
  resistance = 10;
  Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  int r2 = Math.abs(generator.nextInt());
  int r3 = Math.abs(generator.nextInt());
  gold = r % 70 + 100;
  spell_resistant = true;
  special_effect = r3 % 3 + 1;
    int chance = r2 % 3;
  if (chance == 2)
  {
   loot = new greataxe();
  }
  if (chance == 1)
  {
   loot = new ring();
  }
  if (chance == 0)
  {
   loot = new potion('h', 35);
  }
  exp = 200;
  image = gamepackage.rpg_test_1.R.drawable.zombie_alien;
 }


if (type == 'k')
 {
  name = "the krakken";
  max_health = 200;
  current_health = 200;
  damage = 25;
  resistance = 6;
  spell_resistant=true;
  image = gamepackage.rpg_test_1.R.drawable.squid;
  Random generator = new Random();
  int r = Math.abs(generator.nextInt());
  int r2 = Math.abs(generator.nextInt());
  int r3 = Math.abs(generator.nextInt());
  gold = r % 100 + 300;
  spell_resistant = true;
  special_effect = r3 % 3 + 1;
    int chance = r2 % 3;
  if (chance == 2)
  {
   loot = new wand();
  }
  if (chance == 1)
  {
   loot = new greataxe();
  }
  if (chance == 0)
  {
   loot = new wand();
  }
  exp = 3000;
  //image = gamepackage.rpg_test_1.R.drawable.krakken;
 }



if (type == 's')
{
 name = "robo-spider";
 max_health = 800;
 current_health = 800;
 damage = 15;
 resistance = 10;
 Random generator = new Random();
 int r = Math.abs(generator.nextInt());
 int r2 = Math.abs(generator.nextInt());
 int r3 = Math.abs(generator.nextInt());
 gold = r % 100 + 200;
 spell_resistant = true;
 special_effect = r3 % 3 + 1;
   int chance = r2 % 3;
 if (chance == 2)
 {
  loot = new plate();
 }
 if (chance == 1)
 {
  loot = new staff();
 }
 if (chance == 0)
 {
  loot = new potion('h', 60);
 }
 exp = 500;
 image = gamepackage.rpg_test_1.R.drawable.spider;
}


if (type == 'd')
{
 name = "destroyer";
 max_health = 150;
 current_health = 150;
 damage = 40;
 resistance = 12;
 Random generator = new Random();
 int r = Math.abs(generator.nextInt());
 int r2 = Math.abs(generator.nextInt());
 int r3 = Math.abs(generator.nextInt());
 gold = r % 100 + 400;
 spell_resistant = true;
 special_effect = r3 % 3 + 1;
   int chance = r2 % 9;
 if (chance == 9|| chance == 8)
 {
  loot = new rainbow();
 }
 if (chance == 1 || chance == 2 || chance == 3)
 {
  loot = new spell_resistant_leather();
 }
 if (chance == 0 || chance == 4 || chance == 5 || chance == 6 || chance == 7)
 {
  loot = new staff();
 }
 exp = 800;
 image = gamepackage.rpg_test_1.R.drawable.destroyer;
}

if (type == 'm')
{
 name = "mother alien";
 max_health = 1500;
 current_health = 1500;
 damage = 25;
 resistance = 14;
 Random generator = new Random();
 int r = Math.abs(generator.nextInt());
 gold = r % 70 + 1;
 
 special_effect = 15;
 
  loot = new empty_slot();
 exp = 200;
 image = gamepackage.rpg_test_1.R.drawable.mother;
}


}
}