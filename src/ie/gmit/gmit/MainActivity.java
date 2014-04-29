package ie.gmit.gmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView clubImg = null;
	private ImageView suImg = null;
	private ImageView mapImg = null;
	private ImageView gallImg = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		
		clubImg = (ImageView) findViewById(R.id.clubs);
		clubImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), ClubActivity.class);
				startActivity(i);
			}
		});		
		
		suImg = (ImageView) findViewById(R.id.su);
		suImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), FacebookActivity.class);
				Log.d("GMIT", "StartingActivity");
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
		
		gallImg = (ImageView) findViewById(R.id.gallery);
		gallImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), GalleryActivity.class);
				startActivity(i);
			}
		});		
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
		if (id == R.id.aboutPage) {
			Intent i = new Intent(getBaseContext(), AboutActivity.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
