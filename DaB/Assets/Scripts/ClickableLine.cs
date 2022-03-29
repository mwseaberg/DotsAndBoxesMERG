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

    GameManager manager;

    Color uncolored = Color.white;

    public void Init(GameManager manager, (int, int) endpoint1, (int, int) endpoint2, bool isVertical){ //,bool isVertical
        this.manager = manager;
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
        drawn = false;

        GetComponent<Renderer>().material.color = uncolored;

        spriteRenderer = gameObject.GetComponent<SpriteRenderer>();
        //render the vertical one of the sprite
        if(isVertical == true){
          transform.Rotate (Vector3.forward * -90);
        }
        // Debug.Log($"made line from {endpoint1} to {endpoint2}");
    }

    public void Fill(Color color){
        GetComponent<Renderer>().material.color = color;
    }

    public void Unfill(){
        GetComponent<Renderer>().material.color = uncolored;
    }

    void OnMouseDown(){
        // conditional check - so if the line is already drawn, it doesn't get "drawn over" again
        if(!drawn){
            // show button
            // through manager - for all lines, if not "drawn", back to uncolored
            manager.promptEndTurn(this);

            // after uncoloring prev line, color this one (temporarily until confirmed)
            Fill(manager.getCurrentPlayerColor());
        }
    }

    // accessor methods
    public bool isDrawn(){
        return drawn;
    }

    public (int, int) getEndpoint1(){
        return endpoint1;
    }

    public (int, int) getEndpoint2(){
        return endpoint2;
    }

    // mutator methods

    // note: drawn should never be set to false after it has been set to true.
    public void setDrawn(){
        drawn = true;
    }

}
