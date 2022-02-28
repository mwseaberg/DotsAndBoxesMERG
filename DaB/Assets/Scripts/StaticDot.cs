using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class StaticDot : MonoBehaviour
{

    (int,int) centerPoint;

    public void Init((int, int) centerPoint){
        this.centerPoint = centerPoint;
        GetComponent<Renderer>().material.color = Color.red;
        Debug.Log($"Dot at {centerPoint}");
    }

}
