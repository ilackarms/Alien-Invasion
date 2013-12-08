//MAIN

package gamepackage.rpg_test_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import Player.Player;
import Player.armor;
import Player.cloth;
import Player.club;
import Player.dagger;
import Player.empty_slot;
import Player.greataxe;
import Player.leather;
import Player.plate;
import Player.potion;
import Player.rainbow;
import Player.ring;
import Player.spell_resistant_leather;
import Player.spell_resistant_plate;
import Player.staff;
import Player.stick;
import Player.sword;
import Player.two_handed_sword;
import Player.wand;
import Player.weapon;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    
  
  
  
  public static TextView text;
  int value;
  public static ImageButton north, east, west, status_button;
  public static ImageButton  south, monster_1, monster_2, monster_3, monster_4, monster_5;
  public static Button button_name;
  public static EditText edit_name;
  public static Button save, fight;
  public static ImageButton load;
    public static Player p1 = new Player();
    public static RelativeLayout lay;
  public static ImageButton store;
  public static ImageView player_health;
  public static ImageView monster_health;
  public static ImageButton sell;
  
  
   public static void appendTextAndScroll(String this_text)
    {
        if(text != null){
            text.append(this_text );
            final Layout layout = text.getLayout();
            if(layout != null){
                int scrollDelta = layout.getLineBottom(text.getLineCount() - 1) 
                    - text.getScrollY() - text.getHeight();
                if(scrollDelta > 0)
                    text.scrollBy(0, scrollDelta);
            }
        }
    }
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        value = 0 ;
        lay = (RelativeLayout) findViewById(R.id.layout_main);
        north = (ImageButton) findViewById(R.id.button_north);
        south = (ImageButton) findViewById(R.id.button_south);
        east = (ImageButton) findViewById(R.id.button_east);
        west = (ImageButton) findViewById(R.id.button_west);
        fight = (Button) findViewById(R.id.button_fight);
        status_button = (ImageButton) findViewById(R.id.button_status);
        store = (ImageButton) findViewById(R.id.sell_button);
        sell = (ImageButton) findViewById(R.id.store_button);
        Button quit = (Button) findViewById(R.id.quitbutton1);
        
        
        monster_1 = (ImageButton) findViewById(R.id.monster_button_1);
        monster_2 = (ImageButton) findViewById(R.id.monster_button_2);
        monster_3 = (ImageButton) findViewById(R.id.monster_button_3);
        monster_4 = (ImageButton) findViewById(R.id.monster_button_4);
        monster_5 = (ImageButton) findViewById(R.id.monster_button_5);
        
        edit_name = (EditText) findViewById(R.id.enter_name);
        button_name = (Button) findViewById(R.id.name_button);
        
        save = (Button) findViewById(R.id.save_button);
        load = (ImageButton) findViewById(R.id.load_button);
        
        player_health = (ImageView) findViewById(R.id.player_health);
        monster_health = (ImageView) findViewById(R.id.monster_health);
        
        text = (TextView) findViewById(R.id.text_view_1);
        text.setMovementMethod(new ScrollingMovementMethod());
        text.setText("");
        //appendTextAndScroll("Enter a name, brave warrior: ");
        //appendTextAndScroll("\n");
       
        player_health.setVisibility(View.INVISIBLE);
        player_health.setBackground(null);
        monster_health.setVisibility(View.INVISIBLE);
        monster_health.setBackground(null);
        load.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);
        load.setBackground(null);
        south.setBackground(null);
        north.setBackground(null);
        east.setBackground(null);
        west.setBackground(null);
        store.setBackground(null);
        status_button.setBackground(null);  
        monster_1.setBackground(null);
        monster_2.setBackground(null);
        monster_3.setBackground(null);
        monster_4.setBackground(null);
        monster_5.setBackground(null);
        text.setTextColor(Color.WHITE);
        edit_name.setTextColor(Color.WHITE);
        store.setVisibility(View.INVISIBLE);

        sell.setBackground(null);
        sell.setVisibility(View.INVISIBLE);

        button_name.setOnClickListener(new View.OnClickListener() {
        
        @Override
        public void onClick(View v) {
          String str = edit_name.getText().toString();
          p1.name = str;
          button_name.setVisibility(View.GONE);
          edit_name.setVisibility(View.GONE);
          
          north.setVisibility(View.VISIBLE);
          south.setVisibility(View.VISIBLE);
          east.setVisibility(View.VISIBLE);
          west.setVisibility(View.VISIBLE);
          status_button.setVisibility(View.VISIBLE);
          //fight.setVisibility(View.VISIBLE);
          load.setVisibility(View.VISIBLE);
          save.setVisibility(View.VISIBLE);
          player_health.setVisibility(View.VISIBLE);
          p1.current_room = p1.game_world_map[0][0];
          p1.current_room.room_info();
          
        }
        
      });
       
       
       north.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        
        p1.user_input_north();
        p1.user_input_fight();
      }
    
    });
    
    south.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        
        p1.user_input_south();
        p1.user_input_fight();
      }
      
    });
    
    east.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        
        p1.user_input_east();
        p1.user_input_fight();
         
      }
    });
    
    west.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        
        p1.user_input_west();
        p1.user_input_fight();
      }
    });
    
    
    ///////////SAVE AND LOAD BUTTONS////////////

    
    save.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {         

        if (p1.current_room.difficulty!=0)
        {
          appendTextAndScroll("You can't save in a dangerous area.\n");
        }
        else
  {
    	load.setVisibility(View.VISIBLE);
        //create output
        String save_Me;
        String temp="";
    if (p1.sizeof_inventory!=0)
    { 
        for (int i = 0; i<p1.sizeof_inventory; i++)
        {
          temp=temp+p1.inventory[i].name+"-";
        }
        
    }
      
    save_Me = p1.name+"-"+Integer.toString(p1.max_health)+"-"+p1.current_health+"-"+p1.gold+"-"+p1.exp+"-"+p1.level+"-"+p1.levelupexp+"-"+p1.sizeof_inventory+"-"+temp+p1.equipped_weapon.name+"-"+p1.equipped_armor.name+"-"+p1.current_room.x+"-"+p1.current_room.y+"-"+p1.has_defeated_kraken;
    //+p1.has_defeated_kraken; TODO FIX KRAKEN THING 
        
        //appendTextAndScroll(save_Me+"\n");
        //appendTextAndScroll(System.getProperty("user.dir")+"savegame.txt\n");
          
            save_function("savegame.txt",save_Me);
        //appendTextAndScroll(save_Me+"\n");
        
        
  }
        
        
        
        
        
        
        
        
        
        
        
        
        
      }
    });
    
    
    
    
    
    
    load.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
      
    	  //File f = new File("savegame.txt");
    	  //TODO: CHECK IF FILE EXISTS
    	   //CHECK IF FILE EXISTS FIRST
    	  String temp = load_function("savegame.txt");
      

          if (temp.length() > 0){
    	 
        String[] tokens = temp.split("-");
        
        
        p1.name = tokens[0];
        p1.max_health = Integer.parseInt(tokens[1]);
        p1.current_health= Integer.parseInt(tokens[2]);
        p1.gold= Integer.parseInt(tokens[3]);
        p1.exp = Integer.parseInt(tokens[4]);
        p1.level = Integer.parseInt(tokens[5]);
        p1.levelupexp = Integer.parseInt(tokens[6]);
        p1.sizeof_inventory = Integer.parseInt(tokens[7]);
        monster_1.setVisibility(View.INVISIBLE);
        monster_2.setVisibility(View.INVISIBLE);
        monster_3.setVisibility(View.INVISIBLE);
        monster_4.setVisibility(View.INVISIBLE);
        monster_5.setVisibility(View.INVISIBLE);
        int j=8; //8 because of # of preceeding items
        
        
        String item_name;
        
        
        ///////////////BEGINNING OF ITEM SELECTION BLOCK//////////////////
        
        for (int i = 0; i<p1.sizeof_inventory;i++)
        {
          j++;
          item_name = tokens[8+i];
          
          
          //TODO: CHANGE VALUES HERE TO NEW NAMES
          if (item_name.equals(new cloth().name))
            {
              p1.inventory[i] = null;
              p1.inventory[i] = new cloth();
            }
          if (item_name.equals(new club().name))
          {
            
            p1.inventory[i] = null;
            p1.inventory[i] = new club();
          }
          if (item_name.equals(new dagger().name))
          {
            
            p1.inventory[i] = null;
            p1.inventory[i] = new dagger();
          }
          if (item_name.equals(new empty_slot().name))
          {
          p1.inventory[i] = null;
          p1.inventory[i] = new empty_slot();
          }
          if (item_name.equals(new greataxe().name))
          {
          p1.inventory[i] = null;
          p1.inventory[i] = new greataxe();
          }
          if (item_name.equals(new leather().name))
          {
          p1.inventory[i] = null;
            p1.inventory[i] = new leather();
          }
          if (item_name.equals(new plate().name))
          {
          p1.inventory[i] = null;
            p1.inventory[i] = new plate();
          }
          if (item_name.equals(new potion('h',10).name))
          {
            
          p1.inventory[i] = null;
          p1.inventory[i] = new potion('h',10);
          }
          if (item_name.equals(new potion('h',35).name))
          {
          p1.inventory[i] = null;
          p1.inventory[i] = new potion('h',35);
          }
          if (item_name.equals(new potion('h',60)))
          {
          p1.inventory[i] = null;
          p1.inventory[i] = new potion('h',60);
          }
          if (item_name.equals("Mega Blaster"))
            {
            
              p1.inventory[i] = null;
              p1.inventory[i] = new rainbow();
              p1.inventory[i].name = "Mega Blaster";
              p1.inventory[i].special_effect = (char)'F';
            }
          if (item_name.equals("Magic Handwarmers"))
          {
            
              p1.inventory[i] = null;
            p1.inventory[i] = new rainbow();
            p1.inventory[i].name = "Magic Handwarmers";
            p1.inventory[i].special_effect = (char)'P';
          }
          if (item_name.equals("Evil looking thingy"))
          {
              p1.inventory[i] = null;
            p1.inventory[i] = new rainbow();
            p1.inventory[i].name = "Evil looking thingy";
            p1.inventory[i].special_effect = (char)'C';
          }
          if (item_name.equals(new ring().name))
          {
            p1.inventory[i] = null;
          p1.inventory[i] = new ring();}
          if (item_name.equals(new spell_resistant_leather().name))
          {
            p1.inventory[i] = null;
          p1.inventory[i] = new spell_resistant_leather();}
          if (item_name.equals(new spell_resistant_plate().name))
          {
            p1.inventory[i] = null;
          p1.inventory[i] = new spell_resistant_plate();}
          
          if (item_name.equals("ray gun"))
          {
            p1.inventory[i] = null;
          p1.inventory[i] = new staff();
            p1.inventory[i].name = "ray gun";
            p1.inventory[i].special_effect = (char)'F';
          }
        if (item_name.equals("glowing rod"))
        {
          p1.inventory[i] = null;
          p1.inventory[i] = new staff();
          p1.inventory[i].name = "glowing rod";
          p1.inventory[i].special_effect = (char)'P';
        }
        if (item_name.equals("nasty looking device"))
        {
          p1.inventory[i] = null;
          p1.inventory[i] = new staff();
          p1.inventory[i].name = "nasty looking device";
          p1.inventory[i].special_effect = (char)'C';
        }
        if (item_name.equals("a hard stick"))
          {
            p1.inventory[i] = null;
            p1.inventory[i] = new stick();}
          if (item_name.equals(new sword().name))
          {
            p1.inventory[i] = null;
            p1.inventory[i] = new sword();}
          if (item_name.equals(new two_handed_sword().name))
          {
            p1.inventory[i] = null;
            p1.inventory[i] = new two_handed_sword();}
        
          
          if (item_name.equals("red alien goo"))
          {
            p1.inventory[i] = null;
            p1.inventory[i] = new wand();
            p1.inventory[i].name = "goo covered shoe";
            p1.inventory[i].special_effect = (char)'f';
          }
        if (item_name.equals("green alien goo"))
        {
          p1.inventory[i] = null;
          p1.inventory[i] = new wand();
          p1.inventory[i].name = "water bottle";
          p1.inventory[i].special_effect = (char)'p';
        }
        if (item_name.equals("black alien goo"))
        {
          p1.inventory[i] = null;
          p1.inventory[i] = new wand();
          p1.inventory[i].name = "sock with a grapefruit";
          p1.inventory[i].special_effect = (char)'c';
        }
        
        
        
        }
        
        ///////////////END OF ITEM SELECTION BLOCK//////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        ///////////////BEGIN EQUIPPED WEAPON SELECTION BLOCK//////////////////
        item_name = tokens[j];
        
        if (item_name.equals(new club().name))
          p1.equipped_weapon = new club();
        if (item_name.equals(new dagger().name))
          p1.equipped_weapon = new dagger();
        if (item_name.equals(new greataxe().name))
          p1.equipped_weapon = new greataxe();
        if (item_name.equals("Mega Blaster"))
          {
            p1.equipped_weapon = new rainbow();
            p1.equipped_weapon.name = "Mega Blaster";
            p1.equipped_weapon.special_effect = (char)'F';
          }
        if (item_name.equals("Magic Handwarmers"))
        {
          p1.equipped_weapon = new rainbow();
          p1.equipped_weapon.name = "Magic Handwarmers";
          p1.equipped_weapon.special_effect = (char)'P';
        }
        if (item_name.equals("Evil looking thingy"))
        {
          p1.equipped_weapon = new rainbow();
          p1.equipped_weapon.name = "Evil looking thingy";
          p1.equipped_weapon.special_effect = (char)'C';
        }
        
        if (item_name.equals("ray gun"))
        {
          p1.equipped_weapon = new staff();
          p1.equipped_weapon.name = "ray gun";
          p1.equipped_weapon.special_effect = (char)'F';
        }
      if (item_name.equals("glowing rod"))
      {
        p1.equipped_weapon = new staff();
        p1.equipped_weapon.name = "glowing rod";
        p1.equipped_weapon.special_effect = (char)'P';
      }
      if (item_name.equals("nasty looking device"))
      {
        p1.equipped_weapon = new staff();
        p1.equipped_weapon.name = "nasty looking device";
        p1.equipped_weapon.special_effect = (char)'C';
      }
      if (item_name.equals(new stick().name))
          p1.equipped_weapon = new stick();
        if (item_name.equals(new sword().name))
          p1.equipped_weapon = new sword();
        if (item_name.equals(new two_handed_sword().name))
          p1.equipped_weapon = new two_handed_sword();
      
        
        if (item_name.equals("red alien goo"))
        {
          p1.equipped_weapon = new wand();
          p1.equipped_weapon.name = "red alien goo";
          p1.equipped_weapon.special_effect = (char)'f';
        }
      if (item_name.equals("green alien goo"))
      {
        p1.equipped_weapon = new wand();
        p1.equipped_weapon.name = "green alien goo";
        p1.equipped_weapon.special_effect = (char)'p';
      }
      if (item_name.equals("black alien goo"))
      {
        p1.equipped_weapon = new wand();
        p1.equipped_weapon.name = "black alien goo";
        p1.equipped_weapon.special_effect = (char)'c';
      }
        
        
        /////////////END EQUIPPED WEAPON SELECTION BLOCK////////////////
      
      item_name = tokens[j+1];
      ///////////BEGIN EQUIPPED ARMOR SELECTION BLOCK///////////////////
      if (item_name.equals(new cloth().name))
          p1.equipped_armor = new cloth();
        if (item_name.equals(new leather().name))
          p1.equipped_armor = new leather();
        if (item_name.equals(new plate().name))
          p1.equipped_armor = new plate();
        
        if (item_name.equals(new ring().name))
          p1.equipped_armor = new ring();
        if (item_name.equals("enchanted leather armor"))
          p1.equipped_armor = new spell_resistant_leather();
        if (item_name.equals("enchanted plate armor"))
          p1.equipped_armor = new spell_resistant_plate();
        
        
      ////////////END ARMOR SELECTION BLOCK//////////////////
        //DEFEATED KRAKEN TAB
        p1.has_defeated_kraken = tokens[j+2].charAt(0);
        p1.update_player_health();
      p1.current_room.generate_new_monsters();
      
        p1.current_room = p1.game_world_map[Integer.parseInt(tokens[j+2])][Integer.parseInt(tokens[j+3])];
        monster_health.setVisibility(View.INVISIBLE);
        p1.current_room.room_info();
        status_button.setVisibility(View.VISIBLE);
        player_health.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);
        
        //temp+p1.equipped_weapon.value+"-"+p1.equipped_armor.value+"-"+p1.current_room.x+"-"+p1.current_room.y;
          
        
          
        
      
    	 
    	  
      }}
    });
    
    
    
    
    
    
    
    
    
      
        
    /////////////////////////////////////////////
    
    
    
    
    fight.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        
        p1.user_input_fight();
      }
    });

    monster_1.setOnClickListener(new View.OnClickListener() {
    
    @Override
    public void onClick(View v) {
      
      p1.user_input_fight_monster(0);
    }
  });
    
    monster_2.setOnClickListener(new View.OnClickListener() {
    
    @Override
    public void onClick(View v) {
      
      p1.user_input_fight_monster(1);
    }
  });

      monster_3.setOnClickListener(new View.OnClickListener() {
  
  @Override
  public void onClick(View v) {
    
    p1.user_input_fight_monster(2);
  }
});
      
      monster_4.setOnClickListener(new View.OnClickListener() {
  
  @Override
  public void onClick(View v) {
    
    p1.user_input_fight_monster(3);
  }
});

      monster_5.setOnClickListener(new View.OnClickListener() {
  
  @Override
  public void onClick(View v) {
    
    p1.user_input_fight_monster(4);
  }
});
      
      
      
      //TODO: NEW STORE ACTIVITY
      status_button.setOnClickListener(new View.OnClickListener() {
          
          @Override
          public void onClick(View v) {
            
          
            Intent nextScreen = new Intent(MainActivity.this,inventory_activity.class);
            
            
            //SEND INFO
            nextScreen.putExtra("current_health",p1.current_health);
        nextScreen.putExtra("max_health",p1.max_health);
        nextScreen.putExtra("current_xp",p1.exp);
        nextScreen.putExtra("max_xp",p1.levelupexp);
        nextScreen.putExtra("level",p1.level);
        nextScreen.putExtra("gold",p1.gold);
        nextScreen.putExtra("sizeof_inventory",p1.sizeof_inventory);
        nextScreen.putExtra("weapon_name",p1.equipped_weapon.name);
        nextScreen.putExtra("armor_name",p1.equipped_armor.name);
            
            String item_name;
            String temp;
            for (int i = 0; i<p1.sizeof_inventory; i++)
            {
              temp = Integer.toString(i);
              item_name="item_"+temp;
              nextScreen.putExtra(item_name,p1.inventory[i].image);
            }
            //nextScreen.putExtra("Player",p1);
            //nextScreen.putExtra("Player",p1);
            //nextScreen.putExtra("Player",p1);
            
            //nextScreen.putExtra("Player",p1);
            
            
            //GlobalMembersPlayer.delay(2000);
            
            
            startActivityForResult(nextScreen,100);
            
          }
        });
      
      
      
      
      /////////BUY STORE BUTTON
      store.setOnClickListener(new View.OnClickListener() {
          
          @Override
          public void onClick(View v) {
            
          if (p1.current_room.x==1 && p1.current_room.y==3){
            Intent nextScreen = new Intent(MainActivity.this,BuyActivity.class);
            
            
            //SEND INFO
            nextScreen.putExtra("gold",p1.gold);
          
            startActivityForResult(nextScreen,200);
          }//REGULAR STORE
          
          if (p1.current_room.x==5 && p1.current_room.y==4){
              Intent nextScreen = new Intent(MainActivity.this,SellAlienActivity.class);
              
              
              //SEND INFO
              nextScreen.putExtra("gold",p1.gold);
            
              startActivityForResult(nextScreen,400);
            }//REGULAR STORE
          
          }
        });
      
      
      ////////SELL BUTTON
     
      
