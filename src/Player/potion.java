package Player;
//import java.util.*;

///////potions
public class potion extends game_item
{
 public char pot_type;
 public int heals_for;

 /////////potions


 public potion(char thistype, int hp)
 {
  type = (char)'p';
  pot_type = thistype;
   image = gamepackage.rpg_test_1.R.drawable.potion;
  if (pot_type == 'h')
  {
   heals_for = hp*2;
   if (hp == 10)
   {
    name = "small coffee";
    value = 15;
   }
   if (hp == 35)
   {
    name = "large coffee";
    value = 30;
    image = gamepackage.rpg_test_1.R.drawable.potion2;
    heals_for+=100;
   }
   if (hp == 60)
   {
    name = "ridiculous quantity of coffee";
    value = 60;
    image = gamepackage.rpg_test_1.R.drawable.potion3;
    heals_for+=250;
   }
  }
  if (pot_type == 'i')
  {
   name = "potion of invisibility";
  }
  if (pot_type == 'c')
  {
   name = "potion of cure poison";
  }
 }
   // virtual int use_potion();
}