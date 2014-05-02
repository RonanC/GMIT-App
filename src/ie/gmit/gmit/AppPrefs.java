package ie.gmit.gmit;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Menu;
import android.view.MenuItem;

/*
 * This class loads the prefs.xml page
 * 
 * When a user changes any of the preferences, the framework automatically saves the
	data to the applications private directory on Android’s file system.
 */

public class AppPrefs extends PreferenceActivity {
	// this class allows the controls declared in pref.xml to be inflated into an android activity and displayed
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		// inflate the XML declaration
		addPreferencesFromResource(R.xml.prefs);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setTitle("Application Preferences");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId())
		{
			case android.R.id.home:
				// this is called when the Home (up) button is pressed in the action bar
				Intent parentActivityIntent = new Intent(this, NotebookActivity.class);
				parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(parentActivityIntent);
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}	
}
