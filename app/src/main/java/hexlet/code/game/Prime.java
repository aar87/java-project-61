package hexlet.code.game;

import hexlet.code.Cli;

public final class Prime implements Game {
    private static final String yes = "yes";
    private static final int gameCode = 6;
    private static final int maxNumber = 100;

    @Override
    public String name() {
        return "Prime";
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
        Cli.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    private boolean askQuestion() {
        boolean correctAnswer = getQuestion();

        Cli.print("Your answer: ");

        String answer = Cli.getString();
        boolean answerValue = answer.equals(yes);

        if (correctAnswer == answerValue) {
            Cli.println("Correct!");
            return true;
        }

        Cli.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        return false;
    }

    private boolean getQuestion() {
        int value = randomValue();

        Cli.println("Question: " + value);

        return isPrime(value);
    }

    private int randomValue() {
        return (int) (Math.random() * maxNumber);
    }

    private boolean isPrime(int a) {
        if (a == 1) {
            return false;
        }

        if (a == 2) {
            return true;
        }

        boolean result = true;
        int current = 2;

        while (current < a) {
            if (a % current == 0) {
                result = false;
                break;
            }
            current += 1;
        }

        return result;
    }
}
