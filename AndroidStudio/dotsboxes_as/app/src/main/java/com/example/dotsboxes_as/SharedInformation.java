package com.example.dotsboxes_as;

import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SharedInformation {

    public class IconColor{
        int iconAddress;
        int color;

        public IconColor(int iconAddress, int color) {
            this.iconAddress = iconAddress;
            this.color = color;
        }
    }

//    private final ArrayList<IconColor> iconColorMappings = new ArrayList();


    private final IconColor[] iconColorMappings = {
            new IconColor(R.drawable.bunny, Color.parseColor("#ff75bc")),
            new IconColor(R.drawable.cat, Color.parseColor("#ffca06")),
            new IconColor(R.drawable.bird, Color.parseColor("#409e75")),
            new IconColor(R.drawable.deer, Color.parseColor("#f8b0be")),
            new IconColor(R.drawable.frog, Color.parseColor("#ff9d31")),
            new IconColor(R.drawable.owl, Color.parseColor("#f20730")),
            new IconColor(R.drawable.fish, Color.parseColor("#1f54ff")),
            new IconColor(R.drawable.bat, Color.parseColor("#b346cf")),
            new IconColor(R.drawable.swan, Color.parseColor("#9b1f36")),
            new IconColor(R.drawable.penguin, Color.parseColor("#f6917d")),
            new IconColor(R.drawable.butterfly, Color.parseColor("#44bba0")),
            new IconColor(R.drawable.wolf, Color.parseColor("#a5abc2"))
    };

//    public void setIconColorMappings(){
//        iconColorMappings.add(new IconColor(R.drawable.frog, Color.GREEN));
//        iconColorMappings.add(new IconColor(R.drawable.cat, Color.YELLOW));
//    }

    public IconColor[] getIconColorMappings(){
        return iconColorMappings;
    }

    public int getIconColorMappingsLength(){
        return iconColorMappings.length;
    }

    public int getAddress(int index){
        return iconColorMappings[index].iconAddress;
    }

    public int getColor(int index){
        return iconColorMappings[index].color;
    }
}
