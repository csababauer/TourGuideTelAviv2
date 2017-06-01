package com.example.android.tourguidetelaviv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView button = (TextView) findViewById(R.id.sightseeing);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sightIntent = new Intent(MainActivity.this, Sightseeing.class);
                // Start the new activity
                startActivity(sightIntent);
            }
        });

        TextView button2 = (TextView) findViewById(R.id.restaurant);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restIntent = new Intent(MainActivity.this, Restaurants.class);
                // Start the new activity
                startActivity(restIntent);
            }
        });

        TextView button3 = (TextView) findViewById(R.id.hotel);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelIntent = new Intent(MainActivity.this, Hotels.class);
                // Start the new activity
                startActivity(hotelIntent);
            }
        });
    }
}
