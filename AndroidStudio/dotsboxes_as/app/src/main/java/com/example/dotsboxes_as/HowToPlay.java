package com.example.dotsboxes_as;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HowToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

    }
    public void openHomePage(){
        Intent intent  = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}