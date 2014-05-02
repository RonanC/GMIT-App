package ie.gmit.gmit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.*;

/*
 * This activity displays a list of notes
 * You can add notes from the options
 * remove notes by long pressing
 * edit notes by tapping
 * 
 * The notebook will be saved to internal memory by default
 * You can select to save to SD card from the app prefs option
 * You can also choose the name of the notebook
 */

public class NotebookActivity extends ListActivity {
	
	private String fileName;
	private boolean saveSDCard;
	
	private Notebook notebook = null;
	private ArrayAdapter<String> adapter;	
	
	String updatedNote = "temp";
	int updatedPosition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);		

		// this needs to exist in order to use its load method
		notebook = new Notebook();
		
		loadPreferences();
		loadNotebookList();
		
		setTitle("Notebook: " + fileName);
		
		init();
		
		notebook.addNote("New Note");
	}
	
	private void init() {
		// the adapter is the bridge between the list view and the notebook, they effect eachother
		adapter = new ArrayAdapter<String>(this, R.layout.activity_notebook, notebook.getNotebook());

	    setListAdapter(adapter);
	    
	    registerForContextMenu(getListView()); // added
	}

	private void loadPreferences(){
		SharedPreferences sps = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		fileName = sps.getString("fileName", "notebook.ser");
		saveSDCard = sps.getBoolean("saveSDCard", false);
	}

	public void save(FileOutputStream fos) throws Exception{
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(notebook);
	}
	
	public void load(FileInputStream fis) throws Exception{
		ObjectInputStream in = new ObjectInputStream(fis);
		notebook = (Notebook) in.readObject();
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notebook, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		switch(item.getItemId())
		{
			case R.id.appPrefs:
				startActivity(new Intent(this, AppPrefs.class));
				break;
				
			case R.id.addNote:
				Toast.makeText(getBaseContext(), "Note added" , Toast.LENGTH_SHORT).show();
				notebook.addNote("New Note");
				saveNotebookList();
				adapter.notifyDataSetChanged();
				//startActivity(new Intent(this, EditNote.class));
				break;				

			case android.R.id.home:
				// this is called when the Home (up) button is pressed in the action bar
				Intent parentActivityIntent = new Intent(this, MainActivity.class);
				parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(parentActivityIntent);
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		// The view we are passed in here is the textView of the specified item
		
		String editItem = adapter.getItem(position);
		
		editNote(editItem, position);
	}
	
	private void updateList(){
		// need to edit actually list
		notebook.editNote(updatedPosition, updatedNote);
		adapter = new ArrayAdapter<String>(this, R.layout.activity_notebook, notebook.getNotebook());
		setListAdapter(adapter);
		adapter.notifyDataSetChanged();		
	}
	
	private void editNote(String editItem, int position){
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		updatedPosition = position;
		alert.setTitle("Edit note:");
		//alert.setMessage("Message:");

		// Set an EditText view to get user input 
		final EditText input = new EditText(this);
		input.setText(editItem);
		alert.setView(input);

		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {
		  // Do something with value!
			updatedNote = input.getText().toString();
			//Toast.makeText(getBaseContext(), "Updated" , Toast.LENGTH_SHORT).show();
			updateList();
		  }
		});
		
		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		  public void onClick(DialogInterface dialog, int whichButton) {
		    // Canceled.
			  //Toast.makeText(getBaseContext(), "Cancelled" , Toast.LENGTH_SHORT).show();
		  }
		});
		alert.show();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Notebook Options: ");
		menu.add(0, v.getId(), 0, "Delete note");
	}		
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// this gets us the options menu
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		// this gets us the item on the options list (remove)
		final String s = (String) getListAdapter().getItem(info.position);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure you want to delete this note?");
		builder.setCancelable(false);
		
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				adapter.remove(s);
				Toast.makeText(getBaseContext(), "Note removed", Toast.LENGTH_SHORT).show();
				
				//Toast.makeText(getBaseContext(), "Starting SaveNotebookList()", Toast.LENGTH_SHORT).show();
				saveNotebookList();
				
				
				// this updates the adapter
				adapter.notifyDataSetChanged();
				//Toast.makeText(getBaseContext(), "Refreshing notebook", Toast.LENGTH_SHORT).show();
			}
		});
		
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				Toast.makeText(getBaseContext(), "Remove cancelled", Toast.LENGTH_SHORT).show();
			}
		});
		
		AlertDialog alert = builder.create();
		alert.show();
		
		return true;
	}		
	
	private void loadNotebookList(){
		try{
			FileInputStream fis = null;
			// we want to load from sd card
			if(saveSDCard){
				//Toast.makeText(getBaseContext(), "loading from SD card", Toast.LENGTH_SHORT).show();
				// create a file called root with a load location of sd card
				File root = Environment.getExternalStorageDirectory();
				
				// sd card is available
				if(root.canWrite()){
					
					// fis = sd folder / filename, this may fail if the name doesn't exist
					fis = new FileInputStream(new File(root, fileName));
					//Toast.makeText(getBaseContext(), "Load from SD card complete", Toast.LENGTH_SHORT).show();
				}
				else{
					Toast.makeText(getBaseContext(), "Unable to load from SD card.", Toast.LENGTH_SHORT).show();
					return;
				}
				
			}
			else{
				// load internally, if file doesn't exist then we will skip to the catch
				//Toast.makeText(getBaseContext(), "Loading from internal memory", Toast.LENGTH_SHORT).show();
				fis = this.getApplicationContext().openFileInput(fileName);
				//Toast.makeText(getBaseContext(), "Loaded from internal memory", Toast.LENGTH_SHORT).show();

			}
			// send fis to notebook so that notebook can deserialize the notebook and hold it
			notebook.load(fis);
			//Toast.makeText(getBaseContext(), "Notebook loaded from file (FINAL)", Toast.LENGTH_SHORT).show();

		}
		catch(Exception e){
			// this means the file doesn't exist
			Toast.makeText(getBaseContext(), "Unable to load Notebook: \n" + e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

	private void saveNotebookList(){
		try{
			FileOutputStream fos = null;
			if(saveSDCard){
				//Toast.makeText(getBaseContext(), "Saving to SD card", Toast.LENGTH_SHORT).show();
				// root now = the external sd
				File root = Environment.getExternalStorageDirectory();
				if(root.canWrite()){
					// root can write so a fos is created that has the root and a name (specified in pref)
					fos = new FileOutputStream(new File(root, fileName));
					//Toast.makeText(getBaseContext(), "Save to SD card complete.", Toast.LENGTH_SHORT).show();
				}
				else{
					// root can't write which means we have no sd card inserted
					Toast.makeText(getBaseContext(), "Unable to write to SD card", Toast.LENGTH_SHORT).show();
					return;
				}
			}
			else{
				//Toast.makeText(getBaseContext(), "Saving to Internal Memory.", Toast.LENGTH_SHORT).show();
				// here no root is needed as we are saving internally so we select the fileName to load from (which we know is created)
				fos = this.getApplicationContext().openFileOutput(fileName, 0);
				//Toast.makeText(getBaseContext(), "Saved to Internal Memory.", Toast.LENGTH_SHORT).show();
			}
			
			// we now pass this fos to be passed into a object writer which will write the notebook object to the specified location
			notebook.save(fos);
			//Toast.makeText(getBaseContext(), "Notebook saved to file (FINAL)", Toast.LENGTH_SHORT).show();
		}
		catch(Exception e){
			Toast.makeText(getBaseContext(), "Unable to save student list: \n" + e.getMessage(), Toast.LENGTH_LONG).show();
		}
	} 
}
