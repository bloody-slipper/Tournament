package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {


    Game game = new Game();

    Player player1 = new Player(1, "Petr", 8);
    Player player2 = new Player(2, "Maksim", 3);
    Player player3 = new Player(3, "Filip", 9);
    Player player4 = new Player(4, "Andrew", 0);
    Player player5 = new Player(6, "Pavel", 8);


    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void shouldStrengthEquals() {

        int expected = 0;
        int actual = game.round("Petr", "Pavel");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer1StrongerPlayer2() {

        int expected = 1;
        int actual = game.round("Petr", "Maksim");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer1WeakerPlayer2() {

        int expected = 2;
        int actual = game.round("Maksim", "Filip");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer2NotRegister() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Maksim", "Ilya");
        });
    }

    @Test
    public void shouldPlayer1NotRegister() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Ilya", "Andrew");
        });
    }
}
