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
public class AddShop extends Activity
{
    /** Called when the activity is first created. */
 
    Button search;
    Button searchmap;
    String shop_id="";
    String locality_id="";
    String shop_name="";
    String shop_address="";
    String pincode="";
    String cperson="";
    String contel="";
    String cemail="";
    //String ed="";
    EditText shopid;
    EditText locid;
    EditText sname;
    EditText saddress;
    EditText pcode;
    EditText cpr;
    EditText ctel;
    EditText cml;
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
        setContentView(R.layout.activity_add_shop);
        
        if( Build.VERSION.SDK_INT >= 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy); 
     }
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        
        shopid= (EditText) findViewById(R.id.sid);

      sname= (EditText) findViewById(R.id.ShopName);
         
       locid= (EditText) findViewById(R.id.localityid);
       
       saddress= (EditText) findViewById(R.id.address);
       pcode= (EditText) findViewById(R.id.pincode);
      
       ctel= (EditText) findViewById(R.id.ct);
       
       cpr= (EditText) findViewById(R.id.cp);
       cml= (EditText) findViewById(R.id.cm);
       
      search=(Button)findViewById(R.id.button1);
 
        //String Str_user = app_preferences.getString("area","0" );
        //String Str_pass = app_preferences.getString("password", "0");
       // String Str_check = app_preferences.getString("checked", "no");
      
        search.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                shop_id = shopid.getText().toString();
                locality_id=locid.getText().toString();
                shop_name=sname.getText().toString();
                shop_address=saddress.getText().toString();
                pincode=pcode.getText().toString();
                contel=ctel.getText().toString();
                cperson=cpr.getText().toString();
                cemail=cml.getText().toString();
                //area1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
               // pass = password.getText().toString();
                //String Str_check2 = app_preferences.getString("checked", "no");
               //boolean b= area.equals("") && drugname.equals("");
               
                if(shop_id.length()==0)
                {
                     Toast.makeText(AddShop.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                }
                else if(locality_id.length()==0)
                	Toast.makeText(AddShop.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(shop_name.length()==0)
                	Toast.makeText(AddShop.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(shop_address.length()==0)
                	Toast.makeText(AddShop.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(pincode.length()==0)
                	Toast.makeText(AddShop.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(cperson.length()==0)
                	Toast.makeText(AddShop.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(contel.length()==0)
                	Toast.makeText(AddShop.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(cemail.length()==0)
                	Toast.makeText(AddShop.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else
                {
 
 
                try {
                	
                	
                    httpclient = new DefaultHttpClient();
                    httppost = new HttpPost("http://192.168.43.96:6886/shop.php");
                    // Add your data
                    nameValuePairs = new ArrayList<NameValuePair>(8);
                   nameValuePairs.add(new BasicNameValuePair("ShopID", shop_id.trim()));
                    nameValuePairs.add(new BasicNameValuePair("LocalityID", locality_id.trim()));
                    nameValuePairs.add(new BasicNameValuePair("ShopName", shop_name.trim()));
                    nameValuePairs.add(new BasicNameValuePair("ShopAddress", shop_address.trim()));
                    nameValuePairs.add(new BasicNameValuePair("Pincode", pincode.trim()));
                    nameValuePairs.add(new BasicNameValuePair("ContactPerson", cperson.trim()));
                    nameValuePairs.add(new BasicNameValuePair("ContactTel", contel.trim()));
                    nameValuePairs.add(new BasicNameValuePair("ContactEmail", cemail.trim()));
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
                    Intent intent= new Intent(getApplicationContext(),WebView3.class);
                	intent.putExtra("Area_intent", seq2.toString());
                    startActivity(intent);
                    
                    inputStream.close();
                    finish();
                   // new SearchResult().execute();
                }
 
                catch (Exception e)
                {
                    Toast.makeText(AddShop.this, "error"+e.toString(), Toast.LENGTH_LONG).show();
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
