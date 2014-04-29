package ie.gmit.gmit;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Build;

public class ClubActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_club);
		
		setTitle("Clubs & Societies");
		getActionBar().setDisplayHomeAsUpEnabled(true);		
		
		init();
	}

	private void init() {
		// gets and edits the ActionBar
		//ActionBar actionBar = getActionBar();
		//actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);

		// values to be added to list, The ListView itself
		String[] values = new String[] {"ACE Society", "Anime & Manga", "Archery Club", "Athletics", "Badminton", "Basketball", "Best Buddies GMIT", "Boxing", "Camogie", "Computer Society", "Cricket", "Cumann Gaelach", "Darts Club", "DJ Society", "Engineering Society",  "Equestrian Society", "Fianna Fail Society", "Film Making Society", "Foir Oige", "Futsal", "Gaelic Football - Mens", "Gaelic Football - Womens", "Gaming Society", "GMIT Wishmakers On Campus", "Handball", "Hurling", "Heritage Society", "International Society", "Indoor Soccer", "Karate", "Karting Society", "Kayak", "Kickboxing", "Letterfrack", "LGBT Society", "Living History Society", "Mature Students Society", "Photography Society - Flash Mob", "Robotics Society", "Rugby Club", " Science Society", "Sinn Fein", "Soccer", "Sub-Aqua", "Surfing", "Swing Dance", "Table Tennis", "Air Soft", "Tag Rugby", "Trampolining/Gymnastics", "Volleyball", "Womens Rugby"};
		ListView listView = (ListView) findViewById(R.id.clubCon);
		
		// create a list and populate it
		ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
	    
		// adapter which interacts with list; adapter linked to ListView
	    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list){

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
			    TextView text = (TextView) view.findViewById(android.R.id.text1);
			    
			    text.setTextColor(Color.WHITE);
			    
				return view;
			}

	    };
	    listView.setAdapter(adapter);
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.club, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
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
