package org.idat.bio_os;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
	}
	
	/**
	 * Called when the application is resumed and first started.
	 * 
	 * This requests the Singleton instance and fills the labels.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		BioSingleton bio = BioSingleton.getBioSingleton();
		
		// fetch status info
		boolean status = bio.isConnected();
		
		// set each of the fields
		TextView statusValue = (TextView)findViewById(R.id.StatusValue);
		if (status) {
			statusValue.setText("Connected.");
		} else {
			statusValue.setText("Not connected.");
		}
	}
}
