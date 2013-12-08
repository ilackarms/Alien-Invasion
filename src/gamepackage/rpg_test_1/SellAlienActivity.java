package gamepackage.rpg_test_1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class SellAlienActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell_alien);
		// Show the Up button in the action bar.
TextView buy_gold_text = (TextView) findViewById(R.id.buy_gold_2_text);
		
		ImageButton buy_wand = (ImageButton) findViewById(R.id.buy_wand);
        ImageButton buy_greataxe= (ImageButton) findViewById(R.id.buy_greataxe);
        ImageButton buy_staff = (ImageButton) findViewById(R.id.buy_staff);
        ImageButton buy_plate = (ImageButton) findViewById(R.id.buy_plate);
        ImageButton buy_battle_armor = (ImageButton) findViewById(R.id.buy_battle_armor);
        ImageButton buy_potion3 = (ImageButton) findViewById(R.id.buy_potion3);
        
        Button exitbutton = (Button) findViewById(R.id.sell_alien_exit_button);
		
		
		
		buy_wand.setBackground(null);
		buy_greataxe.setBackground(null);
		buy_staff.setBackground(null);
		buy_plate.setBackground(null);
		buy_battle_armor.setBackground(null);
		buy_potion3.setBackground(null);
		
		
		
		//GET INFO FROM MAINACTIVITY
		int gold = getIntent().getIntExtra("gold",0);
		buy_gold_text.setText(Integer.toString(gold));
		
		
		
		
		
		
		exitbutton.setOnClickListener(new View.OnClickListener() {
			   		
			   		@Override
			   		public void onClick(View v) {
			   			
			   			Intent returnIntent = new Intent();
			   			returnIntent.putExtra("result",-1); //-1 for no action
			   			setResult(RESULT_OK,returnIntent);     
			   			
			   			finish();
			   		}
			   	});
		
		
		buy_wand.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",0);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		buy_greataxe.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",1);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		
		buy_staff.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",2);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		
		buy_plate.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",3);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		buy_battle_armor.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",4);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		
		buy_potion3.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",5);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	/*
	
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buy, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/

}
