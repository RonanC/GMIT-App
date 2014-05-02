package ie.gmit.gmit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/*
 * This class holds all the images and has basic get methods for accessing said images
 * This class is used by the gallery activity
 */

public class ImageAdapter extends BaseAdapter{
	private Context mContext;
	
	// constructor
	public ImageAdapter(Context c){
		mContext = c;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	// This method creates a new View for each image added to the ImageAdapter.
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView;
		
		if(convertView == null){ // is it's not recycled image then initialize some attributes
			imageView = new ImageView(mContext);
			
			// set some parameters
			// this is where you set the size of the images, the scale options and padding
			imageView.setLayoutParams(new GridView.LayoutParams(250,250));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8,8,8,8);
		}
		else{
			imageView = (ImageView) convertView;
		}
		
		imageView.setImageResource(mThumbIds[position]);
		
		return imageView;
	}
	
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
			R.drawable.gal10,
			R.drawable.gal11,
			R.drawable.gal12,
			R.drawable.gal13,
			R.drawable.gal14,
			R.drawable.gal15,
			R.drawable.gal16,
			R.drawable.gal17,
			R.drawable.gal18,
			R.drawable.gal19,
			R.drawable.gal20,
			R.drawable.gal21,
			R.drawable.gal22,
			R.drawable.gal23,
			R.drawable.gal24,
			R.drawable.gal25,
			R.drawable.gal26,
			R.drawable.gal27,
			R.drawable.gal28,
			R.drawable.gal29,
			R.drawable.gal30,
			R.drawable.gal31,
			R.drawable.gal32,
			R.drawable.gal33,
			R.drawable.gal34,
			R.drawable.gal35,
			R.drawable.gal36,
			R.drawable.gal37,
			R.drawable.gal38,
			R.drawable.gal39,
			R.drawable.gal40,
			R.drawable.gal41
	};

}
