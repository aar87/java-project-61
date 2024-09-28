package hexlet.code;

import hexlet.code.game.Game;
import hexlet.code.game.Even;
import hexlet.code.game.Calc;
import hexlet.code.game.Gcd;
import hexlet.code.game.Progression;
import hexlet.code.game.Prime;


public class App {
    private static final Game[] ACTIVE_GAMES = {
            new Game("Greet", "", null, true),
            new Game("Even", "Answer 'yes' if the number is even, otherwise answer 'no'.", new Even()),
            new Game("Calc", "What is the result of expression?'.", new Calc()),
            new Game("Gcd", "Find the greatest common divisor of given numbers.", new Gcd()),
            new Game("Progression", "What number is missing in this progression?", new Progression()),
            new Game("Prime", "Answer 'yes' if given number is prime. Otherwise answer 'no'.", new Prime()),
            new Game("Exit", "", null, false, false),
    };

    public static void main(String[] args) {
        Game game = selectGame();
        Engine gameEngine = new Engine(game);
        gameEngine.process();
    }

    public static Game selectGame() {
        Cli.println("Please enter the game number and press Enter.");

        for (int i = 0; i < ACTIVE_GAMES.length; i++) {
            Cli.println(i + 1 + " - " + ACTIVE_GAMES[i].getName());
        }

        Cli.print("Your choice: ");
        int gameIndex = Cli.getInt() - 1;
        Cli.println("");

        return ACTIVE_GAMES[gameIndex];
    }
}
