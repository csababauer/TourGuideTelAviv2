package com.example.android.tourguidetelaviv2;

import android.content.Intent;
import android.location.Location;
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
        Location sheraton = new Location("Sheraton Tel Aviv Hotel");
        sheraton.setLatitude(32.0813914);
        sheraton.setLongitude(34.7659788);
        Location hilton = new Location("Hilton Tel Aviv");
        hilton.setLatitude(32.0536156);
        hilton.setLongitude(34.7469727);
        Location renai = new Location("Renaissance Tel Aviv Hotel");
        renai.setLatitude(32.0830715);
        renai.setLongitude(34.766412);
        Location roth = new Location("The Rothschild Hotel - Tel Aviv");
        roth.setLatitude(32.0673169);
        roth.setLongitude(34.7759064);
        Location alex = new Location("Alexander Tel-Aviv Hotel");
        alex.setLatitude(32.0914021);
        alex.setLongitude(34.764667);
        Location gbeach = new Location("Grand Beach Hotel, Tel Aviv");
        gbeach.setLatitude(32.0925133);
        gbeach.setLongitude(34.7715087);
        Location brown = new Location("Brown TLV Urban Hotel");
        brown.setLatitude(32.0655594);
        brown.setLongitude(34.7679522);

        // Create an ArrayList of AndroidFlavor objects
        final ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();
        androidFlavors.add(new AndroidFlavor("Sheraton Tel Aviv Hotel", "£333\n***** ", R.drawable.sheraton, sheraton));
        androidFlavors.add(new AndroidFlavor("Hilton Tel Aviv", "£346\n**** ", R.drawable.hilton, hilton));
        androidFlavors.add(new AndroidFlavor("Renaissance Tel Aviv Hotel", "£355\n****", R.drawable.renaissance, renai));
        androidFlavors.add(new AndroidFlavor("The Rothschild Hotel - Tel Aviv", "£405\n****", R.drawable.rothschild, roth));
        androidFlavors.add(new AndroidFlavor("Alexander Tel-Aviv Hotel", "£256\n**** ", R.drawable.alexander, alex));
        androidFlavors.add(new AndroidFlavor("Grand Beach Hotel, Tel Aviv", "£130\n***", R.drawable.grand_beach, gbeach));
        androidFlavors.add(new AndroidFlavor("Brown TLV Urban Hotel", "£198\n****", R.drawable.browntlv, brown));



        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        AndroidFlavorAdapter flavorAdapter = new AndroidFlavorAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);

        //onClick listener for map clicking
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = androidFlavors.get(position).getLocation().getLatitude();
                double lon = androidFlavors.get(position).getLocation().getLongitude();
                String keyword = androidFlavors.get(position).getVersionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}