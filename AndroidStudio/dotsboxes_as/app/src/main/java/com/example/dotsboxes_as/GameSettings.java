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
        iconColorMappings.add(new IconColor(R.drawable.frog, getResources().getColor(R.color.colorPrimary)));
        iconColorMappings.add(new IconColor(R.drawable.cat, getResources().getColor(R.color.colorAccent)));
    }

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
                updateIndex(1, p1Index-1);
            }
        });
        p1_Next.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateIndex(1, p1Index+1);
            }
        });
        p2_Prev.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateIndex(2, p2Index-1);
            }
        });
        p2_Next.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateIndex(2, p2Index+1);
            }
        });

        setIconColorMappings();

        p1Index = 0;
        p2Index = 0;

        updateIndex(1,p1Index);
        updateIndex(2,p2Index);

//        p1_iconView.setBackgroundResource(iconColorMappings.get(p1Index).iconAddress);
//        p1_colorView.setBackgroundColor(iconColorMappings.get(p1Index).color);
//        p2_iconView.setBackgroundResource(iconColorMappings.get(p2Index).iconAddress);
//        p2_colorView.setBackgroundColor(iconColorMappings.get(p2Index).color);

    }

    public void openGamePlay(){
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // TODO: note, should not be able to select both as the same icon (OR maybe it's fine?)

    private void updateIndex(int player, int index){
        if(1==player){
            p1Index = index;
            // loop start and end
            if(p1Index<0){
                p1Index = iconColorMappings.size()-1;
            } else if(p1Index>iconColorMappings.size()-1){
                p1Index = 0;
            }
            p1_iconView.setBackgroundResource(iconColorMappings.get(p1Index).iconAddress);
            p1_colorView.setBackgroundColor(iconColorMappings.get(p1Index).color);
        } else {
            p2Index = index;
            // loop start and end
            if(p2Index<0){
                p2Index = iconColorMappings.size()-1;
            } else if(p2Index>iconColorMappings.size()-1){
                p2Index = 0;
            }
            p2_iconView.setBackgroundResource(iconColorMappings.get(p2Index).iconAddress);
            p2_colorView.setBackgroundColor(iconColorMappings.get(p2Index).color);
        }
    }

}

