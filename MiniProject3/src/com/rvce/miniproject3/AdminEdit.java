package com.rvce.miniproject3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AdminEdit extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_edit);
		Button medicine=(Button)findViewById(R.id.medicine);
		Button shop=(Button)findViewById(R.id.shop);
		Button locality=(Button)findViewById(R.id.locality);
		Button inventory=(Button)findViewById(R.id.inventory);
		medicine.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(getApplicationContext(),AddMedicine.class);
				startActivity(i);
			}
		});
		
shop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(getApplicationContext(),AddShop.class);
				startActivity(i);
			}
		});

locality.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		Intent i=new Intent(getApplicationContext(),AddLocality.class);
		startActivity(i);
	}
});

inventory.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		Intent i=new Intent(getApplicationContext(),Inventory.class);
		startActivity(i);
	}
});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_edit, menu);
		return true;
	}

}
