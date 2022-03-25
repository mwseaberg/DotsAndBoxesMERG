using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class ClickableLine : MonoBehaviour
{

  public SpriteRenderer spriteRenderer;
  public Sprite newSprite;

    (int, int) endpoint1;
    (int, int) endpoint2;

    bool drawn;

    LineManager manager;

    Color[] colors = new Color[] {Color.white, Color.red, Color.green, Color.blue};
    int colorIndex;

    Color isPrimaryLine;

    public void Init(LineManager manager, (int, int) endpoint1, (int, int) endpoint2, bool isVertical){ //,bool isVertical
        this.manager = manager;
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
        drawn = false;

        colorIndex = 0;
        GetComponent<Renderer>().material.color = colors[colorIndex];

        spriteRenderer = gameObject.GetComponent<SpriteRenderer>();
        //render the vertical one of the sprite
        if(isVertical == true){
          transform.Rotate (Vector3.forward * -90);
        }
        // Debug.Log($"made line from {endpoint1} to {endpoint2}");
    }

    public void Fill(Color isPrimary){
        GetComponent<Renderer>().material.color = isPrimary;
        Debug.Log("filled!");
    }   

    void OnMouseDown(){
       
        GetComponent<Renderer>().material.color = isPrimaryLine;

        // TODO implement button to actually confirm
        confirmClick();
    }

    void confirmClick(){
        drawn = true;
        manager.checkForBoxAt(endpoint1, endpoint2);
    }

    public bool isDrawn(){
        return drawn;
    }

}
