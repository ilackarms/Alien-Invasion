package Player;
import java.util.*;

public class rainbow extends weapon
{
 public rainbow()
 {
  damage = 70;
  value = 1000;
   image = gamepackage.rpg_test_1.R.drawable.rainbow;
  //name = "Rainbow";
  Random generator = new Random();
  int effect = Math.abs(generator.nextInt()) % 3;
   if (effect == 0)
   {
   name = "Power Crystal";
   special_effect = (char)'F';
   }
  if (effect == 1)
  {
   name = "Peace and Love";
   special_effect = (char)'P';
  }
  if (effect == 2)
  {
   name = "Evil looking thingy"; //does randomly high damage
   special_effect = (char)'C';
  }
 }
}