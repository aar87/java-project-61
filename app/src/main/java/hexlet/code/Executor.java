package hexlet.code;

import hexlet.code.game.Game;

public class Executor {
    public Game[] games;
    public Executor(Game[] gamesProvided) {
        this.games = gamesProvided;
    }

    private void gamesInfo() {
        for (Game g : games) {
            Cli.println(g.code() + " - " + g.name());
        }
    }

    protected Game selectGame() {
        Cli.println("Please enter the game number and press Enter.");
        gamesInfo();
        Cli.print("Your choice: ");
        int gameIndex = Cli.getInt();
        Cli.println("");

        for (Game g : games) {
            if (g.code() == gameIndex) {
                return g;
            }
        }

        throw new RuntimeException("Unsupported game selected");
    }
}
