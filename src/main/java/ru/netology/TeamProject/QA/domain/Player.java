package ru.netology.TeamProject.QA.domain;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private Map<Game, Integer> playedTime = new HashMap<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void installGame(Game game) {
        playedTime.put(game, 0);
    }

    public int play(Game game, int hours) throws RuntimeException {
        if (!playedTime.containsKey(game)) {
            throw new RuntimeException
                    ("The game " + game.getTitle() + " is not installed by player " + this.name);
        }
        playedTime.put(game, playedTime.get(game) + hours);
        game.getStore().addPlayTime(name, hours);
        return playedTime.get(game);
        }

    public int sumGenre(String genre) {
        int sum = 0;
        for (Game game : playedTime.keySet()) {
            if (game.getGenre().equals(genre)) {
                sum += playedTime.get(game);
            } // убрала else чтобы счетчик не обнулялся
        }
        return sum;
    }

    public Game mostPlayerByGenre(String genre) {
        int mostTime = 0;
        Game mostGenre = null;
        for (Game game : playedTime.keySet()) {
            if (game.getGenre().equals(genre)) {
                int gameTime = playedTime.get(game);
                if (gameTime > mostTime) {
                    mostTime = gameTime;
                    mostGenre = game;
                }
            }
        }
        return mostGenre;
    }

}
