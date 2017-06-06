package com.example.android.tourguidetelaviv2;

/**
 * Created by Csaba on 30/05/2017.
 */

public class LocationNew {
    // Name of the Android location
    private String mName;

    // description of the Location
    private String mDescription;

    // Drawable resource ID
    private int mImageResourceId;

    //map location
    private android.location.Location mAtractionLocation;

    /*
    * Create a new LocationNew object.
    *
    * @param vName is the name of the location
    * @param vNumber is description
    * @param image is drawable reference ID that corresponds to the Android version
    * */
    public LocationNew(String vName, String vNumber, int imageResourceId, android.location.Location location) {
        mName = vName;
        mDescription = vNumber;
        mImageResourceId = imageResourceId;
        mAtractionLocation = location;
    }

    /**
     * Get the name of the Android version
     */
    public String getVersionName() {
        return mName;
    }

    /**
     * Get the description
     */
    public String getVersionNumber() {
        return mDescription;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * map location
     */
    public android.location.Location getLocation() {
        return mAtractionLocation;
    }


}
