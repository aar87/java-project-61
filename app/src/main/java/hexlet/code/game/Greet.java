package hexlet.code.game;

import hexlet.code.Cli;

public class Greet implements Game {
    public String name() {
        return "Greet";
    }

    public int code() {
        return 1;
    }

    public void play() {
        Cli.println("Welcome to Brain Games!");
        Cli.print("May I have your name? ");
        String name = Cli.getString();
        Cli.println("Hello, " + name + "!");
    }
}
