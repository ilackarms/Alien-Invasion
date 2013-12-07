package Player;
import java.util.*;

public class staff extends weapon
{
 public staff()
 {
   damage = 40;
   value = 500;
   Random generator = new Random();
    image = gamepackage.rpg_test_1.R.drawable.staff;
   int effect = Math.abs(generator.nextInt()) % 3;
   if (effect == 0)
   {
   name = "ray gun";
   special_effect = (char)'F';
   }
  if (effect == 1)
  {
   name = "glowing rod";
   special_effect = (char)'P';
  }
  if (effect == 2)
  {
   name = "nasty looking device"; //does randomly high damage
   special_effect = (char)'C';
  }
 }
}