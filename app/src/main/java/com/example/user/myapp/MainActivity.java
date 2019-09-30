package com.example.user.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
                validate(Name.getText().toString(),Password.getText().toString());

            }
        });
    }
    public void openRegister(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
    private void validate(String userName,String userPassword){
        if ((userName=="Admin") &&(userPassword=="12345")){
            Intent intent = new Intent(MainActivity.this, Registration.class);
            startActivity(intent);
        }else {
            counter--;
            Info.setText("No of attempts remaining: " + String.valueOf(counter));
            if (counter==0){
                Login.setEnabled(false);
            }
        }
    }

    }

