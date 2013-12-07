package gamepackage.rpg_test_1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class inventory_activity extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_screen);
        
        TextView health_text = (TextView) findViewById(R.id.current_health_text);
        TextView xp_text= (TextView) findViewById(R.id.current_xp_text);
        TextView level_text = (TextView) findViewById(R.id.current_level_text);
        TextView gold_text = (TextView) findViewById(R.id.current_gold_text);
        TextView weapon_text = (TextView) findViewById(R.id.weapon_name_text);
        TextView armor_text = (TextView) findViewById(R.id.armor_name_text);
        
        
        ImageButton item1 = (ImageButton) findViewById(R.id.button1);
        ImageButton item2 = (ImageButton) findViewById(R.id.button2);
        ImageButton item3 = (ImageButton) findViewById(R.id.button3);
        ImageButton item4 = (ImageButton) findViewById(R.id.button4);
        ImageButton item5 = (ImageButton) findViewById(R.id.button5);
        ImageButton item6 = (ImageButton) findViewById(R.id.button6);
        ImageButton item7 = (ImageButton) findViewById(R.id.button7);
        ImageButton item8 = (ImageButton) findViewById(R.id.button8);
        ImageButton item9 = (ImageButton) findViewById(R.id.button9);
        ImageButton item10 = (ImageButton) findViewById(R.id.button10);
        ImageButton item11 = (ImageButton) findViewById(R.id.button11);
        ImageButton item12 = (ImageButton) findViewById(R.id.button12);
        ImageButton item13 = (ImageButton) findViewById(R.id.button13);
        ImageButton item14 = (ImageButton) findViewById(R.id.button14);
        ImageButton item15 = (ImageButton) findViewById(R.id.button15);
        ImageButton item16 = (ImageButton) findViewById(R.id.button16);
        Button exitbutton = (Button) findViewById(R.id.exit_button);
        
        item1.setBackground(null);
        item2.setBackground(null);
        item3.setBackground(null);
        item4.setBackground(null);
        item5.setBackground(null);
        item6.setBackground(null);
        item7.setBackground(null);
        item8.setBackground(null);
        item9.setBackground(null);
        item10.setBackground(null);
        item11.setBackground(null);
        item12.setBackground(null);
        item13.setBackground(null);
        item14.setBackground(null);
        item15.setBackground(null);
        item16.setBackground(null);
        
        
      //GET INFO
		int current_health = getIntent().getIntExtra("current_health",0);
		int max_health = getIntent().getIntExtra("max_health",0);
		int current_xp = getIntent().getIntExtra("current_xp",0);
		int max_xp = getIntent().getIntExtra("max_xp",0);
		int level = getIntent().getIntExtra("level",0);
		int gold = getIntent().getIntExtra("gold",0);
		int sizeof_inventory = getIntent().getIntExtra("sizeof_inventory",0);
		
		
		//Set labels
		health_text.setText(Integer.toString(current_health)+"/"+Integer.toString(max_health));
		xp_text.setText(Integer.toString(current_xp)+"/"+Integer.toString(max_xp));
		level_text.setText(Integer.toString(level));
		gold_text.setText(Integer.toString(gold));
		weapon_text.setText(getIntent().getStringExtra("weapon_name"));
		armor_text.setText(getIntent().getStringExtra("armor_name"));
		
		String item_name;
		int temp;
		String temp2;
		
		for (int i = 0; i<sizeof_inventory; i++)
		{
			temp2 = Integer.toString(i);
			item_name="item_"+temp2;
			temp = getIntent().getIntExtra(item_name,0);
			switch (i)
			{
			case 0:
				item1.setImageResource(temp);
				item1.setVisibility(View.VISIBLE);
				break;
			case 1:
				item2.setImageResource(temp);
				item2.setVisibility(View.VISIBLE);
				break;
			case 2:
				item3.setImageResource(temp);
				item3.setVisibility(View.VISIBLE);
				break;
			case 3:
				item4.setImageResource(temp);
				item4.setVisibility(View.VISIBLE);
				break;
			case 4:
				item5.setImageResource(temp);
				item5.setVisibility(View.VISIBLE);
				break;
			case 5:
				item6.setImageResource(temp);
				item6.setVisibility(View.VISIBLE);
				break;
			case 6:
				item7.setImageResource(temp);
				item7.setVisibility(View.VISIBLE);
				break;
			case 7:
				item8.setImageResource(temp);
				item8.setVisibility(View.VISIBLE);
				break;
			case 8:
				item9.setImageResource(temp);
				item9.setVisibility(View.VISIBLE);
				break;
			case 9:
				item10.setImageResource(temp);
				item10.setVisibility(View.VISIBLE);
				break;
			case 10:
				item11.setImageResource(temp);
				item11.setVisibility(View.VISIBLE);
				break;
			case 11:
				item12.setImageResource(temp);
				item12.setVisibility(View.VISIBLE);
				break;
			case 12:
				item13.setImageResource(temp);
				item13.setVisibility(View.VISIBLE);
				break;
			case 13:
				item14.setImageResource(temp);
				item14.setVisibility(View.VISIBLE);
				break;
			case 14:
				item15.setImageResource(temp);
				item15.setVisibility(View.VISIBLE);
				break;
			case 15:
				item16.setImageResource(temp);
				item16.setVisibility(View.VISIBLE);
				break;
			}
		}
    
		exitbutton.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",-1); //-1 for no action
	   			setResult(RESULT_OK,returnIntent);     
	   			
	   			finish();
	   		}
	   	});
		
		
		item1.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",0);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item2.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",1);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item3.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",2);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item4.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",3);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item5.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",4);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item6.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",5);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item7.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",6);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item8.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",7);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item9.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",8);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item10.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",9);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item11.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",10);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		item12.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",11);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item13.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",12);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item14.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",13);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item15.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",14);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		item16.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",15);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        
        //Receiving the Data
     //   Player p1 = getIntent().getSerializableExtra("Player");
        
	}
}
