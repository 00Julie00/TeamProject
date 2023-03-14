package ru.netology.teamproject.qa.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.TeamProject.QA.domain.Game;
import ru.netology.TeamProject.QA.domain.GameStore;

public class GameStoreTest {

        @Test
        public void shouldAddGame() {

            GameStore store = new GameStore();
            Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

            assertTrue(store.containsGame(game));
        }
}
