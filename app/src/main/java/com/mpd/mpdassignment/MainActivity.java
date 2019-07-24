// Name                 __Ian Campbell_____
// Student ID           __200507045________
// Programme of Study   ___ITMB____________
//

package com.mpd.mpdassignment;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private String url1 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2648579";
    private String url2 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/2643743";
    private String url3 =  "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/5128581";
    private String url4 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/287286";
    private String url5 = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/934154";
    private String url6 =  "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/1185241";
    private XmlParser xmlParser = new XmlParser();
    private ArrayList<WeatherObject> weatherObjects;
    private ArrayList<ListItemObjects> listItemObjects;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new GlasgowFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_glasgow);
        }
    }


    // Navigation to screens displaying the information on the weather
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_glasgow:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GlasgowFragment()).commit();
                break;
            case R.id.nav_london:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LondonFragment()).commit();
                break;
            case R.id.nav_bangladesh:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BangladeshFragment()).commit();
                break;
            case R.id.nav_newYork:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NewYorkFragment()).commit();
                break;
            case R.id.nav_oman:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OmanFragment()).commit();
                break;
            case R.id.nav_mauritius:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MauritiusFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    //Override onBackPressed when the navigation bar is open to not leave the application only
    //close the actionbar
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

/** public class Task implements Runnable {

    @Override
    public void run() {
        try {
            Log.e("MyTag", "in try loop");
            URL url = new URL(url1);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setDoInput(true);
            http.connect();
            InputStream is = http.getInputStream();
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(is, null);

        } catch (IOException e) {
            Log.e("MyTag", "ioexception detected");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        //MainActivity.this.runOnUiThread(new Runnable() {
            public void run(); {
                Log.d("UI thread", "UI thread");

            }
        }
    }
}  unable to get running  **/