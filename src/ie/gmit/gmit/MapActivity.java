package ie.gmit.gmit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class MapActivity extends FragmentActivity {
	static final LatLng GMIT = new LatLng(53.2786709, -9.0104636);
	static final LatLng GMITSportsHall = new LatLng(53.27819619, -9.01251281);
	static final LatLng GMITSportsGround = new LatLng(53.2766822, -9.01139701);
	static final LatLng RenmoreGym = new LatLng(53.27557393, -9.01544714);
	static final LatLng Castlebar = new LatLng(53.8504, -9.304755);
	// Co-ords need to be updated:
	static final LatLng CCAM = new LatLng(53.283456, -9.025591);
	static final LatLng Mountbellew = new LatLng(53.47188, -8.5049);
	static final LatLng Letterfrack = new LatLng(53.5536034, -9.9482317);
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		setTitle("Map");
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// this gives us our fragment id element
		// we don't have a view, just a fragment called: com.google.android.gms.maps.SupportMapFragment
		map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
		// add a marker for GMIT
		map.addMarker(new MarkerOptions()
		.position(GMIT).title("G.M.I.T")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.gmitlogos))//fromResource(R.drawable.gmitlogos
		.snippet("GMIT's largest campus and admin HQ"));
		
		//Sports hall
		map.addMarker(new MarkerOptions()
		.position(GMITSportsHall)
		.title("Sports hall")
		.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
		
		//Sports Grounds
		map.addMarker(new MarkerOptions()
		.position(GMITSportsGround)
		.title("Sports Grounds")
		.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

		//Renmore Gym
		map.addMarker(new MarkerOptions()
		.position(RenmoreGym)
		.title("Kingfisher Gym")
		.snippet("Renmore"));		
		
		// add a marker for GMIT CCAM
		map.addMarker(new MarkerOptions()
		.position(CCAM)
		.title("G.M.I.T - CCAM")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.gmitlogos))//fromResource(R.drawable.gmitlogos
		.snippet("Centre for Creative Arts & Media"));

		// add a marker for GMIT Castlebar
		map.addMarker(new MarkerOptions()
		.position(Castlebar)
		.title("G.M.I.T - Castlebar")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.gmitlogos))//fromResource(R.drawable.gmitlogos
		.snippet("First Green Campus in Ireland"));

		// add a marker for GMIT Letterfrack
		map.addMarker(new MarkerOptions()
		.position(Letterfrack)
		.title("G.M.I.T - Letterfrack")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.gmitlogos))//fromResource(R.drawable.gmitlogos
		.snippet("Furniture Design and Technology"));

		// add a marker for GMIT Mountbellew
		map.addMarker(new MarkerOptions()
		.position(Mountbellew)
		.title("G.M.I.T - Mountbellew")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.gmitlogos))//fromResource(R.drawable.gmitlogos
		.snippet("First agricultural college in Ireland"));		
		
		// move the camera instantly to GMIT with a zoom of 15
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(GMIT, 15));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
