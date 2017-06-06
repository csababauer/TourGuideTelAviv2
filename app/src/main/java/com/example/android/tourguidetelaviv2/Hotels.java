package com.example.android.tourguidetelaviv2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Csaba on 27/05/2017.
 */

public class Hotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotels);

        //locations for map
        android.location.Location sheraton = new android.location.Location("Sheraton Tel Aviv Hotel");
        sheraton.setLatitude(32.0813914);
        sheraton.setLongitude(34.7659788);
        android.location.Location hilton = new android.location.Location("Hilton Tel Aviv");
        hilton.setLatitude(32.0536156);
        hilton.setLongitude(34.7469727);
        android.location.Location renai = new android.location.Location("Renaissance Tel Aviv Hotel");
        renai.setLatitude(32.0830715);
        renai.setLongitude(34.766412);
        android.location.Location roth = new android.location.Location("The Rothschild Hotel - Tel Aviv");
        roth.setLatitude(32.0673169);
        roth.setLongitude(34.7759064);
        android.location.Location alex = new android.location.Location("Alexander Tel-Aviv Hotel");
        alex.setLatitude(32.0914021);
        alex.setLongitude(34.764667);
        android.location.Location gbeach = new android.location.Location("Grand Beach Hotel, Tel Aviv");
        gbeach.setLatitude(32.0925133);
        gbeach.setLongitude(34.7715087);
        android.location.Location brown = new android.location.Location("Brown TLV Urban Hotel");
        brown.setLatitude(32.0655594);
        brown.setLongitude(34.7679522);

        // Create an ArrayList of LocationNew objects
        final ArrayList<LocationNew> androidLocations = new ArrayList<LocationNew>();
        androidLocations.add(new LocationNew("Sheraton Tel Aviv Hotel", "£333\n***** ", R.drawable.sheraton, sheraton));
        androidLocations.add(new LocationNew("Hilton Tel Aviv", "£346\n**** ", R.drawable.hilton, hilton));
        androidLocations.add(new LocationNew("Renaissance Tel Aviv Hotel", "£355\n****", R.drawable.renaissance, renai));
        androidLocations.add(new LocationNew("The Rothschild Hotel - Tel Aviv", "£405\n****", R.drawable.rothschild, roth));
        androidLocations.add(new LocationNew("Alexander Tel-Aviv Hotel", "£256\n**** ", R.drawable.alexander, alex));
        androidLocations.add(new LocationNew("Grand Beach Hotel, Tel Aviv", "£130\n***", R.drawable.grand_beach, gbeach));
        androidLocations.add(new LocationNew("Brown TLV Urban Hotel", "£198\n****", R.drawable.browntlv, brown));



        // Create an {@link LocationAdapterNew}, whose data source is a list of
        // {@link LocationNew}s. The adapter knows how to create list item views for each item
        // in the list.
        LocationAdapterNew flavorAdapter = new LocationAdapterNew(this, androidLocations);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);

        //onClick listener for map clicking
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = androidLocations.get(position).getLocation().getLatitude();
                double lon = androidLocations.get(position).getLocation().getLongitude();
                String keyword = androidLocations.get(position).getVersionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}