package gamepackage.rpg_test_1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class BuyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
		
		TextView buy_gold_text = (TextView) findViewById(R.id.buy_gold_text);
		
		ImageButton buy_sharp_stick = (ImageButton) findViewById(R.id.buy_sharp_stick);
        ImageButton buy_wiffle_bat= (ImageButton) findViewById(R.id.buy_wiffle_bat);
        ImageButton buy_frying_pan = (ImageButton) findViewById(R.id.buy_frying_pan);
        ImageButton buy_hoodie = (ImageButton) findViewById(R.id.buy_hoodie);
        ImageButton buy_fancy_jacket = (ImageButton) findViewById(R.id.buy_fancy_jacket);
        ImageButton buy_potion = (ImageButton) findViewById(R.id.buy_potion);
        
        Button exitbutton = (Button) findViewById(R.id.buy_exit_button);
		
		
		
		buy_sharp_stick.setBackground(null);
		buy_wiffle_bat.setBackground(null);
		buy_frying_pan.setBackground(null);
		buy_hoodie.setBackground(null);
		buy_fancy_jacket.setBackground(null);
		buy_potion.setBackground(null);
		
		
		
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
		
		
		buy_sharp_stick.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",0);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		buy_wiffle_bat.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",1);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		
		buy_frying_pan.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",2);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		
		buy_hoodie.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",3);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		buy_fancy_jacket.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",4);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		
		buy_potion.setOnClickListener(new View.OnClickListener() {
	   		
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
