package myapp.bmtc.com.bmtc_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class bookingHistory extends AppCompatActivity {
    String phonenum;
    String history="";
//    String histarr[]=new String[1];//declaration and instantiation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);


        phonenum=getIntent().getStringExtra("username");
        final String phoneNum = phonenum;

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {

                    System.out.println(phoneNum);

                    //URL url2 = new URL("http://namandosi.000webhostapp.com/bookHistory.php?phone="+phoneNum);
                    URL url2 = new URL("http://anaghav.000webhostapp.com/bookHistory.php?phone="+phoneNum);

                    HttpURLConnection con = (HttpURLConnection) url2.openConnection();
                    con.setRequestMethod("GET");
                    System.out.println("In onClick-45");
                    int status = con.getResponseCode();
                    System.out.println(status);
                    System.out.println("In booking History onClick-46");


                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line=in.readLine())!=null)
                    {
                        total.append(line).append("\n");
                    }
                    history = history+total.toString();
                    //System.out.println(total.toString());
//
                    System.out.println(history);
                    System.out.println("outside");
//                    histarr[0]=history;
//                    System.out.println(histarr[0]);
//                    Toast.makeText(getApplicationContext(),history,Toast.LENGTH_LONG).show();


//                    System.out.println(history);
//                    TextView tv = (TextView) findViewById(R.id.bhistory);
//                    tv.setText(history);




                } catch (Exception e) {
                    System.out.println("In onClick-47");
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        });
        System.out.println("before");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after blaaaaaaaaaaah");
        System.out.println(history);
        TextView tv = (TextView) findViewById(R.id.bhistory);
        tv.setText(history);
//        Toast.makeText(getApplicationContext(),history,Toast.LENGTH_LONG).show();
//        super.onCreate(savedInstanceState);
//        setContentView(R.id.bhistory);
//        LinearLayout lView=new LinearLayout(this);
//        TextView myText=new TextView(this);
//        TextView.setText()
    }

}
