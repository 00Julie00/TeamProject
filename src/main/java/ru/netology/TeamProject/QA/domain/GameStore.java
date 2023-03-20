package ru.netology.TeamProject.QA.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameStore {

    private List<Game> games = new ArrayList<>();
    private Map<String, Integer> playedTime = new HashMap<>();

    public Game publishGame(String title, String genre) {
        Game game = new Game(title, genre, this);
        games.add(game);
        return game;
    }

    public boolean containsGame(Game game) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).equals(game)) {
                return true;
            }
        }
        return false;
    }

    public void addPlayTime(String playerName, int hours) {
        if (playedTime.containsKey(playerName)) {
            playedTime.put(playerName, playedTime.get(playerName) + hours);
        } else {
            playedTime.put(playerName, hours);
        }
    }

    public String getMostPlayer() {
        int mostTime = 0;
        String bestPlayer = null;
        for (String playerName : playedTime.keySet()) {
            int playerTime = playedTime.get(playerName);
            if (playerTime > mostTime) {
                mostTime = playerTime;
                bestPlayer = playerName;
            }
        }
        return bestPlayer;
    }

    public int getSumPlayedTime() {
        int sum = 0;
        for (int value : playedTime.values()) {
            sum += value;
        }

        return sum;
    }
}