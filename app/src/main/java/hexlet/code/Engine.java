package hexlet.code;

import hexlet.code.game.Game;

public class Engine {
    private final Game game;
    private String player;

    Engine(Game g) {
        this.game = g;
        this.player = "";
    }

    protected void process() {
        if (game.withWelcome) {
            welcome();
        }
        if (game.withPlay) {
            play();
        }
    }

    protected void play() {
        printRules();
        gameLoop();
    }

    private void welcome() {
        Cli.println("Welcome to the Brain Games!");
        Cli.print("May I have your name? ");
        String playerName = Cli.getString();
        Cli.println("Hello, " + playerName + "!");
        this.player = playerName;
    }

    private void printRules() {
        Cli.println(game.getRules());
    }

    private void gameLoop() {
        int currentRound = 0;
        while (currentRound < 3) {
            String answer = game.getQuestion();
            Cli.print("Your answer: ");
            String playerAnswer = Cli.getString();
            if (!playerAnswer.equals(answer)) {
                Cli.println("Let's try again, " + player + "!");
                return;
            }
            currentRound++;
        }

        Cli.println("Congratulations, " + player + "!");
    }
}
