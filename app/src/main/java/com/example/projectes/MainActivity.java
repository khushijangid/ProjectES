package com.example.projectes;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Main Screen", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, activity2.class);
                startActivity(i);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Rules", Toast.LENGTH_LONG).show();
                Intent i2 = new Intent(MainActivity.this, rules.class);
                startActivity(i2);
            }
        });
    }
    /*
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn1:
                Toast.makeText(this,"Main Screen", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, activity2.class);
                startActivity(i);
                break;


            case R.id.btn2:
                Toast.makeText(this,"Rules", Toast.LENGTH_LONG).show();
                Intent i2 = new Intent(MainActivity.this, rules.class);
                startActivity(i2);
                break;

        }*/
}