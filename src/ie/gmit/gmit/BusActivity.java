package ie.gmit.gmit;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class BusActivity extends Activity {
	WebView webView;
	TextView refresh = null;
	private String link;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		link = "http://www.rtpi.ie/Page_Content/Default/WebSign.aspx?stopRef=522811&stopName=Dublin%20Rd&uid=1366380527197";
		
		setTitle("GMIT Inner City Bus Times");
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_su_feed);

		webView = (WebView) findViewById(R.id.suFeed);  
		
		
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		
		webView.getSettings().setBuiltInZoomControls(true);
		webView.setInitialScale(200);
		
		webView.setWebViewClient(new PortalClient());
		try{
			webView.loadUrl(link);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		new Timer().schedule(new TimerTask(){
//	        @Override
//	        public void run() {
//	             webView.reload();
//	             //Toast.makeText(getBaseContext(), "Refreshing", Toast.LENGTH_SHORT).show();
//	        }}, 60000, 60000);
	
		refresh = (TextView) findViewById(R.id.busRefresh);
		refresh.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), "Refreshing", Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				webView.loadUrl( "javascript:window.location.reload( true )" ); 
				// webView.reload();
				// webView.loadUrl(link);
			}
		});
		
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
