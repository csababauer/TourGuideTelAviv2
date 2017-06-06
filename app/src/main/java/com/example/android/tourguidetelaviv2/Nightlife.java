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
 * Created by Csaba on 03/06/2017.
 */

public class Nightlife extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nightlife);

        //locations for map
        android.location.Location hookah = new android.location.Location("Hookahplace - Shisha Bar Tel Aviv");
        hookah.setLatitude(32.0663178);
        hookah.setLongitude(34.7658743);
        android.location.Location kuli = new android.location.Location("Kuli Alma");
        kuli.setLatitude(32.0622247);
        kuli.setLongitude(34.7726915);
        android.location.Location tlv = new android.location.Location("TLVnights");
        tlv.setLatitude(32.0502972);
        tlv.setLongitude(34.7470343);
        android.location.Location french = new android.location.Location("French 57  Tel Aviv-Yafo");
        french.setLatitude(32.069141);
        french.setLongitude(34.76885);
        android.location.Location kerem = new android.location.Location("Kerem Montefiore Tasting Room");
        kerem.setLatitude(32.0549214);
        kerem.setLongitude(34.7549647);
        android.location.Location shpagat = new android.location.Location("Shpagat Tel Aviv");
        shpagat.setLatitude(32.0652763);
        shpagat.setLongitude(34.7687792);
        android.location.Location ismi = new android.location.Location("Ismi Salma");
        ismi.setLatitude(32.0789293);
        ismi.setLongitude(34.7698215);

        // Create an ArrayList of LocationNew objects
        final ArrayList<LocationNew> androidLocations = new ArrayList<LocationNew>();
        androidLocations.add(new LocationNew("Hookahplace - Shisha Bar Tel Aviv", "Cigar Bars, Other Food & Drink, Tours, Food & Drink", R.drawable.hookah, hookah));
        androidLocations.add(new LocationNew("Kuli Alma", " Art Galleries, Other Food & Drink", R.drawable.kuli, kuli));
        androidLocations.add(new LocationNew("TLVnights", " Bar, Club & Pub Tours, Bars & Clubs", R.drawable.tlv, tlv));
        androidLocations.add(new LocationNew("French 57  Tel Aviv-Yafo", "Bar, Club", R.drawable.french57, french));
        androidLocations.add(new LocationNew("Kerem Montefiore Tasting Room", "Bar, Club & Pub Tours", R.drawable.kerem, kerem));
        androidLocations.add(new LocationNew("Shpagat Tel Aviv", "Bar, Club", R.drawable.shpagat, shpagat));
        androidLocations.add(new LocationNew("Ismi Salma", "Bars & Clubs, Nightlife", R.drawable.ismi, ismi));



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