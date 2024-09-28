package hexlet.code.game;

import hexlet.code.Cli;

public final class Even implements BrainGame {
    private static final int MAX_NUMBER = 1000;

    private boolean isEven(int value) {
        return value % 2 == 0;
    }

    @Override
    public String getQuestion() {
        int value = GameUtils.randomValue(MAX_NUMBER);
        String answer = GameUtils.booleanToString(isEven(value));
        Cli.println("Question: " + value);
        return answer;
    }
}
