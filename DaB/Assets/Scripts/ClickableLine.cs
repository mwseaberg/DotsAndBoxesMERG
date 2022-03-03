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
          ChangeSprite(newSprite);
        }



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

    public bool isDrawn(){
        return drawn;
    }

}
