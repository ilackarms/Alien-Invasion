package Player;
import java.util.*;

public class wand extends weapon
{
 public wand()
 {
   damage = 30;
   Random generator = new Random();
   int effect = Math.abs(generator.nextInt()) % 3;
   image = gamepackage.rpg_test_1.R.drawable.wand;
  value = 250;
   if (effect == 0)
   {
   name = "red alien goo";
   special_effect = (char)'f';
   }
  if (effect == 1)
  {
   name = "green alien goo";
   special_effect = (char)'p';
  }
  if (effect == 2)
  {
   name = "black alien goo"; //does randomly high damage
   special_effect = (char)'c';
  }
 }
}