package hexlet.code.game;

import hexlet.code.Cli;

public class Prime implements Game {
    protected final String YES = "yes";

    @Override
    public String name() {
        return "Prime";
    }

    @Override
    public int code() {
        return 6;
    }

    @Override
    public boolean play() {
        return askQuestion();
    }

    @Override
    public void printRules() {
        Cli.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }


    public boolean askQuestion() {
        boolean correctAnswer = getQuestion();

        Cli.print("Your answer: ");

        String answer = Cli.getString();
        boolean answerValue = answer.equals(YES);

        if (correctAnswer == answerValue) {
            Cli.println("Correct!");
            return true;
        }

        Cli.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        return false;
    }

    public boolean getQuestion() {
        int value = randomValue();

        Cli.println("Question: " + value);

        return isPrime(value);
    }

    int randomValue() {
        int MAX_NUMBER = 100;
        return (int) (Math.random() * MAX_NUMBER);
    }

    boolean isPrime(int a) {
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
