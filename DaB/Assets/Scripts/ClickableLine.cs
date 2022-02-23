using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ClickableLine : MonoBehaviour
{

    Color[] colors = new Color[] {Color.white, Color.red, Color.green, Color.blue};
    int colorIndex;

    public void Init(){
        colorIndex = 0;
        GetComponent<Renderer>().material.color = colors[colorIndex];
        Debug.Log("init!");
    }

    void OnMouseDown(){
        colorIndex = 2;
        GetComponent<Renderer>().material.color = colors[colorIndex];
        Debug.Log("clicked!");
    }   

}
