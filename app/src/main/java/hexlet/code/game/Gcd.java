package hexlet.code.game;

import hexlet.code.Cli;

public class Gcd implements Game {
    @Override
    public String name() {
        return "GCD";
    }

    @Override
    public int code() {
        return 4;
    }

    @Override
    public boolean play() {
        return askQuestion();
    }

    @Override
    public void printRules() {
        Cli.println("Find the greatest common divisor of given numbers.");
    }

    public boolean askQuestion() {
        int correctAnswer = getQuestion();

        Cli.print("Your answer: ");

        String answer = Cli.getString();

        if (correctAnswer == Integer.parseInt(answer)) {
            Cli.println("Correct!");
            return true;
        }

        Cli.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        return false;
    }

    public int getQuestion() {
        int leftOperand = randomValue();
        int rightOperand = randomValue();

        Cli.println("Question: " + leftOperand + " " + rightOperand);

        return findGcd(leftOperand, rightOperand);
    }

    int randomValue() {
        int MAX_NUMBER = 100;
        return (int) (Math.random() * MAX_NUMBER);
    }

    int findGcd(int a, int b) {
        if (a == b) {
            return a;
        }

        int min = Math.min(a, b);

        while (min > 1) {
            if (a % min == 0 && b % min == 0) {
                break;
            }
            min--;
        }

        return min;
    }
}
