package com.example.loginsimpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name ;
    private EditText Password ;
    private TextView Info ;
    private Button Login ;
    private Button Cancel ;
    private int counter = 5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.bLogin);
        Cancel = (Button) findViewById(R.id.bCancel);
        Info.setText("N° of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }}); }



    // void because not returning anything
    private void validate(String userName , String userPassword){
        if((userName.equals("Admin") )&& (userPassword.equals("1234"))){
            Intent i1 = new Intent (MainActivity.this , SecondActivity.class);
            startActivity(i1);
        }else {
            counter--; //décrimentation

            Info.setText("N° of attempts remaining :" + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);

            }

        }

    }

}