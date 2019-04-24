package myapp.bmtc.com.bmtc_2;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{


    Button register;
    EditText etAge;
    EditText etName ;
    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);


        System.out.println("In onClick-1");

       etName = (EditText) findViewById(R.id.etName);
       etUsername = (EditText) findViewById(R.id.etUsername);
       etPassword = (EditText) findViewById(R.id.etPassword);
       etAge = (EditText) findViewById(R.id.etAge);


        register = (Button) findViewById(R.id.bRegister);
        System.out.println("In onClick-2");
        register.setOnClickListener(this);
        System.out.println("In onClick-3");
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bRegister :

                System.out.println("In onClick-4");
                final String name = etName.getText().toString();
                System.out.println("In onClick-41");
                final String username = etUsername.getText().toString();
                System.out.println("In onClick-42");
                final String password = etPassword.getText().toString();
                System.out.println("In onClick-43");
                final int age = Integer.parseInt(etAge.getText().toString());

                System.out.println("In onClick-44");


                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
                Date currentLocalTime =cal.getTime();
                DateFormat date = new SimpleDateFormat("HH:mm:ss a");
                date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
                final String localTime = date.format(currentLocalTime);
                System.out.println(localTime);

                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                                URL url1 = new URL("https://3b15718b.ngrok.io/register?name="+name+"&phone="+username+"&age="+age+"&request=GET&fun=RegisterActivityOnClick");
                                URL url2 = new URL("http://namandosi.000webhostapp.com/Register.php?name="+name+"&phone="+username+"&password="+password+"&age="+age);
                                HttpURLConnection con = (HttpURLConnection) url2.openConnection();
                                con.setRequestMethod("GET");
                                System.out.println("In onClick-45");
                                int status = con.getResponseCode();
                                System.out.println(status);
                                System.out.println("In onClick-46");


                            HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
                            con1.setRequestMethod("GET");
                            System.out.println("In onClick-45");
                            int status1 = con1.getResponseCode();
                            System.out.println(status1);

                        } catch (Exception e) {
                            System.out.println("In onClick-47");
                            System.out.println(e);
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();
//                try{
//                    URL url = new URL("https://c9a360f8.ngrok.io/yourpath?a=5&b=10&c=11");
//                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                    con.setRequestMethod("GET");
//                    System.out.println("In onClick-45");
//                    int status = con.getResponseCode();
//                    System.out.println(status);
//                    System.out.println("In onClick-46");
//                }catch(Exception e)
//                {
//                    System.out.println("In onClick-47");
//                    System.out.println(e);
//                }


                System.out.println("In onClick-5");

                if(name.isEmpty() || password.isEmpty() || username.isEmpty() || (Integer.toString(age)).isEmpty() )
                {
                    Message.message(getApplicationContext(),"Enter all details.");
                }
                else {

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                System.out.println("In onClick try");
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    System.out.println("In onClick success");
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    RegisterActivity.this.startActivity(intent);
                                } else {
                                    System.out.println("In onClick fail");
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("Register Failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                System.out.println("In onClick exception");
                                e.printStackTrace();
                            }
                        }
                    };

                    System.out.println(responseListener);

                    System.out.println("In onClick register request");
                    RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);
                    System.out.println("In onClick done");
//                Intent intent_register_act = new Intent(RegisterActivity.this,LoginActivity.class);
//                startActivity(intent_register_act);
//                    Message.message(getApplicationContext(), "Ticket booked!");

                    Log.i("tag", "button pushed2");
                    // textView.setText("Booking History");
                    break;
                }
        }
    }

}
