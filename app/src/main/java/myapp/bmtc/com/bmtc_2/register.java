package myapp.bmtc.com.bmtc_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class register extends AppCompatActivity {

    EditText Name, Dob,Num,Pass;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name= (EditText) findViewById(R.id.enterusername);
        Dob= (EditText) findViewById(R.id.enteruserdob);
        Pass= (EditText) findViewById(R.id.enteruserpass);
        Num= (EditText) findViewById(R.id.enteruserno);
        helper = new myDbAdapter(this);

    }

    public void addUser(View view)
    {
        String t1 = Name.getText().toString();
        String t2 = Dob.getText().toString();
        String t3 = Num.getText().toString();
        String t4 = Pass.getText().toString();
        if(t1.isEmpty() || t2.isEmpty() || t3.isEmpty() || t4.isEmpty() )
        {
            Message.message(getApplicationContext(),"Enter all details.");
        }
        else
        {
            long id = helper.insertData(t1,t2,t3,t4);
            if(id<=0)
            {
                Message.message(getApplicationContext(),"Error. Try again.");
                Name.setText("");
                Dob.setText("");
                Pass.setText("");
                Num.setText("");
            } else
            {
                Message.message(getApplicationContext(),"Login to continue.");
                Name.setText("");
                Dob.setText("");
                Pass.setText("");
                Num.setText("");
            }
        }
    }

    public void viewdata(View view)
    {
        String data = helper.getData();
        Message.message(this,data);
    }

    public void gotoLogin(View view){
        Intent intent = new Intent(register.this,LoginActivity.class);
        startActivity(intent);
    }

}
