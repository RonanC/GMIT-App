/**
 * GMIT Android App project - Mobile Programming
 * GMIT - Lecturer: Brian Costello - 2nd May 2014
 * Student: Ronan Connolly, G00274374
 */

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

/*
 * This activity is the homepage for the app,
 * It contains 9 icons for the main functions
 * It also contains 5 options to choose from
 * All sub activities have the arrow shown on the action bar to be able to go home (similar to the back button)
 */
public class MainActivity extends Activity {
	private ImageView portalImg = null;
	private ImageView suImg = null;
	private ImageView busImg = null;
	
	private ImageView gallImg = null;	
	private ImageView mapImg = null;
	private ImageView clubImg = null;
	
	private ImageView contactImg = null;
	private ImageView notebookImg = null;
	private ImageView courseImg = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}
	
	/*
	 * This init() method sets up the onClickListeners
	 */
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
		

		
		
		contactImg = (ImageView) findViewById(R.id.contactBtn);
		contactImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), Contacts.class);
				startActivity(i);
			}
		});					
		
		notebookImg = (ImageView) findViewById(R.id.notebook);
		notebookImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), NotebookActivity.class);
				startActivity(i);
			}
		});			

		courseImg = (ImageView) findViewById(R.id.courses);
		courseImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), Courses.class);
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

	/*
	 * This method sets up a switch for when an option is selected
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		Intent i;
		int id = item.getItemId();
		switch(id){
			case R.id.share:
				i = new Intent(android.content.Intent.ACTION_SEND);
				i.setType("text/plain");
				
				String shareBody = "Student Portal, SU News, Bus, Gallery, Map, Clubs/Socs, Contact, About, Courses and more in the GMIT app.\nAvailable on Android.\n\n";
				
				
				i.putExtra(android.content.Intent.EXTRA_SUBJECT, "GMIT App for Android");
				i.putExtra(Intent.EXTRA_TEXT, shareBody + "https://www.facebook.com/gmit.su1");
				
				startActivity(Intent.createChooser(i, "Share via"));
				break;

			case R.id.sponsors:
				i = new Intent(getBaseContext(), Sponsors.class);
				startActivity(i);
			break;		
			
			case R.id.scholarships:
				i = new Intent(getBaseContext(), Schol.class);
				startActivity(i);
			break;	
			
			case R.id.facilities:
				i = new Intent(getBaseContext(), Facilities.class);
				startActivity(i);
			break;	
			case R.id.fixtures:
				i = new Intent(getBaseContext(), Fixtures.class);
				startActivity(i);	
			break;	
			
			case R.id.about:
				i = new Intent(getBaseContext(), AboutActivity.class);
				startActivity(i);	
			break;	
			
			case R.id.test:
				i = new Intent(getBaseContext(), Test.class);
				startActivity(i);	
			break;		
			
			default:
				Toast.makeText(getBaseContext(), "Woops, nothing selected", Toast.LENGTH_SHORT).show();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