sell.setOnClickListener(new View.OnClickListener() {
          
          @Override
          public void onClick(View v) {
            
          
            Intent nextScreen = new Intent(MainActivity.this,SellActivity.class);
            
            
            //SEND INFO
            nextScreen.putExtra("sizeof_inventory",p1.sizeof_inventory);
            
            
            String item_name;
            String temp;
            for (int i = 0; i<p1.sizeof_inventory; i++)
            {
              temp = Integer.toString(i);
              item_name="item_"+temp;
              nextScreen.putExtra(item_name,p1.inventory[i].image);
            }
            //nextScreen.putExtra("Player",p1);
            //nextScreen.putExtra("Player",p1);
            //nextScreen.putExtra("Player",p1);
            
            //nextScreen.putExtra("Player",p1);
            
            
            //GlobalMembersPlayer.delay(2000);
            
            
            startActivityForResult(nextScreen,300);
            
          }
        });
      

	quit.setOnClickListener(new View.OnClickListener() {
        
        @Override
        public void onClick(View v) {
          /*
          Intent intent = new Intent(Intent.ACTION_MAIN);
          intent.addCategory(Intent.CATEGORY_HOME);
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);*/
        	android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        	
          
        }
      });



    }
    
      @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
          if (requestCode == 100) {

               if(resultCode == RESULT_OK){      
                   int index=data.getIntExtra("result",-1);       
                   if (!(index==-1))
                   {
                     if (p1.inventory[index].type == 'w')
                       {
                       
                       weapon w1 = (weapon)(p1.inventory[index]);
                       p1.use_item_w(w1, index);
                       }
                     if (p1.inventory[index].type == 'a')
                     {
                       armor a1 = (armor)(p1.inventory[index]);
                       p1.use_item_a(a1, index);
                     }
                     if (p1.inventory[index].type == 'p')
                     {
                       potion p = (potion)(p1.inventory[index]);
                       p1.use_item_p(p, index);
                     }
                   }
                   
               }
               if (resultCode == RESULT_CANCELED) {    
                   //Write your code if there's no result
               }
            }
          if (requestCode == 200)
          {
            if(resultCode == RESULT_OK){      
              int index=data.getIntExtra("result",-1);         
              //TODO: INSERT STORE FUNCTION
              	//0= SHARP STICK
        		//1=WIFFLE
        		//2=PAN
        		//3=HOODIE
        		//4=FANCY JACKET
        		//5=POTION
              if (!(index==-1))
                  {
            	  
            	  
                  	if (index==0) //SHARP STICK
                  	{
                  		if (p1.gold>=(20))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new dagger(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new dagger();
	                  	   
	                  	   p1.gold-=20;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	if (index==1) //Wiffle
                  	{
                  		if (p1.gold>=(50))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new club(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new club();
	                  	   
	                  	   p1.gold-=50;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	if (index==2) //Pan
                  	{
                  		if (p1.gold>=(100))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new sword(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new sword();
	                  	   
	                  	   p1.gold-=100;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	if (index==3) //Pan
                  	{
                  		if (p1.gold>=(50))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new leather(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new leather();
	                  	   
	                  	   p1.gold-=50;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	
                  	if (index==4) //ring
                  	{
                  		if (p1.gold>=(200))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new ring(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new ring();
	                  	   
	                  	   p1.gold-=200;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	if (index==5) //Pan
                  	{
                  		if (p1.gold>=(80))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new potion('h',10); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new potion('h',10);
	                  	   
	                  	   p1.gold-=80;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  }
            }
             if (resultCode == RESULT_CANCELED) {    
                   //Write your code if there's no result
               }
          }
          
          if (requestCode == 300) {//SELL ITEM

              if(resultCode == RESULT_OK){      
                  int index=data.getIntExtra("result",-1);       
                  if (!(index==-1))
                  {
                    p1.sell_item(index);
                  }
                  
              }
              if (resultCode == RESULT_CANCELED) {    
                  //Write your code if there's no result
              }
          
          
          }
          
          ///BUY ITEM 2 BEGIN
          if (requestCode == 400)
          {
            if(resultCode == RESULT_OK){      
              int index=data.getIntExtra("result",-1);         
              //TODO: INSERT STORE FUNCTION
              	//0= WAND
        		//1=GREATAXE
        		//2=STAFF
        		//3=PLATE
        		//4=SPELL_RESISTANT_LEATHER
        		//5=POTION3
              if (!(index==-1))
                  {
            	  
            	  
                  	if (index==0) //WAND
                  	{
                  		if (p1.gold>=500)
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new wand(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new wand();
	                  	   
	                  	   p1.gold-=500;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	if (index==1) //greataxe
                  	{
                  		if (p1.gold>=(1000))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new greataxe(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new greataxe();
	                  	   
	                  	   p1.gold-=1000;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	if (index==2) //staff
                  	{
                  		if (p1.gold>=(2000))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new staff(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new staff();
	                  	   
	                  	   p1.gold-=2000;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	if (index==3) //plate
                  	{
                  		if (p1.gold>=(1500))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new plate(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new plate();
	                  	   
	                  	   p1.gold-=1500;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	
                  	if (index==4) //battlearmor
                  	{
                  		if (p1.gold>=(3000))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new spell_resistant_leather(); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new spell_resistant_leather();
	                  	   
	                  	   p1.gold-=3000;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	if (index==5) //Pot3
                  	{
                  		if (p1.gold>=(3000))
                  		{
	                  		int has_empty = -1;
	                  	   for (int i = 0;  i< p1.sizeof_inventory; i++)
	                  	    {
	                  	      if (p1.inventory[i].type =='0')
	                  	      {
	                  	        has_empty=i;
	                  	      }
	                  	    }
	                  	   if (has_empty==-1)
	                  	   {
	                  		   
	                  	   p1.inventory[p1.sizeof_inventory] = new potion('h',60); //adds loot to inventory
	                  	   if (!(p1.sizeof_inventory==15)) p1.sizeof_inventory++;
	                  	   else MainActivity.appendTextAndScroll("Your backpack is full. An item was dropped.\n");
	                  	   } //set inventory marker to next inventory slot
	                  	   else p1.inventory[has_empty] =  new potion('h',60);
	                  	   
	                  	   p1.gold-=3000;
                  		}
                  		else
                  		{
                  			appendTextAndScroll("You don't have enough $ for that.\n");
                  		}
                  	
              		}
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  	
                  }
            }
             if (resultCode == RESULT_CANCELED) {    
                   //Write your code if there's no result
               }
          }//BUY ITEM2 END
          
          
          
          }//onActivityResult
      
      

        
        
        public void save_function(String filename, String data)
        {
           try
              {
                  FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                  fos.write(data.getBytes());
                  fos.close();
                  appendTextAndScroll("File successfully saved.\n");
              }
              catch (Exception ex)
              {
                appendTextAndScroll("Error saving file: " + ex.getLocalizedMessage());
              }
        }
        
    
      
        public String load_function(String filename)
        {
            try
            {
                FileInputStream fis = openFileInput(filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                String line = null, input="";
                while ((line = reader.readLine()) != null)
                    input += line;
                reader.close();
                fis.close();
                appendTextAndScroll("File successfully loaded.");
                return input;
            }
            catch (Exception ex)
            {
              appendTextAndScroll("Error loading file: " + ex.getLocalizedMessage());
                return "";
            }
        }
    
    
    
    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
