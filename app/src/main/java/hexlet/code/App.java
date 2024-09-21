package hexlet.code;

import hexlet.code.game.Even;
import hexlet.code.game.Exit;
import hexlet.code.game.Game;
import hexlet.code.game.Greet;

public class App {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Game[] currentActiveGames = {new Greet(), new Even(), new Exit()};
        Executor executor = new Executor(currentActiveGames);
        Game currentGame = executor.selectGame();

        currentGame.play();
    }
}
