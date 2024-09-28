package hexlet.code.game;

import hexlet.code.Cli;

public final class Prime implements BrainGame {
    private static final int MAX_NUMBER = 100;

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

    @Override
    public String getQuestion() {
        int value = GameUtils.randomValue(MAX_NUMBER);
        String answer;

        if (isPrime(value)) {
            answer = "yes";
        } else {
            answer = "no";
        }

        Cli.println("Question: " + value);
        return answer;
    }
}
