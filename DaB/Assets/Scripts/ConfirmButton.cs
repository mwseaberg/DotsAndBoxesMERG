using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ConfirmButton : MonoBehaviour
{

    LineManager manager;

    public void setManager(LineManager manager){
        this.manager = manager;
    }

    void OnMouseDown(){
        manager.hideConfirmTurnButton();
        // Destroy(this);
    }
}
