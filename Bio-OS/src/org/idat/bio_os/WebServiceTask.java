
package org.idat.bio_os;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import android.util.Log;

/**
 * Update the web service, on command.
 * 
 * @author Nick Charlton <hello@nickcharlton.net>
 *
 */
public class WebServiceTask implements Runnable {
	private final MainActivity mainActivity;
	
	public WebServiceTask(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	@Override
	public void run() {
		// submit the data
	}
	
	/**
	 * Submit the data package up to the web service.
	 */
	private void submitData() {
		HttpURLConnection con = null;
		
		try {
			if (Thread.interrupted())
				throw new InterruptedException();
			
			// encode the data
			String source = "nothing much";
			String q = URLEncoder.encode(source, "UTF-8");
			
			// build up the url
			URL url = new URL("http://..." + q);
			
			con = (HttpURLConnection)url.openConnection();
			con.setReadTimeout(10000); // milliseconds
			con.setConnectTimeout(15000); // milliseconds
			
			con.setRequestMethod("POST");
			con.setDoInput(true);
			
			// start the query
			con.connect();
			
			if (Thread.interrupted())
				throw new InterruptedException();
		} catch (InterruptedException e) {
			Log.e("BioOS", "Web Service Request Interrupted");
		} catch (IOException e) {
			Log.e("BioOS", "An IO Exception occurred");
		} finally {
			con.disconnect();
		}
	}

}
