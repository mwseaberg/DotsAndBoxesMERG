using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FillableSquare : MonoBehaviour
{
    // (int, int)[] endpoints = new (int, int)[4];
    (int,int) originPoint;
    
    Color[] colors = new Color[] {Color.white, Color.red, Color.green, Color.blue};
    int colorIndex;

    public void Init((int, int) originPoint){
        this.originPoint = originPoint;
        colorIndex = 0;
        GetComponent<Renderer>().material.color = colors[colorIndex];

        // Debug.Log($"made square at {originPoint}");
    }

    public void Fill(Color isPrimary){
        //colorIndex=2;
        GetComponent<Renderer>().material.color = isPrimary;
        Debug.Log("filled!");
    }   
}
