package com.example.android.tourguidetelaviv2;

import android.location.Location;

/**
 * Created by Csaba on 30/05/2017.
 */

public class AndroidFlavor {
    // Name of the Android version (e.g. Gingerbread, Honeycomb, Ice Cream Sandwich)
    private String mVersionName;

    // Android version number (e.g. 2.3-2.7, 3.0-3.2.6, 4.0-4.0.4)
    private String mVersionNumber;

    // Drawable resource ID
    private int mImageResourceId;

    //map location
    private Location mAtrractionLocation;

    /*
    * Create a new AndroidFlavor object.
    *
    * @param vName is the name of the Android version (e.g. Gingerbread)
    * @param vNumber is the corresponding Android version number (e.g. 2.3-2.7)
    * @param image is drawable reference ID that corresponds to the Android version
    * */
    public AndroidFlavor(String vName, String vNumber, int imageResourceId, Location location)
    {
        mVersionName = vName;
        mVersionNumber = vNumber;
        mImageResourceId = imageResourceId;
        mAtrractionLocation = location;
    }

    /**
     * Get the name of the Android version
     */
    public String getVersionName() {
        return mVersionName;
    }

    /**
     * Get the Android version number
     */
    public String getVersionNumber() {
        return mVersionNumber;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**map location*/
    public Location getLocation() {
        return mAtrractionLocation;
    }



}
