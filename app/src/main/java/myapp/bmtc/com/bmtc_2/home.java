package myapp.bmtc.com.bmtc_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    Button login,bookTicket,bookingHistory,trackLocation,myWallet,profile,help,register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        login = (Button) findViewById(R.id.login);
//        profile = (Button) findViewById(R.id.profile);
//        bookTicket = (Button) findViewById(R.id.bookTicket);
//        bookingHistory = (Button) findViewById(R.id.bookingHistory);
//        trackLocation = (Button) findViewById(R.id.trackLocation);
//        myWallet = (Button) findViewById(R.id.myWallet);
//        help = (Button) findViewById(R.id.help);
        register=(Button) findViewById(R.id.register);

        login.setOnClickListener(this);
//        profile.setOnClickListener(this);
//        bookingHistory.setOnClickListener(this);
//        bookTicket.setOnClickListener(this);
//        trackLocation.setOnClickListener(this);
//        myWallet.setOnClickListener(this);
//        help.setOnClickListener(this);
        register.setOnClickListener(this);


        Log.d("tag","In onCreate");
        Log.e("tag","In onCreate");
        Log.w("tag","In onCreate");
        Log.i("tag","In onCreate");





    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.login :
                Intent intent_login = new Intent(home.this,LoginActivity.class);
                startActivity(intent_login);

                Log.i("tag","button pushed");
                //textView.setText("Login");
                break;

//            case R.id.profile :
//                Intent intent = new Intent(home.this,profile.class);
//                startActivity(intent);
//
//                Log.i("tag","button pushed2");
//                // textView.setText("Profile");
//                break;
//
//            case R.id.bookingHistory :
//                Intent intent_booking_history = new Intent(home.this,bookingHistory.class);
//                startActivity(intent_booking_history);
//
//                Log.i("tag","button pushed2");
//                // textView.setText("Booking History");
//                break;
//
//            case R.id.bookTicket :
//                Intent intent_bookTicket = new Intent(home.this, bookTicket.class);
//                startActivity(intent_bookTicket);
//
//                Log.i("tag","button pushed2");
//                // textView.setText("Book Ticket");
//                break;
//
//            case R.id.myWallet :
//                Intent intent_wallet = new Intent(Intent.ACTION_VIEW, Uri.parse("https://paytm.com/"));
//                startActivity(intent_wallet);
//
//                Log.i("tag","button pushed2");
//                // textView.setText("My Wallet");
//                break;
//
//            case R.id.trackLocation :
//                Intent intent_location = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:12.8447512,77.6610377,17?z=16"));
//                startActivity(intent_location);
//
//                Log.i("tag","button pushed2");
//                // textView.setText("Track Location");
//                break;
//
//            case R.id.help :
//                Intent intent_help = new Intent(home.this, help.class);
//                startActivity(intent_help);
//
//                Log.i("tag","button pushed2");
//                // textView.setText("Help");
//                break;

            case R.id.register :
                Intent intent_register = new Intent(home.this, RegisterActivity.class);
                startActivity(intent_register);

                Log.i("tag","button pushed2");
                // textView.setText("Help");
                break;

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
