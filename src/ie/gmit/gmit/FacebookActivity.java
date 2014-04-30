package ie.gmit.gmit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

import com.facebook.*;
import com.facebook.model.*;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.model.GraphObject;

/*
 * This activity is not in use at the moment,
 * but I would like to add a direct feed to the SU FB with this
 */

public class FacebookActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facebook);
		Log.d("GMIT", "setContentView");
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.facebookCon, new PlaceholderFragment()).commit();
			Log.d("GMIT", "if Frag");
		}
		
		printHashKey();

	}
	
	public void printHashKey() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo("ie.gmit.gmit", PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("TEMPTAGHASH KEY:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (NameNotFoundException e) {
        	Log.d("GMIT", "catch1");

        } catch (NoSuchAlgorithmException e) {
        	Log.d("GMIT", "catch2");
        }

    }
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,resultCode, data);
		Log.d("GMIT", "Session getActive Session");
	}
  
  public static class PlaceholderFragment extends Fragment {
	  public PlaceholderFragment() {
	  }
	  
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		  Log.d("GMIT", "PlaceholderFragment, onCreateView");
		  View rootView = inflater.inflate(R.layout.fragment_facebook, container,false);	// !!!!!!
		  final TextView newsFeedTextView = (TextView) rootView.findViewById(R.id.newsFeed);
		  
		  StatusCallback mCallback = new Session.StatusCallback() {
			  	@Override
			  	public void call(Session session, SessionState state,Exception exception) {
			  		Log.d("GMIT", "Call");

			  		if (session.isOpened()) {
				  		/* make the API call */
			  			Log.d("GMIT", "if (session.isOpened()) {");
				  		new Request(session, "/GmitClubsandsocieties/feed", null, HttpMethod.GET, new Request.Callback() {
					  		public void onCompleted(Response response) {
					  			/* handle the result */
					  			/*examine the full response output in the logcat
			 					window*/
					  			System.out.println("Response 1: " + response);
					  			newsFeedTextView.setText("Gmit Clubs & Societies FB Feed:\n\n" + parseDataFromFQLResponse(response)); //parseDataFromFQLResponse(response)
					  			//System.out.println("Response 2: " + response);
					  			Log.d("GMIT", "response");
					  		}
				  		}).executeAsync();
			  		}
			  	}
	  };
	  Log.d("GMIT", "before opening sessions");
	  Session.OpenRequest request = new Session.OpenRequest(getActivity());
	  Log.d("GMIT", "Session.OpenRequest(getActivity());");
	  // request.setPermissions(Arrays.asList("read_stream"));
	  request.setCallback(mCallback);
	  // get active session
	  
	  Session mFacebookSession = Session.getActiveSession();
	  Log.d("GMIT", "1");
	  if (mFacebookSession == null || mFacebookSession.isClosed()){
		  mFacebookSession = new Session(getActivity());
		  Log.d("GMIT", "(mFacebookSession == null || mFacebookSession.isClosed()");
	  }
	  Log.d("GMIT", "2");
	  // mFacebookSession.openForRead(request);
	  mFacebookSession.openForRead(request);
	  Log.d("GMIT", "3");
	  return rootView;
	  }
}  

  private static String parseDataFromFQLResponse(Response response) {
	  StringBuilder responseText = new StringBuilder("");
	  Log.d("GMIT", "parseDataFromFQLResponse");
	  try {
		  System.out.println("Try");
		  GraphObject go = response.getGraphObject();
		  JSONObject jso = go.getInnerJSONObject();
		  JSONArray arr = jso.getJSONArray("data");
		  System.out.println("TryMID arr.length(): "  + arr.length() );
		  
		  for (int i = 0; i < (arr.length()); i++) {
			  System.out.println("TryFor: " + i);
			  JSONObject json_obj = arr.getJSONObject(i);
			  System.out.println("TryFor: JSONObject" + json_obj);
			  
			  if(json_obj.optString("message") != ""){
				  String time = json_obj.optString("created_time");
				  time = time.substring(0, 10);
				  String message =   json_obj.optString("message");
				  responseText.append(String.format("%s:\n%s\n\n\n",time , message)); // optString instead of getString (doesn't throw error, just "" (like french man)
			  }
			  
			  
			  System.out.println("TryForENd?");
		  }
		  System.out.println("// Try");
	  } catch (Throwable t) {
		  System.out.println("Catch");
		  t.printStackTrace();
	  }
	  return responseText.toString();
  } 
}
