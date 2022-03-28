
package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //howtoplay button
        Button buttonHow = (Button) findViewById(R.id.buttonPlay);
        buttonHow.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHowToPlay();
            }

        });

        //newgame button
        Button buttonNew = (Button) findViewById(R.id.button2);
        buttonNew.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openGameSettings();
            }

        });

    }


    //open new pages from home screen buttons
    public void openHowToPlay(){
        Intent intent  = new Intent(this, HowToPlay.class);
        startActivity(intent);
    }
    public void openGameSettings(){
        Intent intent  = new Intent(this, GameSettings.class);
        startActivity(intent);
    }
}
