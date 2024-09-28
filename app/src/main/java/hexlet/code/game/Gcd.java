package hexlet.code.game;

import hexlet.code.Cli;

public final class Gcd implements BrainGame {
    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;

    private int findGcd(int a, int b) {
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

    @Override
    public String getQuestion() {
        int leftOperand = GameUtils.randomValue(MAX_NUMBER, MIN_NUMBER);
        int rightOperand = GameUtils.randomValue(MAX_NUMBER, MIN_NUMBER);
        int answer = findGcd(leftOperand, rightOperand);
        Cli.println("Question: " + leftOperand + " " + rightOperand);
        return String.valueOf(answer);
    }
}
