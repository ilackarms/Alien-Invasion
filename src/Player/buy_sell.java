package Player;

import gamepackage.rpg_test_1.MainActivity;

//import java.util.*;

///buy_sell

public class buy_sell extends MainActivity
{
  public game_item[] store_inventory;
  buy_sell()
  {
    store_inventory = new game_item[8];
      store_inventory[0] = new potion('h',10);
      store_inventory[1] = new cloth();
      store_inventory[2] = new ring();
      store_inventory[3] = new club();
      store_inventory[4] = new sword();
      store_inventory[5] = new potion('h',35);
      store_inventory[6] = new leather();
      store_inventory[7] = new two_handed_sword();
  }
  
  public void list_inventory()
  {
    for (int i = 0; i<8; i++)
    {
      System.out.print(i);
      System.out.print(". ");
      System.out.print(store_inventory[i].name);
      System.out.print("\n");
      System.out.print("     price: ");
      System.out.print((store_inventory[i].value));
      System.out.print(" gold.");
      System.out.print("\n");
      System.out.print("\n");
    }
  }
}