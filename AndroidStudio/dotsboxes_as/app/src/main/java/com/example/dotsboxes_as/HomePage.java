
package com.example.dotsboxes_as;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        //howtoplay button
        ImageButton buttonHow = (ImageButton) findViewById(R.id.buttonPlay);
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

        //hide top title bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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

