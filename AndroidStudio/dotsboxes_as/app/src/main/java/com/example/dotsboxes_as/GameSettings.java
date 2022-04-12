package com.example.dotsboxes_as;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameSettings extends AppCompatActivity {

    class IconColor{
        int iconAddress;
        int color;

        public IconColor(int iconAddress, int color) {
            this.iconAddress = iconAddress;
            this.color = color;
        }
    }

    private final ArrayList<IconColor> iconColorMappings = new ArrayList();

    int p1Index;
    int p2Index;

    private void setIconColorMappings(){
        iconColorMappings.add(new IconColor(R.drawable.frog, Color.GREEN));
        iconColorMappings.add(new IconColor(R.drawable.cat, Color.RED));
    }

    View iconView;
    View colorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);

        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
        Button buttonP1PrevIcon = (Button) findViewById(R.id.buttonP1PrevIcon);
        Button buttonP1NextIcon = (Button) findViewById(R.id.buttonP1NextIcon);

        iconView = (View) findViewById(R.id.p1Icon);
        colorView = (View) findViewById(R.id.p1Color);

        buttonPlay.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openGamePlay();
            }
        });
        buttonP1PrevIcon.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                p1PrevIcon();
            }
        });
        buttonP1NextIcon.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                p1NextIcon();
            }
        });

        p1Index = 0;
        p2Index = 0;

        setIconColorMappings();
        iconView.setBackgroundResource(iconColorMappings.get(p1Index).iconAddress);
        colorView.setBackgroundColor(iconColorMappings.get(p1Index).color);

    }

    public void openGamePlay(){
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openHomePage(){
        Intent intent  = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    // TODO: note, should not be able to select both as the same icon (OR maybe it's fine?)

    public void p1PrevIcon(){
        updateIndex(1, p1Index-1);
    }

    public void p1NextIcon(){
        updateIndex(1, p1Index+1);
    }

    private void updateIndex(int player, int index){
        if(1==player){
            p1Index = index;
            // loop start and end
            if(p1Index<0){
                p1Index = iconColorMappings.size()-1;
            } else if(p1Index>iconColorMappings.size()-1){
                p1Index = 0;
            }
            iconView.setBackgroundResource(iconColorMappings.get(p1Index).iconAddress);
            colorView.setBackgroundColor(iconColorMappings.get(p1Index).color);
        } else {
            // TODO
        }
    }

}

