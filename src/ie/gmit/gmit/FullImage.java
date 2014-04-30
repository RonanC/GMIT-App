package ie.gmit.gmit;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class FullImage extends FragmentActivity {
//	private ViewPager mPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// sets it full screen, (removes the notification bar)
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  WindowManager.LayoutParams.FLAG_FULLSCREEN);;
		// this removes the action bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
		
		setContentView(R.layout.activity_full_image);

		// set up on action bar
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		
		// get intent
		// this returns the intent that started this activity
		Intent i = getIntent();
		
		// selected image id
		// i is the intent that got called due to pressing the image
		// this intent has the name of the image, which we can use to display fully
		int position = i.getExtras().getInt("id");
		
		// implement ViewPager later on for swiping
/*		MyAdapter mAdapter = new MyAdapter(getSupportFragmentManager());

		ViewPager mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);*/
		
		// sets the selected image as the current photo in the adapter
		//mPager.setCurrentItem(position);		
		
		
		ImageAdapter imageAdapter = new ImageAdapter(this);
		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageResource(imageAdapter.mThumbIds[position]);
	}
}
