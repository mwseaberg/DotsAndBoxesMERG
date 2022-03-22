using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LineManager : MonoBehaviour
{
    [SerializeField] private int _width, _height;

    [SerializeField] private ClickableLine _linePrefab;
    [SerializeField] private FillableSquare _squarePrefab;
    [SerializeField] private StaticDot _dotPrefab;

    [SerializeField] private Transform _cam;

    //SHOULD I EVEN BE CONSIDERING THIS
    [SerializeField] private ClickableLine drawnCheck;

    private Dictionary<(Vector2,Vector2), ClickableLine> _lines;
    private Dictionary<Vector2, FillableSquare> _squares;

 //referencing p1 and p2 colors and holder var
    [SerializeField] private static Color colorP1 = Color.green;
    [SerializeField] private static Color colorP2 = Color.red;
    [SerializeField] private Color isPrimary = colorP1;
    [SerializeField] private int isPrimaryHelper = 1;


    //score vars for p1 and p2
    [SerializeField] private int scoreP1;
    [SerializeField] private int scoreP2;
    [SerializeField] private int isScoring;

    //constructor needed to avoid field initializer cannot reference a non-static field... error
    private void scoring(){
        isScoring = scoreP1;
    }


    void Start() {
        GenerateGrid();
    }

    void GenerateGrid() {
        _lines = new Dictionary<(Vector2,Vector2), ClickableLine>();
        _squares = new Dictionary<Vector2, FillableSquare>();
        int x, y;
        for ( x = 0; x < _width; x++) {
            for ( y = 0; y <= _height; y++) {
                // make horizontal lines
                var spawnedLineH = Instantiate(_linePrefab, new Vector3(x, y), Quaternion.identity);
                // not sure if these names ever get really used, we can remove if we don't use them later
                spawnedLineH.name = $"HLine from {x},{y} to {x+1},{y}";
                spawnedLineH.Init(this, (x,y), (x+1, y), false);
                _lines[(new Vector2(x,y), new Vector2(x+1, y))] = spawnedLineH;
            }
        }

            for ( x = 0; x <= _width; x++) {
                for ( y = 0; y < _height; y++) {
                    var spawnedLineV = Instantiate(_linePrefab, new Vector3(x, y+1), Quaternion.identity);
                    spawnedLineV.name = $"VLine from {x},{y} to {x},{y+1}";
                    spawnedLineV.Init(this, (x,y), (x, y+1), true);
                    _lines[(new Vector2(x,y), new Vector2(x, y+1))] = spawnedLineV;
                }
            }

                for ( x = 0; x < _width; x++) {
            for ( y = 0; y < _height; y++) {
                // make squares
                var spawnedSquare = Instantiate(_squarePrefab, new Vector3(2*x, 2*y), Quaternion.identity);
                spawnedSquare.name = $"Square from {x},{y}";
                spawnedSquare.Init((x,y));
                _squares[new Vector2(x,y)] = spawnedSquare;

                // make dots
                // var spawnedDot = Instantiate(_dotPrefab, new Vector3(2*x, 2*y), Quaternion.identity);
                // spawnedDot.name = $"Dot at {x},{y}";
                // spawnedDot.Init((x,y));
                // Debug.Log($"Dot");
                // not adding dot to dictionary because I don't think we need to access them

            }
        }

        // TODO note this will probably need adjustment
        _cam.transform.position = new Vector3((float)_width/2 -0.5f, (float)_height / 2 - 0.5f,-10);
    }


    public ClickableLine GetTileAtPosition((Vector2,Vector2) pos) {
        if (_lines.TryGetValue(pos, out var line)) return line;
        return null;
    }

    public void checkForBoxAt((int, int) endpoint1, (int, int) endpoint2){
        Debug.Log($"checking for box by {endpoint1}, {endpoint2}");
        int x1;
        int y1;
        (x1, y1) = endpoint1;
        int x2;
        int y2;
        (x2, y2) = endpoint2;

        // Debug.Log($"{x1}, {y1}, {x2}, {y2}");

        if(x1==x2){
            // vertical

            //case for line at far left
            if(x1==0){

                if(_lines[(new Vector2(x1,y1),new Vector2(x1+1,y1))].isDrawn() &&  _lines[(new Vector2(x2,y2),new Vector2(x2+1,y2))].isDrawn()
                 && _lines[(new Vector2(x1+1,y1),new Vector2(x2+1,y2))].isDrawn()){
                     //fill in square here
                    _squares[new Vector2(x1,y1)].Fill(isPrimary);
                }
            }

            //case for line at far right
            else if(x1==_width){
                if(_lines[(new Vector2(x1-1,y1),new Vector2(x1,y1))].isDrawn() &&  _lines[(new Vector2(x2-1,y2),new Vector2(x2,y2))].isDrawn()
                 && _lines[(new Vector2(x1-1,y1),new Vector2(x2-1,y2))].isDrawn()){
                     //fill in square here
                     _squares[new Vector2(x1-1,y1)].Fill(isPrimary);
                }
                //check three corresponding lines pushing left, fill in appropriate squares
            }
            //case for line in middle of the board
            //check six corresponding lines right and left, fill in appropriate squares
            else{

                //check left
                if(_lines[(new Vector2(x1-1,y1),new Vector2(x1,y1))].isDrawn() &&  _lines[(new Vector2(x2-1,y2),new Vector2(x2,y2))].isDrawn()
                 && _lines[(new Vector2(x1-1,y1),new Vector2(x2-1,y2))].isDrawn()){
                     //fill in square here
                     _squares[new Vector2(x1-1,y1)].Fill(isPrimary);
                }

                //check right
                 if(_lines[(new Vector2(x1,y1),new Vector2(x1+1,y1))].isDrawn() &&  _lines[(new Vector2(x2,y2),new Vector2(x2+1,y2))].isDrawn()
                 && _lines[(new Vector2(x1+1,y1),new Vector2(x2+1,y2))].isDrawn()){
                     //fill in square here
                    _squares[new Vector2(x1,y1)].Fill(isPrimary);
                }


            }

        } else if(y1==y2){
            // horizontal

            //case for line at bottom of board
            if(y1==0){
                //check three corresponding lines pushing up, fill in appropriate squares
                if(_lines[(new Vector2(x1,y1),new Vector2(x1,y1+1))].isDrawn() &&  _lines[(new Vector2(x2,y2),new Vector2(x2,y2+1))].isDrawn()
                 && _lines[(new Vector2(x1,y1+1),new Vector2(x2,y2+1))].isDrawn()){
                     //fill in square here
                     _squares[new Vector2(x1,y1)].Fill(isPrimary);
                }
            }
            //case for line at top of board
            else if(y1==_height){

                //check three corresponding lines pushing down, fill in appropriate squares
                if(_lines[(new Vector2(x1,y1-1),new Vector2(x1,y1))].isDrawn() &&  _lines[(new Vector2(x2,y2-1),new Vector2(x2,y2))].isDrawn()
                 && _lines[(new Vector2(x1,y1-1),new Vector2(x2,y2-1))].isDrawn()){
                     //fill in square here
                     _squares[new Vector2(x1,y1-1)].Fill(isPrimary);
                }

            }
            //case for line in middle of the board
            else{
                //check six corresponding lines up and down, fill in appropriate squares

                if(_lines[(new Vector2(x1,y1),new Vector2(x1,y1+1))].isDrawn() &&  _lines[(new Vector2(x2,y2),new Vector2(x2,y2+1))].isDrawn()
                 && _lines[(new Vector2(x1,y1+1),new Vector2(x2,y2+1))].isDrawn()){
                     //fill in square here
                     _squares[new Vector2(x1,y1)].Fill(isPrimary);
                }

                if(_lines[(new Vector2(x1,y1-1),new Vector2(x1,y1))].isDrawn() &&  _lines[(new Vector2(x2,y2-1),new Vector2(x2,y2))].isDrawn()
                 && _lines[(new Vector2(x1,y1-1),new Vector2(x2,y2-1))].isDrawn()){
                     //fill in square here
                     _squares[new Vector2(x1,y1-1)].Fill(isPrimary);
                }

            }

        } else {
            Debug.Log("ERROR this should not happen");
        }

        //switch case for isPrimary to swap between p1 and p2 colors/scoring variables for p1 and p2 
        switch(isPrimaryHelper){
            case 1:
                isPrimary = colorP2;
                isScoring = scoreP2;
                isPrimaryHelper=2;
                break;

            case 2:
                isPrimary = colorP1;
                isScoring = scoreP1;
                isPrimaryHelper=1;
                break;
        }

    }
}
