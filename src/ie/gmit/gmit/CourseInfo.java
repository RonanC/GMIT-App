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
 * This activity displays the 5 schools of business
 * Once one is selected, information relevant to its position fills out data on the next page
 */

public class CourseInfo extends Activity {
	private int courseInfo[] = {
			R.string.scienceText,
			R.string.engineeringText,
			R.string.businessText,
			R.string.humanitiesText,
			R.string.hotelText
	};

	TextView courseText = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course_info);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Intent i = getIntent();
		
		int position = i.getIntExtra("position", 0);
		String name = i.getStringExtra("name");
		
		setTitle(name);
		
		String temp = getResources().getString(courseInfo[position]);
		
		courseText = (TextView) findViewById(R.id.courseText);
		courseText.setText(temp);
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
				Intent parentActivityIntent = new Intent(this, Courses.class);
				parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(parentActivityIntent);
				finish();
				return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
