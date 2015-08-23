package com.rvce.miniproject3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 

@SuppressLint("NewApi")
public class MydatabaseProject extends Activity
{
    /** Called when the activity is first created. */
 
    Button search;
    Button searchmap;
    String area1="";
    String drugname="";
    EditText area;
    EditText d_name;
    TextView tv;
    byte[] data;
    byte[] data2;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    InputStream inputStream;
    SharedPreferences app_preferences ;
    List<NameValuePair> nameValuePairs;
    CheckBox check;
    
	public void onCreate(Bundle savedInstanceState)
    {
		
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        if( Build.VERSION.SDK_INT >= 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy); 
     }
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        
       area= (EditText) findViewById(R.id.editText1);

       d_name= (EditText) findViewById(R.id.editText2);
         
       search = (Button) findViewById(R.id.login);
       
       //searchmap = (Button)findViewById(R.id.button1);
       
       /*searchmap.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i= new Intent(getApplicationContext(),MapViewActivity.class);
			startActivity(i);
		}
	});*/
     
        //check = (CheckBox) findViewById(R.id.check);
 
        String Str_user = app_preferences.getString("area","0" );
        //String Str_pass = app_preferences.getString("password", "0");
       // String Str_check = app_preferences.getString("checked", "no");
      
        search.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                area1 = area.getText().toString();
                drugname=d_name.getText().toString();
                //area1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
               // pass = password.getText().toString();
                //String Str_check2 = app_preferences.getString("checked", "no");
               //boolean b= area.equals("") && drugname.equals("");
               
                if(drugname.length()==0)
                {
                     Toast.makeText(MydatabaseProject.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                }
                else if(area1.length()==0)
                	Toast.makeText(MydatabaseProject.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else
                {
 
 
                try {
                	
                	
                	
                	
                	
                    httpclient = new DefaultHttpClient();
                    httppost = new HttpPost("http://192.168.1.5:6886/queryphp.php");
                    // Add your data
                    nameValuePairs = new ArrayList<NameValuePair>(2);
                   nameValuePairs.add(new BasicNameValuePair("Area", area1.trim()));
                    nameValuePairs.add(new BasicNameValuePair("DrugName", drugname.trim()));
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
                    // Execute HTTP Post Request
                    response = httpclient.execute(httppost);
                    inputStream = response.getEntity().getContent();
 
                    data = new byte[5096];
                    //data2= new byte[256];
 
                    inputStream.read(data);
                    Charset charset = Charset.forName("UTF-8");
                    CharSequence seq2 = new String(data, charset);
                    //CharSequence seq3 = new String(data2, charset);
                    //Toast.makeText(getApplicationContext(), seq2, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(getApplicationContext(),WebviewActivity.class);
                	intent.putExtra("Area_intent", seq2.toString());
                    startActivity(intent);
                    
                    inputStream.close();
                    finish();
                   // new SearchResult().execute();
                }
 
                catch (Exception e)
                {
                    Toast.makeText(MydatabaseProject.this, "error"+e.toString(), Toast.LENGTH_LONG).show();
                }
               
               
                }
            }
        });
       
    }
        public void Move_to_next()
        {
 
        //  startActivity(new Intent(this, zzz.class));
        }
        
        
        
}
