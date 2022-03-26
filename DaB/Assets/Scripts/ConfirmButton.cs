using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ConfirmButton : MonoBehaviour
{

    GameManager manager;

    public void setManager(GameManager manager){
        this.manager = manager;
    }

    void OnMouseDown(){
        manager.hideConfirmTurnButton();
        // Destroy(this);
    }
}
