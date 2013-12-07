package Player;
import gamepackage.rpg_test_1.MainActivity;

//import java.util.*;

public class GlobalMembersPlayer extends MainActivity
{



 //////////////////////
 public static void delay(double d)
 {
  /*clock_t start = clock();
  while (clock() - start < d); //loop until time's up
 */
   int a = (int)d;
   try{
     Thread.sleep(a);}
   catch (Exception e) {}
   
 }
}