package com.rvce.miniproject3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashScreen extends Activity {
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
         
// METHOD 1     
         
         /****** Create Thread that will sleep for 8 seconds *************/        
        Thread background = new Thread() {
            public void run() {
                 
                try {
                    // Thread will sleep for 8 seconds
                    sleep(8*1000);
                     
                    // After 8 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),About.class);
                    startActivity(i);
                     
                    //Remove activity
                    finish();
                     
                } catch (Exception e) {
                 
                }
            }
        };
         
        // start thread
        background.start();
         
//METHOD 2  
         
        /*
        new Handler().postDelayed(new Runnable() {
              
            // Using handler with postDelayed called runnable run method
  
            @Override
            public void run() {
                Intent i = new Intent(MainSplashScreen.this, FirstScreen.class);
                startActivity(i);
  
                // close this activity
                finish();
            }
        }, 5*1000); // wait for 5 seconds
        */
    }
     
    @Override
    protected void onDestroy() {
         
        super.onDestroy();
         
    }
}