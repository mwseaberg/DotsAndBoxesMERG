using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ConfirmButton : MonoBehaviour
{
    Color color_disabled = Color.black; //new Color(255, 255, 255);
    Color color_enabled = Color.white;

    bool clickable = false;

    GameManager manager;

    public void setManager(GameManager manager){
        this.manager = manager;
        disable();
    }

    void OnMouseDown(){
        if(clickable){
            manager.endTurn();
        }
    }

    public void enable(){
        clickable = true;
        GetComponent<Renderer>().material.color = color_enabled;
    }

    public void disable(){
        clickable = false;
        GetComponent<Renderer>().material.color = color_disabled;
    }
}
