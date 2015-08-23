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
public class AddLocality extends Activity
{
    /** Called when the activity is first created. */
 
    Button search;
    Button searchmap;
    String loc_id="";
    String dist_id="";
    String dist_name="";
    String locality="";
    //String ed="";
    EditText locid;
    EditText distid;
    EditText distname;
    EditText locty;
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
        setContentView(R.layout.activity_add_locality);
        
        if( Build.VERSION.SDK_INT >= 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy); 
     }
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        
       locid= (EditText) findViewById(R.id.locid);
       distid= (EditText) findViewById(R.id.did);
       distname=(EditText)findViewById(R.id.dname);
       locty= (EditText) findViewById(R.id.locality);
      // medname= (EditText) findViewById(R.id.medname);
         
      // mrp1= (EditText) findViewById(R.id.mrp);
       
       //unit1= (EditText) findViewById(R.id.unit);
       //pc= (EditText) findViewById(R.id.pc);
       //shopid= (EditText) findViewById(R.id.shopid);
       //stockqty= (EditText) findViewById(R.id.stock);
       
      search=(Button)findViewById(R.id.submit);
 
        //String Str_user = app_preferences.getString("area","0" );
        //String Str_pass = app_preferences.getString("password", "0");
       // String Str_check = app_preferences.getString("checked", "no");
      
        search.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                loc_id =locid.getText().toString();
                //med_name=medname.getText().toString();
                //mrp=mrp1.getText().toString();
                //unit=unit1.getText().toString();
                //company=pc.getText().toString();
                dist_id=distid.getText().toString();
                dist_name=distname.getText().toString();
                locality=locty.getText().toString();
                //area1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
               // pass = password.getText().toString();
                //String Str_check2 = app_preferences.getString("checked", "no");
               //boolean b= area.equals("") && drugname.equals("");
               
                if(loc_id.length()==0)
                {
                     Toast.makeText(AddLocality.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                }
                /*else if(med_id.length()==0)
                	Toast.makeText(AddMedicine.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(mrp.length()==0)
                	Toast.makeText(AddMedicine.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(unit.length()==0)
                	Toast.makeText(AddMedicine.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(company.length()==0)
                	Toast.makeText(AddMedicine.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();*/
                else if(dist_id.length()==0)
                	Toast.makeText(AddLocality.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(dist_name.length()==0)
                	Toast.makeText(AddLocality.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else if(locality.length()==0)
                	Toast.makeText(AddLocality.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                else
                {
 
 
                try {
                	
                	
                    httpclient = new DefaultHttpClient();
                    httppost = new HttpPost("http://192.168.43.96:6886/locality.php");
                    // Add your data
                    nameValuePairs = new ArrayList<NameValuePair>(3);
                   nameValuePairs.add(new BasicNameValuePair("LocalityID", loc_id.trim()));
                    /*nameValuePairs.add(new BasicNameValuePair("MedicineName", med_name.trim()));
                    nameValuePairs.add(new BasicNameValuePair("MRP", mrp.trim()));
                    nameValuePairs.add(new BasicNameValuePair("Unit", unit.trim()));
                    nameValuePairs.add(new BasicNameValuePair("PharmaCompany", company.trim()));*/
                    nameValuePairs.add(new BasicNameValuePair("DistrictID", dist_id.trim()));
                    nameValuePairs.add(new BasicNameValuePair("DistrictName", dist_name.trim()));
                    nameValuePairs.add(new BasicNameValuePair("Locality", locality.trim()));
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
                    Intent intent= new Intent(getApplicationContext(),WebView2.class);
                	intent.putExtra("Area_intent", seq2.toString());
                    startActivity(intent);
                    
                    inputStream.close();
                    finish();
                   // new SearchResult().execute();
                }
 
                catch (Exception e)
                {
                    Toast.makeText(AddLocality.this, "error"+e.toString(), Toast.LENGTH_LONG).show();
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
