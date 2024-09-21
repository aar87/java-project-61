package hexlet.code.game;

import hexlet.code.Cli;

public class Even implements Game {
    protected String playerName;

    protected final String YES = "yes";
    protected final String NO = "no";
    protected final int ROUNDS = 3;

    public String name() {
        return "Even";
    }

    public int code() {
        return 2;
    }

    public void play() {
        welcome();
        gameLoop();
    }

    public void welcome() {
        Cli.println("Welcome to Brain Games!");
        Cli.print("May I have your name? ");
        playerName = Cli.getString();
        Cli.println("Hello, " + playerName + "!");
    }

    public void gameLoop() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correct = 0;

        while (correct < ROUNDS) {
            if (!askQuestion()) {
                break;
            }
            correct++;
        }

        if (correct == ROUNDS) {
            win();
            return;
        }

        loose();
    }

    private void win() {
        Cli.println("Congratulations, " + playerName + "!");
    }

    private void loose() {
        Cli.println("Let's try again, " + playerName + "!");
    }

    int randomValue() {
        int MAX_NUMBER = 1000;
        return (int) (Math.random() * MAX_NUMBER);
    }

    public String getQuestion() {
        int value = randomValue();

        Cli.println("Question: " + value);

        if (isEven(value)) {
            return YES;
        }
        return NO;
    }

    public boolean askQuestion() {
        String correctAnswer = getQuestion();

        Cli.print("Your answer: ");

        String answer = Cli.getString();

        if (answer.equals(correctAnswer)) {
            Cli.println("Correct!");
            return true;
        }

        Cli.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        return false;
    }

    public boolean isEven(int value) {
        return value % 2 == 0;
    }
}
