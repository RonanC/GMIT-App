package ie.gmit.gmit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ImageView portalImg = null;
	private ImageView suImg = null;
	private ImageView busImg = null;
	
	private ImageView gallImg = null;	
	private ImageView mapImg = null;
	private ImageView clubImg = null;
	
	private ImageView contactImg = null;
	private ImageView aboutImg = null;
	private ImageView courseImg = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		
		clubImg = (ImageView) findViewById(R.id.portal);
		clubImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), Portal.class);
				startActivity(i);
			}
		});	
		
		suImg = (ImageView) findViewById(R.id.su);
		suImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// use the below to launch webpage in default browser:
//				Uri uri = Uri.parse("https://www.facebook.com/gmit.su1");
//				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//				startActivity(intent);	
				
				Intent i = new Intent(getBaseContext(), SuFeed.class);
				Log.d("GMIT", "StartingActivity");
				startActivity(i);
			}
		});	
		
		
		busImg = (ImageView) findViewById(R.id.bus);
		busImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), BusActivity.class);
				startActivity(i);
			}
		});		
		

		
		
		gallImg = (ImageView) findViewById(R.id.gall);
		gallImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), GalleryActivity.class);
				startActivity(i);
			}
		});				
		
		mapImg = (ImageView) findViewById(R.id.map);
		mapImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), MapActivity.class);
				startActivity(i);
			}
		});				

		clubImg = (ImageView) findViewById(R.id.clubs);
		clubImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), ClubActivity.class);
				startActivity(i);
			}
		});			
		

		
		
		contactImg = (ImageView) findViewById(R.id.about);
		contactImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), AboutActivity.class);
				startActivity(i);
			}
		});					
		
		aboutImg = (ImageView) findViewById(R.id.about);
		aboutImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), AboutActivity.class);
				startActivity(i);
			}
		});			

		courseImg = (ImageView) findViewById(R.id.about);
		courseImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), AboutActivity.class);
				startActivity(i);
			}
		});			
		
		Log.d("GMIT", "done loading image view listeners");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch(id){
//			case R.id.s:
//					Intent i = new Intent(getBaseContext(), AboutActivity.class);
//					startActivity(i);
//							
//				break;
			case R.id.share:
				Intent i = new Intent(android.content.Intent.ACTION_SEND);
				i.setType("text/plain");
				
				String shareBody = "Student Portal, SU News, Bus, Gallery, Map, Clubs/Socs, Contact, About, Courses and more in the GMIT app.\nAvailable on Android.\n\n";
				
				
				i.putExtra(android.content.Intent.EXTRA_SUBJECT, "GMIT App for Android");
				i.putExtra(Intent.EXTRA_TEXT, shareBody + "https://www.facebook.com/gmit.su1");
				
				startActivity(Intent.createChooser(i, "Share via"));
				break;
			default:
				Toast.makeText(getBaseContext(), "Woops, nothing selected", Toast.LENGTH_SHORT).show();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
