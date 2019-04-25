package myapp.bmtc.com.bmtc_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class login_home extends AppCompatActivity implements View.OnClickListener{
    Button bookTicket,bookingHistory,trackLocation,myWallet,profile,help;
    String phonenum;
    //Get the bundle
//    Bundle bundle = getIntent().getExtras();
//
//    //Extract the data…
//    String stuff = bundle.getString(“”);
//    String phonenum=getIntent().getStringExtra("username");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_home);
        profile = (Button) findViewById(R.id.profile);
        bookTicket = (Button) findViewById(R.id.bookTicket);
        bookingHistory = (Button) findViewById(R.id.bookingHistory);
        trackLocation = (Button) findViewById(R.id.trackLocation);
        myWallet = (Button) findViewById(R.id.myWallet);
        help = (Button) findViewById(R.id.help);

        profile.setOnClickListener(this);
        bookingHistory.setOnClickListener(this);
        bookTicket.setOnClickListener(this);
        trackLocation.setOnClickListener(this);
        myWallet.setOnClickListener(this);
        help.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.profile :
                phonenum=getIntent().getStringExtra("username");
                System.out.println(phonenum);
                Intent intent = new Intent(login_home.this,profile.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", phonenum);
                intent.putExtras(bundle);
                startActivity(intent);

                Log.i("tag","button pushed2");
                // textView.setText("Profile");
                break;

            case R.id.bookingHistory :
                phonenum=getIntent().getStringExtra("username");
                System.out.println(phonenum);
                Intent intent_booking_history = new Intent(login_home.this,bookingHistory.class);
                Bundle bundle_bh = new Bundle();
                bundle_bh.putString("username", phonenum);
                intent_booking_history.putExtras(bundle_bh);
                startActivity(intent_booking_history);

                Log.i("tag","button pushed2");
                // textView.setText("Booking History");
                break;

            case R.id.bookTicket :
                phonenum=getIntent().getStringExtra("username");
                System.out.println(phonenum);
                Intent intent_bookTicket = new Intent(login_home.this, bookTicket.class);
                Bundle bundle_bt = new Bundle();
                bundle_bt.putString("username", phonenum);
                intent_bookTicket.putExtras(bundle_bt);
                startActivity(intent_bookTicket);

                Log.i("tag","button pushed2");
                // textView.setText("Book Ticket");
                break;

            case R.id.myWallet :
                phonenum=getIntent().getStringExtra("username");
                System.out.println(phonenum);
                Intent intent_wallet = new Intent(Intent.ACTION_VIEW, Uri.parse("https://paytm.com/"));
                Bundle bundle_w = new Bundle();
                bundle_w.putString("username", phonenum);
                intent_wallet.putExtras(bundle_w);
                startActivity(intent_wallet);

                Log.i("tag","button pushed2");
                // textView.setText("My Wallet");
                break;

            case R.id.trackLocation :
                phonenum=getIntent().getStringExtra("username");
                System.out.println(phonenum);
                Intent intent_location = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:12.8447512,77.6610377,17?z=16"));
                Bundle bundle_l = new Bundle();
                bundle_l.putString("username", phonenum);
                intent_location.putExtras(bundle_l);
//                startActivity(intent_wallet);
                startActivity(intent_location);

                Log.i("tag","button pushed2");
                // textView.setText("Track Location");
                break;

            case R.id.help :
                phonenum=getIntent().getStringExtra("username");
                System.out.println(phonenum);
                Intent intent_help = new Intent(login_home.this, help.class);
                Bundle bundle_h = new Bundle();
                bundle_h.putString("username", phonenum);
                intent_help.putExtras(bundle_h);
                startActivity(intent_help);

                Log.i("tag","button pushed2");
                // textView.setText("Help");
                break;

        }
    }

}
