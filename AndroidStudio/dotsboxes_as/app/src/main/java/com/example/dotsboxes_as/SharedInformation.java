package com.example.dotsboxes_as;

import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SharedInformation {
    String[] hexColors = new String[]{
            "#ff75bc", "#ffca06", "#409e75", "#f8b0be", "#ff9d31", "#f20730", "#1f54ff", "#b346cf", "#9b1f36", "#f6917d", "#44bba0", "#a5abc2"
    };

    public SharedInformation() {
//        hexColors = /;
    }

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
            new IconColor(R.drawable.bunny, Color.parseColor(hexColors[0])),
            new IconColor(R.drawable.cat, Color.parseColor(hexColors[1])),
            new IconColor(R.drawable.bird, Color.parseColor(hexColors[2])),
            new IconColor(R.drawable.deer, Color.parseColor(hexColors[3])),
            new IconColor(R.drawable.frog, Color.parseColor(hexColors[4])),
            new IconColor(R.drawable.owl, Color.parseColor(hexColors[5])),
            new IconColor(R.drawable.fish, Color.parseColor(hexColors[6])),
            new IconColor(R.drawable.bat, Color.parseColor(hexColors[7])),
            new IconColor(R.drawable.swan, Color.parseColor(hexColors[8])),
            new IconColor(R.drawable.penguin, Color.parseColor(hexColors[9])),
            new IconColor(R.drawable.butterfly, Color.parseColor(hexColors[10])),
            new IconColor(R.drawable.wolf, Color.parseColor(hexColors[11]))
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
