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

public class Sightseeing extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sightseeing);

        //locations for map
        android.location.Location promenad = new android.location.Location("Tel Aviv Promenad");
        promenad.setLatitude(32.073240);
        promenad.setLongitude(34.764161);
        android.location.Location oJaffaPort = new android.location.Location("Port of Jaffa");
        oJaffaPort.setLatitude(32.0536156);
        oJaffaPort.setLongitude(34.7469727);
        android.location.Location rabinsq = new android.location.Location("Rabin square, Town square, Tel Aviv");
        rabinsq.setLatitude(32.0788015);
        rabinsq.setLongitude(34.778954);
        android.location.Location sarona = new android.location.Location("Sarona, Tel Aviv");
        sarona.setLatitude(32.0714053);
        sarona.setLongitude(34.7847481);
        android.location.Location market = new android.location.Location("Flea Market, Olei Zion St, Jaffa");
        market.setLatitude(32.0528283);
        market.setLongitude(34.7547288);
        android.location.Location oldjaffa = new android.location.Location("Old Jaffa");
        oldjaffa.setLatitude(32.0544515);
        oldjaffa.setLongitude(34.751425);
        android.location.Location museumOfArt = new android.location.Location("Tel Aviv Museum of Art, Sderot Sha'ul HaMelech 27");
        museumOfArt.setLatitude(32.0776566);
        museumOfArt.setLongitude(34.7862004);



        // Create an ArrayList of LocationNew objects
        final ArrayList<LocationNew> androidLocations = new ArrayList<LocationNew>();
        androidLocations.add(new LocationNew("Tel Aviv Promenade", "14 kilometers of walking/biking paths along the Mediterranean Sea. ", R.drawable.beach, promenad));
        androidLocations.add(new LocationNew("Port of Jaffa", "Biblical legend says that one of the sons of Noah, Japheth, built it after surviving the Great Flood in in the Ark.", R.drawable.ojaffaport, oJaffaPort));
        androidLocations.add(new LocationNew("Rabin Square, Tel Aviv-Yafo", "A large public city square in the center of Tel Aviv,", R.drawable.rabinsq, rabinsq));
        androidLocations.add(new LocationNew("Sarona", "33 original Templar buildings dating up to more than 140 years", R.drawable.sarona, sarona));
        androidLocations.add(new LocationNew("Flea Market, Jaffa", " Jaffa flea market is a well known attraction of the area, with vendors selling", R.drawable.market, market));
        androidLocations.add(new LocationNew("Old Jaffa", "The Old City of Jaffa is the historical part of the Israeli city of Jaffa", R.drawable.oldjaffa, oldjaffa));
        androidLocations.add(new LocationNew("Tel Aviv Museum of Art", "The ultramodern ‘envelope’ building located on the eastern edge of the city centre.", R.drawable.museum, museumOfArt));





        // Create an {@link LocationAdapter}, whose data source is a list of
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
