package ru.netology.teamproject.qa.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.TeamProject.QA.domain.Game;
import ru.netology.TeamProject.QA.domain.GameStore;
import ru.netology.TeamProject.QA.domain.Player;

public class PlayerTest {

    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    private Game one = store.publishGame("Half-Life", "Приключения");
    private Game two = store.publishGame("Mortal Kombat", "Аркады");
    private Game three = store.publishGame("Witcher", "РПГ");
    private Game four = store.publishGame("Civilization", "Стратегия");
    private Game five = store.publishGame("Heart of Darkness", "Аркады");
    private Game six = store.publishGame("Forza Horizon", "Гонки");

    @Test
    public void shouldSumGenreIfOneGame() {

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 6);

        int expected = 6;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreTwoGames() {

        Player player = new Player("Misha");
        player.installGame(game);
        player.installGame(one);
        player.installGame(two);
        player.play(game, 3);
        player.play(one, 1);
        player.play(two, 4);

        int expected = 7;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void shouldSumGenreIfGameReplay() {
        Player player = new Player("Oleg");
        player.installGame(one);
        player.installGame(six);
        player.installGame(four);

        player.play(four, 5);
        player.play(four, 4);

        int expected = 9;
        int actual = player.sumGenre("Стратегия");
        assertEquals(expected, actual);
    }

    @Test
    public void ReturnsMostPlayedGameOfGenre() {

        Player player = new Player("Petya");
        Player player1 = new Player("Kostya");
        player.installGame(two);
        player.installGame(four);
        player.installGame(five);
        player.play(two, 5);
        player.play(four, 3);
        player.play(five, 1);

        Game expected = two;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void MostPlayerByGenreNoInstall() {

        Player player = new Player("Denis");
        player.installGame(game);
        player.installGame(three);
        player.play(game, 3);
        player.play(three, 2);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("РПГ");
        assertEquals (expected, actual);
    }

    @Test
    void addNameOfPlayer() {
        Player player = new Player("Gena");
        String expected = "Gena";
        assertEquals(expected, player.getName());

    }

    @Test
    void exceptionIfGameNotInstall(){
        Player player = new Player("Gena");

        assertThrows(RuntimeException.class, () ->{
        player.play(two, 4);
        });
    }

}
