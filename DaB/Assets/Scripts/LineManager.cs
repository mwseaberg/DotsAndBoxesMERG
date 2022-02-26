using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LineManager : MonoBehaviour
{
    [SerializeField] private int _width, _height;
 
    [SerializeField] private ClickableLine _linePrefab;
    [SerializeField] private FillableSquare _squarePrefab;
 
    [SerializeField] private Transform _cam;
 
    private Dictionary<(Vector2,Vector2), ClickableLine> _lines;
    private Dictionary<Vector2, FillableSquare> _squares;
 
    void Start() {
        GenerateGrid();
    }
 
    void GenerateGrid() {
        _lines = new Dictionary<(Vector2,Vector2), ClickableLine>();
        _squares = new Dictionary<Vector2, FillableSquare>();
        for (int x = 0; x < _width; x++) {
            for (int y = 0; y < _height; y++) {

                // make horizontal lines
                var spawnedLineH = Instantiate(_linePrefab, new Vector3(2*x, 2*y), Quaternion.identity);
                spawnedLineH.name = $"HLine from {x},{y} to {x+1},{y}";
                spawnedLineH.Init(this, (x,y), (x+1, y));
                _lines[(new Vector2(x,y), new Vector2(x+1, y))] = spawnedLineH;
                // make vertical lines (might need different prefab - vertical)
                var spawnedLineV = Instantiate(_linePrefab, new Vector3(2*x+1, 2*y+1), Quaternion.identity);
                spawnedLineV.name = $"HLine from {x},{y} to {x},{y+1}";
                spawnedLineV.Init(this, (x,y), (x, y+1));
                _lines[(new Vector2(x,y), new Vector2(x, y+1))] = spawnedLineV;

                // TODO make lines to close the upper right top/right sides

                // make squares
                var spawnedSquare = Instantiate(_squarePrefab, new Vector3(2*x, 2*y), Quaternion.identity);
                spawnedSquare.name = $"Square from {x},{y}";
                spawnedSquare.Init((x,y));
                _squares[new Vector2(x,y)] = spawnedSquare;

            }
        }
 
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
                //check three corresponding lines pushing right, fill in appropriate squares
                //more nested if statements checking if lines were already selected?
            }
            //case for line at far right
            else if(x1==_width){
                //check three corresponding lines pushing left, fill in appropriate squares
            }
            //case for line in middle of the board 
            else{
                //check six corresponding lines right and left, fill in appropriate squares 
            }

        } else if(y1==y2){
            // horizontal

            //case for line at bottom of board
            if(y1==0){
                //check three corresponding lines pushing up, fill in appropriate squares
                //more nested if statements checking if lines were already selected?
            }
            //case for line at top of board
            else if(y1==_height){
                //check three corresponding lines pushing down, fill in appropriate squares
            }
            //case for line in middle of the board 
            else{
                //check six corresponding lines up and down, fill in appropriate squares 
            }
        } else {
            Debug.Log("ERROR this should not happen");
        }

    }
}
