package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HowToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);


        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHomePage();
            }
        });
    }
    public void openHomePage(){
        Intent intent  = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}