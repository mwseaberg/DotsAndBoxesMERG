using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ScoreManager : MonoBehaviour
{
    //insatance allows us to reference addPoint method from GameManager
    public static ScoreManager instance;
    public Text P1ScoreText;
    public Text P2ScoreText;
    int P1Score = 0;
    int P2Score = 0;

    private void Awake(){
        instance=this;
    }
    
    // Start is called before the first frame update
    void Start()
    {
        P1ScoreText.text = P1Score.ToString();
        P2ScoreText.text = P2Score.ToString();

    }

    public void addPoint(int currentColorHelper){
        //add score to player 1
        if(currentColorHelper==1){
            P1Score+=1;
            P1ScoreText.text = P1Score.ToString();

        }
        //add score to player 2
        else if(currentColorHelper==2){
            P2Score+=1;
            P2ScoreText.text = P2Score.ToString();

        }
        //if currentColorHelper==3 then endgame reached and scores will be reset, NEEDS TO BE IMPLEMENTED
        //IN GAMEMANAGER
        else{
            P1Score=0;
            P2Score=0;
            P1ScoreText.text = P1Score.ToString();
            P2ScoreText.text = P2Score.ToString();
        }

    }
    // Update is called once per frame
    void Update()
    {
        
    }
}
