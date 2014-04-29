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
	private MyAdapter mAdapter;
	private ViewPager mPager;
	
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
		
		mAdapter = new MyAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
		
		// sets the selected image as the current photo in the adapter
		mPager.setCurrentItem(position);		
/*		ImageAdapter imageAdapter = new ImageAdapter(this);
		ImageView imageView = (ImageView) findViewById(R.id.fullImageView);
		imageView.setImageResource(imageAdapter.mThumbIds[position]);*/
		
		//setTitle("");
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.full_image, menu);
		return true;
	}*/

/*	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		switch (item.getItemId()){
			case android.R.id.home:
				// this is called when the Home (up) button is pressed in the action bar
				Intent parentActivityIntent = new Intent(this, GalleryActivity.class);
				parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(parentActivityIntent);
				finish();
				return true;
		}
		
		return super.onOptionsItemSelected(item);
	}*/
	
	public static class MyAdapter extends FragmentPagerAdapter {

		// references to our images
		public Integer[] mThumbIds = {
				R.drawable.gal1,
				R.drawable.gal2,
				R.drawable.gal3,
				R.drawable.gal4,
				R.drawable.gal5,
				R.drawable.gal6,
				R.drawable.gal7,
				R.drawable.gal8,
				R.drawable.gal9,
				R.drawable.gal10
		};

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return mThumbIds.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new ImageFragment(mThumbIds[0]);
			case 1:
				return new ImageFragment(mThumbIds[1]);
			case 2:
				return new ImageFragment(mThumbIds[2]);
			case 3:
				return new ImageFragment(mThumbIds[3]);
			case 4:
				return new ImageFragment(mThumbIds[4]);
			case 5:
				return new ImageFragment(mThumbIds[5]);
			case 6:
				return new ImageFragment(mThumbIds[6]);
			case 7:
				return new ImageFragment(mThumbIds[7]);
			case 8:
				return new ImageFragment(mThumbIds[8]);
			case 9:
				return new ImageFragment(mThumbIds[9]);
			case 10:
				return new ImageFragment(mThumbIds[10]);

			default:
				return null;
			}
		}
	}	
}
