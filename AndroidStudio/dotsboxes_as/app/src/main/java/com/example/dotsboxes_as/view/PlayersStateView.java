package com.example.dotsboxes_as.view;

import com.example.dotsboxes_as.model.Player;

import java.util.Map;

public interface PlayersStateView {
    void setCurrentPlayer(Player player);

    void setPlayerOccupyingBoxesCount(Map<Player, Integer> player_occupyingBoxesCount_map);

    void setWinner(Player winner);
}
