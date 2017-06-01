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

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants);

        //locations for map
        Location neve = new Location("Garrigue Restaurant");
        neve.setLatitude(32.0637797);
        neve.setLongitude(34.7688533);
        Location topolopompo = new Location("Topolopompo");
        topolopompo.setLatitude(32.0689399);
        topolopompo.setLongitude(34.7779971);
        Location shila = new Location("Shila - Sharon Cohen's Kitchen & Bar");
        shila.setLatitude(32.0882139);
        shila.setLongitude(34.7715033);
        Location sabich = new Location("Frishman Falafel & Frishman Sabich");
        sabich.setLatitude(32.0796088);
        sabich.setLongitude(34.7714604);
        Location market = new Location("Abu Hassan Restaurant Jaffa");
        market.setLatitude(32.0502566);
        market.setLongitude(34.7486763);
        Location oldjaffa = new Location("Abouelafia Bakery, Jaffa");
        oldjaffa.setLatitude(32.0543037);
        oldjaffa.setLongitude(34.7537276);
        Location hatraklin = new Location("Hatraklin Bistro Meat & Wine, Tel Aviv");
        hatraklin.setLatitude(32.0616667);
        hatraklin.setLongitude(34.7665224);

        // Create an ArrayList of AndroidFlavor objects
        final ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();
        androidFlavors.add(new AndroidFlavor("Garrigue Restaurant", "French European Vegetarian Friendly Vegan Options\n££££", R.drawable.garrig, neve));
        androidFlavors.add(new AndroidFlavor("Topolopompo", " Asian Thai Vegetarian Friendly Vegan Options Gluten Free\n££££", R.drawable.topolopompo, topolopompo));
        androidFlavors.add(new AndroidFlavor("Shila - Sharon Cohen's Kitchen & Bar", "Seafood Mediterranean European Vegetarian Friendly\n££££", R.drawable.shila, shila));
        androidFlavors.add(new AndroidFlavor("Frishman Falafel & Frishman Sabich", " Mediterranean Middle Eastern Israeli Fast food\n£", R.drawable.sabich, sabich));
        androidFlavors.add(new AndroidFlavor("Abu Hassan Restaurant Jaffa", "Fast food Mediterranean Middle Eastern Israeli\n£", R.drawable.abuhasan, market));
        androidFlavors.add(new AndroidFlavor("Abouelafia Bakery, Jaffa", "Mediterranean Middle Eastern Israeli Arabic\n", R.drawable.abouelefiabakery, oldjaffa));
        androidFlavors.add(new AndroidFlavor("Hatraklin Bistro Meat & Wine, Tel Aviv", "Mediterranean European Wine Bar Israeli Grill\n££££", R.drawable.hatraklin, hatraklin));



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