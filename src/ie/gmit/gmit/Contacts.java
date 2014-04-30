package ie.gmit.gmit;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

/*
 * This class populates itself with the various contacts in the list and once an item is pressed it calls that item
 */

public class Contacts extends ListActivity {
	private String contacts[] = {
			"General Enquiries",
			"Admissions Office",
			"Admissions Office #2",
			"Registration Office",
			"Registration Office #2",
			"Examinations Office",
			"Examinations Office #2",
			"Examinations Office #3",
			"Grants Office",
			"Student Services Office",
			"Student Services Office #2",
			"School of Business",
			"School of Business #2",
			"School of Humainities",
			"School of Humainities #2",
			"School of Engineering",
			"School of Engineering #2",
			"School of Science",
			"School of Science #2",
			"The Hotel School",
			"The Hotel School #2",
			"International Office",
			"Library Services",
			"School Liason Officer",
			"Carreers Officer",
			"Presidents Office",
			"Registrars Office",
			"Secretary/Financial Controllers Office",
			"Communications Officer",
			"Research Officer",
			"Human Resources",
			"Human Resources #2",
			"Human Resources #3",
			"Mayo Campus",
			"Letterfrack Campus",
			"CCAM Campus"
	};
	private String numbers[] = {
			"+353-91-753161",
			"+353-91-742305",
			"+353-91-742262",
			"+353-91-742084",
			"+353-91-742220",
			"+353-91-742355",
			"+353-91-742347",
			"+353-91-742348",
			"+353-91-742140",
			"+353-91-742118",
			"+353-91-742157",
			"+353-91-742046",
			"+353-91-742225",
			"+353-91-742412",
			"+353-91-742257",
			"+353-91-742201",
			"+353-91-742251",
			"+353-91-742178",
			"+353-91-742274",
			"+353-91-742053",
			"+353-91-742209",
			"+353-91-742211",
			"+353-91-742795",
			"+353-91-742186",
			"+353-91-742778",
			"+353-91-742224",
			"+353-91-742757",
			"+353-91-742744",
			"+353-91-742826",
			"+353-91-742761",
			"+353-91-742766",
			"+353-91-742746",
			"+353-91-742741",
			"+353 94 902 5700",
			"+353 91 742650",
			"+353 91 770 661"
	};
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+" + numbers[position])); 
		startActivity(i);
		
/*		Intent i = new Intent(getBaseContext(), ClubInfo.class);
		i.putExtra("intent", position);
		i.putExtra("name", ci.getName(position));
		startActivity(i);*/
		
		//Toast.makeText(getBaseContext(), "tap: " + id , Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_club);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);		
		init();
	}

	private void init() {
		// gets and edits the ActionBar
		//ActionBar actionBar = getActionBar();
		//actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
		Log.d("GMIT", "1");
		// values to be added to list, The ListView itself

		//ListView listView = (ListView) findViewById(R.id.clubCon);
		
		// create a list and populate it
		ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < contacts.length; ++i) {
	      list.add(contacts[i]);
	    }
	    Log.d("GMIT", "2");
		// adapter which interacts with list; adapter linked to ListView
	    @SuppressWarnings("unchecked")
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list){

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
			    TextView text = (TextView) view.findViewById(android.R.id.text1);
			    
			    text.setTextColor(Color.WHITE);
			    view.setBackgroundColor(Color.rgb(125, 155, 193));
			    
				return view;
			}

	    };
	    Log.d("GMIT", "3");
	    //listView.setAdapter(adapter);
	    setListAdapter(adapter);
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
