package hexlet.code.game;

import hexlet.code.Cli;

public class Even implements Game {
    protected final String YES = "yes";
    protected final String NO = "no";

    @Override
    public String name() {
        return "Even";
    }

    @Override
    public int code() {
        return 2;
    }

    @Override
    public boolean play() {
        return askQuestion();
    }

    @Override
    public void printRules() {
        Cli.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
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
