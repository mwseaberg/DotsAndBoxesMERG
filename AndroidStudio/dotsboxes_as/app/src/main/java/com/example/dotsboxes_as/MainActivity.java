package com.example.dotsboxes_as;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dotsboxes_as.ai.RandomAIPlayer;
import com.example.dotsboxes_as.model.Player;
import com.example.dotsboxes_as.view.GameView;
import com.example.dotsboxes_as.view.PlayersStateView;
import com.example.dotsboxes_as.model.HumanPlayer;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements PlayersStateView {

    protected GameView gameView;
    protected TextView player1name, player2name, player1state, player2state, player1occupying,
            player2occupying;
    ImageView currentPlayerPointer;
    Player[] players;
    Integer[] playersOccupying = new Integer[]{0, 0};
    Player currentPlayer;

    SharedInformation information = new SharedInformation();
    int p1Index;
    int p2Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup for getting player icons/colors
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            p1Index = extras.getInt("P1_ICON_COLOR_PICK");
            p2Index = extras.getInt("P2_ICON_COLOR_PICK");
        }

        gameView = (GameView) findViewById(R.id.gameView);
        gameView.setPlayersState(this);

        gameView.setColors(p1Index, p2Index);

        player1name = (TextView) findViewById(R.id.player1name);
        player2name = (TextView) findViewById(R.id.player2name);
        player1state = (TextView) findViewById(R.id.player1state);
        player2state = (TextView) findViewById(R.id.player2state);
        player1occupying = (TextView) findViewById(R.id.player1occupying);
        player2occupying = (TextView) findViewById(R.id.player2occupying);
        currentPlayerPointer = (ImageView) findViewById(R.id.playerNowPointer);

        players = new Player[]{new HumanPlayer("Player 1"), new HumanPlayer("Player 2")};
        startGame(players);
    }

    private void startGame(Player[] players) {
        gameView.startGame(players);
        setCurrentPlayer(players[0]);
//        updateState();
    }

    public void updateState() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (currentPlayer == players[0]) {
                   // player1state.setText("Thinking");
                   // player2state.setText("Waiting");
//                    currentPlayerPointer.setImageResource(R.drawable.a1);
                    currentPlayerPointer.setImageResource(information.getAddress(p1Index));
                } else if (currentPlayer == players[1]) {
                   // player2state.setText("Thinking");
                   // player1state.setText("Waiting");
//                    currentPlayerPointer.setImageResource(R.drawable.a2);
                    currentPlayerPointer.setImageResource(information.getAddress(p2Index));
                }
                player1occupying.setText("Score " + playersOccupying[0]);
                player2occupying.setText("Score " + playersOccupying[1]);
            }
        });
    }

    @Override
    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
        updateState();
    }

    @Override
    public void setPlayerOccupyingBoxesCount(Map<Player, Integer> player_occupyingBoxesCount_map) {
        playersOccupying[0] = (player_occupyingBoxesCount_map.get(players[0]));
        playersOccupying[1] = (player_occupyingBoxesCount_map.get(players[1]));
        updateState();
    }

    @Override
    public void setWinner(final Player winner) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Dots And Boxes")
                        .setMessage(winner.getName() + " Wins!")
                        .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                recreate();
                            }
                        })
                        .setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_new) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Dots & Boxes")
                            .setMessage("New game?")
                            .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //nothing
                                }
                            })
                            .setNeutralButton("New Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    players = new Player[]{new HumanPlayer("Player 1"), new HumanPlayer("Player 2")};
                                    startGame(players);

                                    player1name.setText("PLAYER 1");
                                    player2name.setText("PLAYER 2");
                                }
                            }).show();
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }
}
