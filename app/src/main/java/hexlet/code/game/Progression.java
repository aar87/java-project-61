package hexlet.code.game;

import hexlet.code.Cli;

public final class Progression implements BrainGame {
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_INIT_VALUE = 100;
    private static final int MIN_PROGRESSION_STEP = 1;
    private static final int MAX_PROGRESSION_STEP = 10;
    private static final int MIN_RANDOM_INDEX = 0;

    @Override
    public String getQuestion() {
        int length = GameUtils.randomValue(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int randomIndex = GameUtils.randomValue(length, MIN_RANDOM_INDEX);
        int currentValue = GameUtils.randomValue(MAX_INIT_VALUE);
        int step = GameUtils.randomValue(MAX_PROGRESSION_STEP, MIN_PROGRESSION_STEP);
        int answer = 0;

        StringBuilder question = new StringBuilder();

        for (int i = 0; i <= length; i++) {
            if (i == randomIndex) {
                question.append(".. ");
                answer = currentValue;
            } else {
                String valueToAdd = currentValue + " ";
                question.append(valueToAdd);
            }
            currentValue += step;
        }

        Cli.println("Question: " + question);

        return String.valueOf(answer);
    }
}
