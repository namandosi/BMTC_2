package myapp.bmtc.com.bmtc_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class normalBooking extends AppCompatActivity implements View.OnClickListener {

    Button route;
    Spinner start, stop,busroute;
    String phonenum;
//    EditText origin;
//    EditText dest;
//    EditText bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_booking);

//        origin = (EditText) findViewById(R.id.editText3);
//        dest = (EditText) findViewById(R.id.editText4);
//        bus = (EditText) findViewById(R.id.editText);


        start = (Spinner) findViewById(R.id.spinner);
        stop = (Spinner) findViewById(R.id.spinner2);
        busroute = (Spinner) findViewById(R.id.spinner3);




        route = (Button) findViewById(R.id.button);
        System.out.println("In onClick-2");
        route.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.button:
                phonenum=getIntent().getStringExtra("username");
                System.out.println(phonenum);
                System.out.println("In onClick-4");
                final String ori = start.getSelectedItem().toString();
                System.out.println("In onClick-41");
                final String des = stop.getSelectedItem().toString();
                System.out.println("In onClick-42");
                final String busNo = busroute.getSelectedItem().toString();
                System.out.println("In onClick-43");
                final String phoneNum = phonenum;
                System.out.println("In onClick-44");

                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
                Date currentLocalTime =cal.getTime();
                DateFormat date = new SimpleDateFormat("yyyy-MM-dd%20HH:mm:ss");
                date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
                final String localTime = date.format(currentLocalTime);
                System.out.println(localTime);


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                            //URL url1 = new URL("https://3b15718b.ngrok.io/booking?starting="+ori+"&end="+des+"&busNum="+busNo+"&request=GET&fun=normalBookingOnClick");
                            URL url1 = new URL("https://d3521ba1.ngrok.io/booking");
                            System.out.println(phoneNum);

                           // URL url2 = new URL("http://namandosi.000webhostapp.com/Booking.php?start=Ecity&end=SilkBoard&busNum=356cw&phone=9900487369&dtime=2019-04-25 00:00:00");//+localTime);
                            //URL url2 = new URL("http://namandosi.000webhostapp.com/Booking.php?start="+ori+"&end="+des+"&busNum="+busNo+"&phone="+phoneNum+"&dtime="+localTime);
                            URL url2 = new URL("http://anaghav.000webhostapp.com/Booking.php?start="+ori+"&end="+des+"&busNum="+busNo+"&phone="+phoneNum+"&dtime="+localTime);


                            //URL url2 = new URL("http://namandosi.000webhostapp.com/Booking.php?start="+ori+"&end="+des+"&busNum="+busNo);
                            HttpURLConnection con = (HttpURLConnection) url2.openConnection();
                            con.setRequestMethod("GET");
                            System.out.println("In onClick-45");
                            int status = con.getResponseCode();
                            System.out.println(status);
                            System.out.println("In onClick-46");


                            HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
                            con1.setDoOutput(true);
                            con1.setRequestMethod("POST");
                            System.out.println("In onClick-45");


                            String param = "starting="+ori+"&end="+des+"&busNum="+busNo+"&request=POST&fun=normalBookingOnClick";
                            OutputStream os = con1.getOutputStream();
                            os.write(param.getBytes());
                            os.flush();
                            os.close();

                            int status1 = con1.getResponseCode();
                            System.out.println(status1);


                            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            StringBuilder total = new StringBuilder();
                            String line;
                            while ((line=in.readLine())!=null)
                            {
                                total.append(line);
                            }

                            System.out.println(total.toString());


                        } catch (Exception e) {
                            System.out.println("In onClick-47");
                            System.out.println(e);
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();

                Toast.makeText(getApplicationContext(),"Booked",Toast.LENGTH_LONG).show();
//                if(finalresult.equals("done")){
////                    // Message.message(getApplicationContext(),"Book Ticket");
////                    System.out.println("DONE!");
//                }
        }
    }


}
