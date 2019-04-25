package myapp.bmtc.com.bmtc_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class bookTicket extends AppCompatActivity implements View.OnClickListener{

    Button quickBooking, normalBooking, passBook;
    String phonenum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);

        quickBooking = (Button) findViewById(R.id.quick);
        normalBooking = (Button) findViewById(R.id.normal);
        passBook = (Button) findViewById(R.id.pass);

        quickBooking.setOnClickListener(this);
        normalBooking.setOnClickListener(this);
        passBook.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.quick :
                Intent intent_quick = new Intent(bookTicket.this,quickBook.class);
                startActivity(intent_quick);
                break;

            case R.id.normal :
                phonenum=getIntent().getStringExtra("username");
                Intent intent_normal = new Intent(bookTicket.this,normalBooking.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", phonenum);
                intent_normal.putExtras(bundle);
                startActivity(intent_normal);
                break;

            case R.id.pass :
                Intent intent_passbooking = new Intent(bookTicket.this,passBook.class);
                startActivity(intent_passbooking);

                Log.i("tag","button pushed2");
                // textView.setText("Booking History");
                break;


        }
    }
}
