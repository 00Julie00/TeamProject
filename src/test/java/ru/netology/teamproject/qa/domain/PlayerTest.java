package ru.netology.teamproject.qa.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.TeamProject.QA.domain.Game;
import ru.netology.TeamProject.QA.domain.GameStore;
import ru.netology.TeamProject.QA.domain.Player;

public class PlayerTest {

        @Test
        public void shouldSumGenreIfOneGame() {
            GameStore store = new GameStore();
            Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

            Player player = new Player("Petya");
            player.installGame(game);
            player.play(game, 3);

            int expected = 3;
            int actual = player.sumGenre(game.getGenre());
            assertEquals(expected, actual);
        }

    }
