package ru.netology.teamproject.qa.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.TeamProject.QA.domain.Game;
import ru.netology.TeamProject.QA.domain.GameStore;

public class GameStoreTest {

    GameStore gameStore1 = new GameStore();
    GameStore gameStore2 = new GameStore();
    Game Sims = new Game("SIMS", "simulator", gameStore1);
    Game Doom = new Game("Doom", "shooter", gameStore2);

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }
    @Test

    public void shouldContainGameInGameStore() {
        gameStore1.publishGame("SIMS", "simulator");
        gameStore2.publishGame("Doom", "shooter");

        boolean result = gameStore1.containsGame(Sims);

        Assertions.assertEquals(true, result);

        boolean result2 = gameStore1.containsGame(Doom);

        Assertions.assertEquals(false, result2);

    }

    @Test
    public void shouldSumPlayTimeAndChooseMostPlayer() {
        gameStore1.addPlayTime("Kostya92", 3);
        gameStore1.addPlayTime("Kostya92", 6);
        gameStore1.addPlayTime("Misha21", 7);

        String result = gameStore1.getMostPlayer();

        Assertions.assertEquals("Kostya92", result);

    }

    @Test

    public void shouldChooseMostPlayer() {
        gameStore1.addPlayTime("Kostya92", 79);
        gameStore1.addPlayTime("Gaga", 35);

        String result1 = gameStore1.getMostPlayer();

        Assertions.assertEquals("Kostya92", result1);

        String result2 = gameStore2.getMostPlayer();

        Assertions.assertEquals(null, result2);

        gameStore1.addPlayTime("Kostya92", 79);
        gameStore1.addPlayTime("Gaga", 79);

        String result3 = gameStore2.getMostPlayer();

        Assertions.assertEquals(null, result3);


    }


    @Test

    public void shouldSumAllPlayTime() {
        gameStore1.addPlayTime("Kostya92", 79);
        gameStore1.addPlayTime("Gaga", 35);

        int result = gameStore1.getSumPlayedTime();

        Assertions.assertEquals(114, result);
    }


}
