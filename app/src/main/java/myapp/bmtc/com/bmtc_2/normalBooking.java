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
import java.net.HttpURLConnection;
import java.net.URL;

public class normalBooking extends AppCompatActivity implements View.OnClickListener {

    Button route;
    Spinner start, stop,busroute;
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

                System.out.println("In onClick-4");
                final String ori = start.getSelectedItem().toString();
                System.out.println("In onClick-41");
                final String des = stop.getSelectedItem().toString();
                System.out.println("In onClick-42");
                final String busNo = busroute.getSelectedItem().toString();
                System.out.println("In onClick-43");

                System.out.println("In onClick-44");


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                            //URL url = new URL("https://c9a360f8.ngrok.io/yourpath?name="+name+"&username="+username+"&password="+password+"&age="+age);
                            URL url2 = new URL("http://namandosi.000webhostapp.com/Booking.php?start="+ori+"&end="+des+"&busNum="+busNo);
                            HttpURLConnection con = (HttpURLConnection) url2.openConnection();
                            con.setRequestMethod("GET");
                            System.out.println("In onClick-45");
                            int status = con.getResponseCode();
                            System.out.println(status);
                            System.out.println("In onClick-46");


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
