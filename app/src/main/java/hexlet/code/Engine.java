package hexlet.code;

import hexlet.code.game.Exit;
import hexlet.code.game.Game;
import hexlet.code.game.Greet;

public class Engine {
    private String player;

    public Game game;

    public Engine(Game gameProvided) {
        this.game = gameProvided;
    }

    static String welcome() {
        Cli.println("Welcome to Brain Games!");
        Cli.print("May I have your name? ");
        String playerName = Cli.getString();
        Cli.println("Hello, " + playerName + "!");
        return playerName;
    }

    public void win() {
        Cli.println("Congratulations, " + player + "!");
    }
    public void loose() {
        Cli.println("Let's try again, " + player + "!");
    }

    public void process() {
        // Выглядит неправильно, но укладывается в процессинг
        if (this.game.code() == new Exit().code()) {
            return;
        }

        this.player = welcome();

        // Выглядит неправильно, но укладывается в процессинг
        if (this.game.code() == new Greet().code()) {
            return;
        }

        gameLoop();
    }

    public void gameLoop() {
        int correct = 0;
        int rounds = 3;

        this.game.printRules();

        while (correct < rounds) {
            if (!this.game.play()) {
                break;
            }
            correct++;
        }

        if (correct == rounds) {
            win();
            return;
        }

        loose();
    }
}
