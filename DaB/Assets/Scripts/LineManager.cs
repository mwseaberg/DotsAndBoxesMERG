using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LineManager : MonoBehaviour
{
    [SerializeField] private int _width, _height;
 
    [SerializeField] private ClickableLine _linePrefab;
 
    [SerializeField] private Transform _cam;
 
    private Dictionary<Vector2, ClickableLine> _lines;
 
    void Start() {
        GenerateGrid();
    }
 
    void GenerateGrid() {
        _lines = new Dictionary<Vector2, ClickableLine>();
        for (int x = 0; x < _width; x++) {
            for (int y = 0; y < _height; y++) {
                var spawnedLineH = Instantiate(_linePrefab, new Vector3(2*x, 2*y), Quaternion.identity);
                spawnedLineH.name = $"Horiz Line from {x} {y}";
                spawnedLineH.Init();
                // _lines[new Vector2(x, y)] = spawnedLine;

                // var spawnedLineV = Instantiate(_linePrefab, new Vector3(2*x, 2*y), Quaternion.identity);
                // spawnedLineV.name = $"Vert Line from {x} {y}";
                // spawnedLineV.Init(true);
 
            }
        }
 
        _cam.transform.position = new Vector3((float)_width/2 -0.5f, (float)_height / 2 - 0.5f,-10);
    }
 
    public ClickableLine GetTileAtPosition(Vector2 pos) {
        if (_lines.TryGetValue(pos, out var line)) return line;
        return null;
    }
}
