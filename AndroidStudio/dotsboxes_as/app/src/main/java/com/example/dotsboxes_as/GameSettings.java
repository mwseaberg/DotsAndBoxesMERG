package com.example.dotsboxes_as;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);

        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openGamePlay();
            }
        });
    }

    public void openGamePlay(){
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openHomePage(){
        Intent intent  = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}

