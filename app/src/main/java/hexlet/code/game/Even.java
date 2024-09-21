package hexlet.code.game;

import hexlet.code.Cli;

public final class Even implements Game {
    private static final String ANSWER_YES = "yes";
    private static final String ANSWER_NO = "no";
    private static final int GAME_CODE = 2;
    private static final int MAX_NUMBER = 1000;

    @Override
    public String name() {
        return "Even";
    }

    @Override
    public int code() {
        return GAME_CODE;
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
        return (int) (Math.random() * MAX_NUMBER);
    }

    private String getQuestion() {
        int value = randomValue();

        Cli.println("Question: " + value);

        if (isEven(value)) {
            return ANSWER_YES;
        }
        return ANSWER_NO;
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
