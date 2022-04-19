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


    private final IconColor[] iconColorMappings = { new IconColor(R.drawable.frog, Color.GREEN),
                                                    new IconColor(R.drawable.cat, Color.YELLOW) };

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
