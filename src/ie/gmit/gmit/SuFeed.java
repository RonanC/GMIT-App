package ie.gmit.gmit;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Build;

/*
 * This activity implements a webview for displaying the Student Union Facebook Feed
 * Eventually I would like to be able to get the data directly and put it into a notification
 */

public class SuFeed extends Activity {
	WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_su_feed);
		
//		WebView webview = new WebView(this);
//		setContentView(webview);
//		String url = "https://www.facebook.com/gmit.su1";
//		webview.loadUrl(url);
		
		//WebView webview = (WebView)findViewById(R.id.webView1);
		//Uri uri = Uri.parse("https://www.facebook.com/gmit.su1");
		//Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		//startActivity(intent);	
		
		setTitle("Student Union News");
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_su_feed);

		webView = (WebView) findViewById(R.id.suFeed);  
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.setWebViewClient(new PortalClient());
		try{
			webView.loadUrl("https://www.facebook.com/gmit.su1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this lets the user go back a webpage, otherwise go back an activity
	@Override
	public void onBackPressed() {
		if(webView.canGoBack()) webView.goBack();
		else super.onBackPressed();
	}	
	
	// this loads the url into our own webview (overrides the default device launcher)
	private class PortalClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.su_feed, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
		case android.R.id.home:
			// this is called when the Home (up) button is pressed in the action bar
			Intent parentActivityIntent = new Intent(this, MainActivity.class);
			parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(parentActivityIntent);
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
