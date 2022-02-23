using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ClickableLine : MonoBehaviour
{

    Color[] colors = new Color[] {Color.white, Color.red, Color.green, Color.blue};
    int colorIndex;

    // Start is called before the first frame update
    void Start()
    {
        colorIndex = 0;
        GetComponent<Renderer>().material.color = colors[colorIndex];
        Debug.Log("start! --------");
    }

    // Update is called once per frame
    void Update()
    {
        // if(Input.GetMouseButtonDown(0)) {
        //     Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
        //     RaycastHit hit;
        //     // Physics.Raycast(ray, out hit, 100);
        //     // Debug.Log("This hit at " + hit.point);
        //      if (Physics.Raycast(ray, out hit, 100))
        //      {
        //         colorIndex = 1;
        //         GetComponent<Renderer>().material.color = colors[colorIndex];
        //         Debug.Log("clicked!");
        //      } else {
        //          Debug.Log("clicked elsewhere");
        //      }
        // }
    }

    void OnMouseDown(){
        colorIndex = 1;
        GetComponent<Renderer>().material.color = colors[colorIndex];
        Debug.Log("clicked!");
    }   

}
