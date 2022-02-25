using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ClickableLine : MonoBehaviour
{

    (int, int) endpoint1;
    (int, int) endpoint2;

    bool drawn;

    LineManager manager;

    Color[] colors = new Color[] {Color.white, Color.red, Color.green, Color.blue};
    int colorIndex;

    public void Init(LineManager manager, (int, int) endpoint1, (int, int) endpoint2){
        this.manager = manager;
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
        drawn = false;

        colorIndex = 0;
        GetComponent<Renderer>().material.color = colors[colorIndex];

        // Debug.Log($"made line from {endpoint1} to {endpoint2}");
    }

    void OnMouseDown(){
        //allows color to change back with click
        if(colorIndex == 2){
            colorIndex = 0;
        }
        else{
            colorIndex=2;
        }
        GetComponent<Renderer>().material.color = colors[colorIndex];

        // TODO implement button to actually confirm
        confirmClick();
    }   

    void confirmClick(){
        drawn = true;
        manager.checkForBoxAt(endpoint1, endpoint2);
    }

    bool isDrawn(){
        return drawn;
    }

}