package com.example.dotsboxes_as;

import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameSettings extends AppCompatActivity {

    int p1Index;
    int p2Index;

    SharedInformation information = new SharedInformation();

    View p1_iconView;
    View p1_colorView;
    View p2_iconView;
    View p2_colorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);

        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);

        Button p1_Prev = (Button) findViewById(R.id.buttonP1PrevIcon);
        Button p1_Next = (Button) findViewById(R.id.buttonP1NextIcon);
        Button p2_Prev = (Button) findViewById(R.id.buttonP2PrevIcon);
        Button p2_Next = (Button) findViewById(R.id.buttonP2NextIcon);

        p1_iconView = (View) findViewById(R.id.p1Icon);
        p1_colorView = (View) findViewById(R.id.p1Color);
        p2_iconView = (View) findViewById(R.id.p2Icon);
        p2_colorView = (View) findViewById(R.id.p2Color);

        buttonPlay.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openGamePlay();
            }
        });
        p1_Prev.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateIndex(1, -1);
            }
        });
        p1_Next.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateIndex(1, +1);
            }
        });
        p2_Prev.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateIndex(2, -1);
            }
        });
        p2_Next.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateIndex(2, +1);
            }
        });

        p1Index = 0;
        p2Index = 0;

        updateIndex(1,0);
        updateIndex(2,1);

//        p1_iconView.setBackgroundResource(iconColorMappings.get(p1Index).iconAddress);
//        p1_colorView.setBackgroundColor(iconColorMappings.get(p1Index).color);
//        p2_iconView.setBackgroundResource(iconColorMappings.get(p2Index).iconAddress);
//        p2_colorView.setBackgroundColor(iconColorMappings.get(p2Index).color);


        //hide top title bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void openGamePlay(){
        if(p1Index==p2Index){
            Toast.makeText(getApplicationContext(), "Players cannot use the same icon!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("P1_ICON_COLOR_PICK", p1Index);
            intent.putExtra("P2_ICON_COLOR_PICK", p2Index);
            startActivity(intent);
        }
    }

    // TODO: note, should not be able to select both as the same icon ***

    private void updateIndex(int player, int increase){
        if(1==player){
            p1Index = Math.floorMod(p1Index+increase, information.getIconColorMappingsLength());
            if (p2Index == p1Index) {
                p1Index = Math.floorMod(p2Index+increase, information.getIconColorMappingsLength());
            }
            p1_iconView.setBackgroundResource(information.getIconColorMappings()[p1Index].iconAddress);
            p1_colorView.setBackgroundColor(information.getIconColorMappings()[p1Index].color);
        } else {
            p2Index = Math.floorMod(p2Index+increase, information.getIconColorMappingsLength());
            if (p2Index == p1Index) {
                p2Index = Math.floorMod(p2Index+increase, information.getIconColorMappingsLength());
            }
            p2_iconView.setBackgroundResource(information.getIconColorMappings()[p2Index].iconAddress);
            p2_colorView.setBackgroundColor(information.getIconColorMappings()[p2Index].color);
        }
    }

}

