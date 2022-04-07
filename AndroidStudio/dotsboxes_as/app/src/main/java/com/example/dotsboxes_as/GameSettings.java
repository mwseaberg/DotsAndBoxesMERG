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

        // set listeners for < > icon buttons
        Button buttonP1PrevIcon = (Button) findViewById(R.id.buttonP1PrevIcon);
        buttonP1PrevIcon.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                p1PrevIcon();
            }
        });
        Button buttonP1NextIcon = (Button) findViewById(R.id.buttonP1NextIcon);
        buttonP1NextIcon.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                p1NextIcon();
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

    public void p1PrevIcon(){

    }

    public void p1NextIcon(){

    }

}

