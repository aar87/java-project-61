package hexlet.code;

import hexlet.code.game.Game;
import hexlet.code.game.Greet;
import hexlet.code.game.Even;
import hexlet.code.game.Calc;
import hexlet.code.game.Gcd;
import hexlet.code.game.Progression;
import hexlet.code.game.Prime;
import hexlet.code.game.Exit;

public class App {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Game[] currentActiveGames = {
            new Greet(), new Even(), new Calc(), new Gcd(), new Progression(), new Prime(), new Exit()
        };
        Executor executor = new Executor(currentActiveGames);
        Game currentGame = executor.selectGame();
        Engine engine = new Engine(currentGame);

        engine.process();
    }
}
