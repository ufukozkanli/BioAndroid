package org.idat.bio_os;

import android.util.Log;

/**
 * A singleton instance for accessing the hardware. It manages a single thread
 * which is used to request (and send) data from (to) the IOIO board. 
 * 
 * It's a singleton to allow constant data updates (without flinging the 
 * hardware thread around) but allowing you to access it from more than one 
 * Activity.
 * 
 * @author Nick Charlton
 *
 */
public class BioSingleton {
	/**
	 * A set of possible IOIO connection types.
	 */
	public enum IOIOConnectionType {
		NONE,
		USB,
		BLUETOOTH
	}
	
	/** The IOIO thread. */
	private IOIOThread ioio_thread_;
    
    /**
     * Start the hardware thread.
     */
    public void start() {
    	Log.i("BioOS", "Starting the IOIOThread.");
    	ioio_thread_ = new IOIOThread();
    	ioio_thread_.start();
    }
    
    /**
     * Stop the hardware thread.
     */
    public void stop() {
    	Log.i("BioOS", "Stopping the IOIOThread.");
    	ioio_thread_.abort();
    	
    	try {
    		ioio_thread_.join();
    	} catch (InterruptedException e) {
    		// couldn't join, I guess.
    	}
    }
    
    /**
     * Get the hardware connection status.
     * 
     * @return true if connected, false if not.
     */
    public boolean isConnected() {
    	boolean status;
    	
    	synchronized(this) {
    		status = ioio_thread_.is_connected;
    	}
    	
    	return status;
    }
    
    /**
     * Get the hardware connection type.
     */
    public IOIOConnectionType getConnectionType() {
		return IOIOConnectionType.NONE;
    }
    
    /**
     * Get the LED status.
     */
    public boolean getLedStatus() {
    	boolean status;
    	
    	synchronized(this) {
    		status = ioio_thread_.led_on;
    	}
    	
    	return status;
    }
    
    /**
     * Set the LED status.
     */
    public void setLedOn(boolean status) {
    	synchronized(this) {
    		ioio_thread_.led_on = status;
    	}
    }
    
    /**
     * Get the Heart Rate Value.
     */
    public int getHeartRate() {
    	int heart_rate = 0;
    	
    	synchronized(this) {
    		heart_rate = ioio_thread_.heart_rate;
    	}
    	
    	return heart_rate;
    }
    
    /**
     * Get the temperature reading.
     */
    public float getTemperature() {
    	float result = 0.0f;
    	
    	synchronized(this) {
    		result = ioio_thread_.temperature;
    	}
    	
    	return result;
    }
    
    /**
     * Get the breathing rate reading.
     */
    public float getBreathingRate() {
    	float result = 0.0f;
    	
    	synchronized(this) {
    		result = ioio_thread_.breathing_rate;
    	}
    	
    	return result;
    }
    
    /**
	 * Hold on to a firm reference to this class.
	 *
	 */
	private static class BioSingletonHolder {
        public static BioSingleton bio = new BioSingleton();
    }

	/**
	 * Return the BioSingleton instance.
	 * 
	 * @return The current BioSingleton instance.
	 */
    public static BioSingleton getBioSingleton() {
        return BioSingletonHolder.bio;
    }
}
