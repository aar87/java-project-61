package hexlet.code.game;

import hexlet.code.Cli;

public final class Even implements Game {
    private static final String yes = "yes";
    private static final String no = "no";
    private static final int gameCode = 2;
    private static final int maxNumber = 1000;

    @Override
    public String name() {
        return "Even";
    }

    @Override
    public int code() {
        return gameCode;
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
        return (int) (Math.random() * maxNumber);
    }

    private String getQuestion() {
        int value = randomValue();

        Cli.println("Question: " + value);

        if (isEven(value)) {
            return yes;
        }
        return no;
    }

    private boolean askQuestion() {
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

    private boolean isEven(int value) {
        return value % 2 == 0;
    }
}
