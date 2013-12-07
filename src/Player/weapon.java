package Player;
import java.util.*;

///////////weapons

public class weapon extends game_item
{
public char special_effect;
public int damage;
public final int deal_damage()
{
 Random generator = new Random();
 return (generator.nextInt() % damage + damage / 2);
}
public weapon()
{
 special_effect = 0;
 value = 0;
 type = (char)'w';
}
}