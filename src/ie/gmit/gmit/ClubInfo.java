package ie.gmit.gmit;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;

/*
 * This class displays an image, text and a link to facebook
 * It's not filled out yet so all it displays is a default gmit image, it's club name and the body,
 * The Facebook links to the SU societies list for the moment
 */

public class ClubInfo extends Activity {
	private ImageView logoView = null;
	private TextView bodyView = null;
	private TextView linkView = null;
	private String link;
	private String name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_club_info);
		getActionBar().setDisplayHomeAsUpEnabled(true);	
		
		logoView = (ImageView)findViewById(R.id.clubImage);
		bodyView = (TextView)findViewById(R.id.clubBody);
		linkView = (TextView)findViewById(R.id.clubLink);

		Intent i = getIntent();
		int position = i.getIntExtra("intent", 69);
		name = i.getStringExtra("name");
		String body = i.getStringExtra("body");
		link = i.getStringExtra("link");
		String logo = i.getStringExtra("image");
		
		setTitle(name);
		logoView.setImageResource(R.drawable.oldcover);
		bodyView.setText(body);
		
		// could use a switch would a string xml document to populate the activity
		// I'd rather pass it in like with a class because then I can load in the club information from a file or feed easier
/*		switch(position){
		case 0:
			//logoView.setImageResource(R.drawable.oldcover);
			
			break;
		
		case 1:
			logoView.setImageResource(R.drawable.oldcover);
			bodyView.setText(body);
			break;
			
		}*/
		
		
		linkView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), ClubFeed.class);
				i.putExtra("link", "http://gmitsu.ie/clubssocs/directory.html");
				i.putExtra("name", name);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.club_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
		case android.R.id.home:
			// this is called when the Home (up) button is pressed in the action bar
			Intent parentActivityIntent = new Intent(this, ClubActivity.class);
			parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(parentActivityIntent);
			finish();
			return true;
	}
		return super.onOptionsItemSelected(item);
	}
}
