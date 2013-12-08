package gamepackage.rpg_test_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SellActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		// Show the Up button in the action bar.
		
	
		
		ImageButton sell1 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton sell2 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton sell3 = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton sell4 = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton sell5 = (ImageButton) findViewById(R.id.imageButton5);
		ImageButton sell6 = (ImageButton) findViewById(R.id.imageButton6);
		ImageButton sell7 = (ImageButton) findViewById(R.id.imageButton7);
		ImageButton sell8 = (ImageButton) findViewById(R.id.imageButton8);
		ImageButton sell9 = (ImageButton) findViewById(R.id.imageButton9);
		ImageButton sell10 = (ImageButton) findViewById(R.id.imageButton10);
		ImageButton sell11 = (ImageButton) findViewById(R.id.imageButton11);
		ImageButton sell12 = (ImageButton) findViewById(R.id.imageButton12);
		ImageButton sell13 = (ImageButton) findViewById(R.id.imageButton13);
		ImageButton sell14 = (ImageButton) findViewById(R.id.imageButton14);
		ImageButton sell15 = (ImageButton) findViewById(R.id.imageButton15);
		ImageButton sell16 = (ImageButton) findViewById(R.id.imageButton16);
		Button exitbutton = (Button) findViewById(R.id.exit_button_sell);
		
		
		
		sell1.setBackground(null);
		sell2.setBackground(null);
		sell3.setBackground(null);
		sell4.setBackground(null);
		sell5.setBackground(null);
		sell6.setBackground(null);
		sell7.setBackground(null);
		sell8.setBackground(null);
		sell9.setBackground(null);
		sell10.setBackground(null);
		sell11.setBackground(null);
		sell12.setBackground(null);
		sell13.setBackground(null);
		sell14.setBackground(null);
		sell15.setBackground(null);
		sell16.setBackground(null);
		
		String temp2;
		String item_name;
		int temp;
		
		int sizeof_inventory = getIntent().getIntExtra("sizeof_inventory",0);
		
		for (int i = 0; i<sizeof_inventory; i++)
		{
			temp2 = Integer.toString(i);
			item_name="item_"+temp2;
			temp = getIntent().getIntExtra(item_name,0);
			switch (i)
			{
			case 0:
				sell1.setImageResource(temp);
				sell1.setVisibility(View.VISIBLE);
				break;
			case 1:
				sell2.setImageResource(temp);
				sell2.setVisibility(View.VISIBLE);
				break;
			case 2:
				sell3.setImageResource(temp);
				sell3.setVisibility(View.VISIBLE);
				break;
			case 3:
				sell4.setImageResource(temp);
				sell4.setVisibility(View.VISIBLE);
				break;
			case 4:
				sell5.setImageResource(temp);
				sell5.setVisibility(View.VISIBLE);
				break;
			case 5:
				sell6.setImageResource(temp);
				sell6.setVisibility(View.VISIBLE);
				break;
			case 6:
				sell7.setImageResource(temp);
				sell7.setVisibility(View.VISIBLE);
				break;
			case 7:
				sell8.setImageResource(temp);
				sell8.setVisibility(View.VISIBLE);
				break;
			case 8:
				sell9.setImageResource(temp);
				sell9.setVisibility(View.VISIBLE);
				break;
			case 9:
				sell10.setImageResource(temp);
				sell10.setVisibility(View.VISIBLE);
				break;
			case 10:
				sell11.setImageResource(temp);
				sell11.setVisibility(View.VISIBLE);
				break;
			case 11:
				sell12.setImageResource(temp);
				sell12.setVisibility(View.VISIBLE);
				break;
			case 12:
				sell13.setImageResource(temp);
				sell13.setVisibility(View.VISIBLE);
				break;
			case 13:
				sell14.setImageResource(temp);
				sell14.setVisibility(View.VISIBLE);
				break;
			case 14:
				sell15.setImageResource(temp);
				sell15.setVisibility(View.VISIBLE);
				break;
			case 15:
				sell16.setImageResource(temp);
				sell16.setVisibility(View.VISIBLE);
				break;
			}
		
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/////////////////ONCLICK LISTENERS
		/////////////////////////////////////
		//////////////////////////////////////
exitbutton.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",-1); //-1 for no action
	   			setResult(RESULT_OK,returnIntent);     
	   			
	   			finish();
	   		}
	   	});
		
		
		sell1.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",0);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell2.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",1);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell3.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",2);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell4.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",3);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell5.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",4);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell6.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",5);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell7.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",6);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell8.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",7);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell9.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",8);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell10.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",9);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell11.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",10);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		
		sell12.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",11);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell13.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",12);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell14.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",13);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell15.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",14);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		
		sell16.setOnClickListener(new View.OnClickListener() {
	   		
	   		@Override
	   		public void onClick(View v) {
	   			
	   			
	   			Intent returnIntent = new Intent();
	   			returnIntent.putExtra("result",15);
	   			setResult(RESULT_OK,returnIntent);     
	   			finish();
	   			
	   		}
	   	});
		/////////////////////////////////////
		//////////////////////////////////////
		/////////////////////////////////////
		
		
		
		
		
		
	}


}
