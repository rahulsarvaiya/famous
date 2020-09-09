package com.example.famous;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
TextView register;
Button login;
EditText temail,tpassword;

String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
String specialCharRegex= ".*[@#!$%^&+=].*";

private static final String Login = "https://reqres.in/api/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

//      Volley code

//        Other code

        register=(TextView)findViewById(R.id.textView);
        login=(Button)findViewById(R.id.button);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Register.class);
                startActivity(i);
            }
        });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i=new Intent(getApplicationContext(),Home.class);


                    startActivity(i);
                }
            });






    }


}
