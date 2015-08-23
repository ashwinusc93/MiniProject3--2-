package com.rvce.miniproject3;

//package com.rvce.miniproject3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class WebView2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		WebView wbv= (WebView) findViewById(R.id.webView1);
		String datafrompost=(String) getIntent().getExtras().get("Area_intent");
		wbv.loadData(datafrompost, "text/html", "UTF-8");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.webview, menu);
		return true;
	}

}

