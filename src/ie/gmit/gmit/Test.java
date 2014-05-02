package ie.gmit.gmit;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.os.Build;

/*
 * This class
 */

public class Test extends Activity {
	private Spinner describeSpin = null;
	private RadioGroup radioGroup = null;
	private EditText editName = null;
	private static final String[] DESCRIBE = new String[] {"great", "fantastic", "wonderful", "simply the best", "better then all the rest"};
	private String radio = "G.M.I.T";
	private String describeStr;
	private String name = "Brian!";
	
	// only one notification manager for the entire app
	private NotificationManager manager = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);		
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub		
		describeSpin = (Spinner) findViewById(R.id.settingsDescribeList);
		// now to fill the spinner with the String Array, using an Array Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, DESCRIBE);
		// now the arrayadapter is ready to push the String Array into a spinner widget (dropdown style)
		// This sets what adapter the spinner will be using
		describeSpin.setAdapter(adapter);
		
		describeSpin.setOnItemSelectedListener(
				new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						// TODO Auto-generated method stub
						int index = describeSpin.getSelectedItemPosition();
						describeStr = DESCRIBE[index];
						Toast.makeText(getBaseContext(), "Selected description: " + DESCRIBE[index], Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
					}
			
				});
		
		// radio group listeners
		radioGroup = (RadioGroup) findViewById(R.id.settingsGroup);
		
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				switch(checkedId){
					case R.id.settingsRadio1:
						radio = "GMIT";
						Toast.makeText(getBaseContext(), "Selected item: GMIT", Toast.LENGTH_SHORT).show();		
						break;
						
					case R.id.settingsRadio2:
						radio = "Galway Mayo Institute of Technology";
						Toast.makeText(getBaseContext(), "Selected item: Galway Mayo Institute of Technology", Toast.LENGTH_SHORT).show();		
						break;
						
					default:
						radio = "G.M.I.T";
						Toast.makeText(getBaseContext(), "Default:", Toast.LENGTH_SHORT).show();
						break;
				}
			}
		});
		
		editName = (EditText) findViewById(R.id.txtStudentName);
		editName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name = editName.getText().toString();
			}
		});
		
		// add button dynamically
		Button notifyButton = new Button(this);
		notifyButton.setText("Student List");

		LinearLayout ll = (LinearLayout)findViewById(R.id.settingsCon);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		ll.addView(notifyButton, lp);		
		
		// got to StudentListView
		notifyButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), "Notifying", Toast.LENGTH_SHORT).show();
				Toast.makeText(getBaseContext(), "Results Selected", Toast.LENGTH_SHORT).show();
				// charSequence is a core java interface that deals with characters
				CharSequence contentTitle = "Test Notification:";
				
/*				if(radio == null){
					radio = "G.M.I.T";
				}
				if(name == null){
					name = "Buddha";
				}		*/		
				
				
				CharSequence contentText = radio + " is " + describeStr + ".";
				CharSequence longText = radio + " is " + describeStr + " " + name + "!";
				
				// main intent
				Intent notificationIntent = new Intent(getBaseContext(), AboutActivity.class); // change class!!!!!!!!!!!!
				// pending intent holds main intent
				PendingIntent contentIntent = PendingIntent.getActivity(getBaseContext(), 0, notificationIntent, 0);
				
				// The Notification.Builder provides a builder interface to create a Notification object.
				NotificationCompat.Builder noti = new NotificationCompat.Builder(getBaseContext())
					.setContentTitle(contentTitle)
					.setContentText(contentText)
					.setSmallIcon(R.drawable.gmitlogos)
					.setContentIntent(contentIntent)
					.addAction(R.drawable.gmitlogos, "Call", contentIntent)
					.addAction(R.drawable.gmitlogos, "Bus", contentIntent)
					.addAction(R.drawable.gmitlogos, "About, contentIntent)", contentIntent)
					.setStyle(new NotificationCompat.BigTextStyle().bigText(longText));
				
				// Sound
				noti.setDefaults(Notification.DEFAULT_SOUND);
				
				// Hide the notification after it's selected
				noti.setAutoCancel(true);
				
				manager.notify(1, noti.build());
			}
		});
		
		// add button dynamically
		Button byebyeBtn = new Button(this);
		byebyeBtn.setText("Bye Bye");

		ll.addView(byebyeBtn, lp);		
		
		// got to StudentListView
		byebyeBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "Good bye", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
		
	    // This gets the notify mgr
		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
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
				Intent parentActivityIntent = new Intent(this, MainActivity.class);
				parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(parentActivityIntent);
				finish();
				break;
				
/*			case android.R.id.draw:
				// this is called when the Home (up) button is pressed in the action bar
				//startActivity(new Intent(this, ie.draw.DrawActivity.class));
				break;	*/
		}
		return super.onOptionsItemSelected(item);
	}
}
