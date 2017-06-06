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

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants);

        //locations for map
        android.location.Location neve = new android.location.Location("Garrigue Restaurant");
        neve.setLatitude(32.0637797);
        neve.setLongitude(34.7688533);
        android.location.Location topolopompo = new android.location.Location("Topolopompo");
        topolopompo.setLatitude(32.0689399);
        topolopompo.setLongitude(34.7779971);
        android.location.Location shila = new android.location.Location("Shila - Sharon Cohen's Kitchen & Bar");
        shila.setLatitude(32.0882139);
        shila.setLongitude(34.7715033);
        android.location.Location sabich = new android.location.Location("Frishman Falafel & Frishman Sabich");
        sabich.setLatitude(32.0796088);
        sabich.setLongitude(34.7714604);
        android.location.Location market = new android.location.Location("Abu Hassan Restaurant Jaffa");
        market.setLatitude(32.0502566);
        market.setLongitude(34.7486763);
        android.location.Location oldjaffa = new android.location.Location("Abouelafia Bakery, Jaffa");
        oldjaffa.setLatitude(32.0543037);
        oldjaffa.setLongitude(34.7537276);
        android.location.Location hatraklin = new android.location.Location("Hatraklin Bistro Meat & Wine, Tel Aviv");
        hatraklin.setLatitude(32.0616667);
        hatraklin.setLongitude(34.7665224);

        // Create an ArrayList of LocationNew objects
        final ArrayList<LocationNew> androidLocations = new ArrayList<LocationNew>();
        androidLocations.add(new LocationNew("Garrigue Restaurant", "French European Vegetarian Friendly Vegan Options\n££££", R.drawable.garrig, neve));
        androidLocations.add(new LocationNew("Topolopompo", " Asian Thai Vegetarian Friendly Vegan Options Gluten Free\n££££", R.drawable.topolopompo, topolopompo));
        androidLocations.add(new LocationNew("Shila - Sharon Cohen's Kitchen & Bar", "Seafood Mediterranean European Vegetarian Friendly\n££££", R.drawable.shila, shila));
        androidLocations.add(new LocationNew("Frishman Falafel & Frishman Sabich", " Mediterranean Middle Eastern Israeli Fast food\n£", R.drawable.sabich, sabich));
        androidLocations.add(new LocationNew("Abu Hassan Restaurant Jaffa", "Fast food Mediterranean Middle Eastern Israeli\n£", R.drawable.abuhasan, market));
        androidLocations.add(new LocationNew("Abouelafia Bakery, Jaffa", "Mediterranean Middle Eastern Israeli Arabic\n", R.drawable.abouelefiabakery, oldjaffa));
        androidLocations.add(new LocationNew("Hatraklin Bistro Meat & Wine, Tel Aviv", "Mediterranean European Wine Bar Israeli Grill\n££££", R.drawable.hatraklin, hatraklin));



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