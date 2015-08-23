package com.rvce.miniproject3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends Activity {

	String user="";
	String passwd="";
	String s1="Ashwin";
	String s2="ashwin93";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		final EditText uname=(EditText)findViewById(R.id.name);
		final EditText pwd=(EditText)findViewById(R.id.password);
		
		Button auth=(Button)findViewById(R.id.auth);
		auth.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				user=uname.getText().toString();
				passwd=pwd.getText().toString();
				boolean b= user.equals(s1) && passwd.equals(s2);
				if(!b){
					
					Toast.makeText(getApplicationContext(), "Cannot Authenticate,Please Reenter", Toast.LENGTH_LONG).show();
				}
				else{
					Intent i= new Intent(getApplicationContext(),AdminEdit.class);
					startActivity(i);
					finish();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
		return true;
	}

}
