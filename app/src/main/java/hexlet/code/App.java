package hexlet.code;

import hexlet.code.game.*;

public class App {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Game[] currentActiveGames = {new Greet(), new Even(), new Calc(), new Gcd(), new Progression(), new Exit()};
        Executor executor = new Executor(currentActiveGames);
        Game currentGame = executor.selectGame();
        Engine engine = new Engine(currentGame);

        engine.process();
    }
}
