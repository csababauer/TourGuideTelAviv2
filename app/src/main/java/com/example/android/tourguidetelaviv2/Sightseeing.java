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

public class Sightseeing extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sightseeing);

        //locations for map
        Location promenad = new Location("Tel Aviv Promenad");
        promenad.setLatitude(32.073240);
        promenad.setLongitude(34.764161);
        Location oJaffaPort = new Location("Port of Jaffa");
        oJaffaPort.setLatitude(32.0536156);
        oJaffaPort.setLongitude(34.7469727);
        Location rabinsq = new Location("Rabin square, Town square, Tel Aviv");
        rabinsq.setLatitude(32.0788015);
        rabinsq.setLongitude(34.778954);
        Location sarona = new Location("Sarona, Tel Aviv");
        sarona.setLatitude(32.0714053);
        sarona.setLongitude(34.7847481);
        Location market = new Location("Flea Market, Olei Zion St, Jaffa");
        market.setLatitude(32.0528283);
        market.setLongitude(34.7547288);
        Location oldjaffa = new Location("Old Jaffa");
        oldjaffa.setLatitude(32.0544515);
        oldjaffa.setLongitude(34.751425);
        Location museumOfArt = new Location("Tel Aviv Museum of Art, Sderot Sha'ul HaMelech 27");
        museumOfArt.setLatitude(32.0776566);
        museumOfArt.setLongitude(34.7862004);


        // Create an ArrayList of AndroidFlavor objects
        final ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();
        androidFlavors.add(new AndroidFlavor("Tel Aviv Promenade", "14 kilometers of walking/biking paths along the Mediterranean Sea. ", R.drawable.beach, promenad));
        androidFlavors.add(new AndroidFlavor("Port of Jaffa", "Biblical legend says that one of the sons of Noah, Japheth, built it after surviving the Great Flood in in the Ark.", R.drawable.ojaffaport, oJaffaPort));
        androidFlavors.add(new AndroidFlavor("Rabin Square, Tel Aviv-Yafo", "A large public city square in the center of Tel Aviv,", R.drawable.rabinsq, rabinsq));
        androidFlavors.add(new AndroidFlavor("Sarona", "33 original Templar buildings dating up to more than 140 years", R.drawable.sarona, sarona));
        androidFlavors.add(new AndroidFlavor("Flea Market", " Jaffa flea market is a well known attraction of the area, with vendors selling", R.drawable.market, market));
        androidFlavors.add(new AndroidFlavor("Old Jaffa", "The Old City of Jaffa is the historical part of the Israeli city of Jaffa", R.drawable.oldjaffa, oldjaffa));
        androidFlavors.add(new AndroidFlavor("Tel Aviv Museum of Art", "The ultramodern ‘envelope’ building located on the eastern edge of the city centre.", R.drawable.museum, museumOfArt));



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
