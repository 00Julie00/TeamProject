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

        public int play(Game game, int hours) {
            game.getStore().addPlayTime(name, hours);
            if (playedTime.containsKey(game)) {
                playedTime.put(game, playedTime.get(game));
            } else {
                playedTime.put(game, hours);
            }
            return playedTime.get(game);
        }

        public int sumGenre(String genre) {
            int sum = 0;
            for (Game game : playedTime.keySet()) {
                if (game.getGenre().equals(genre)) {
                    sum += playedTime.get(game);
                } else {
                    sum = 0;
                }
            }
            return sum;
        }

        public Game mostPlayerByGenre(String genre) {
            return null;
        }
}
