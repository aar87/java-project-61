package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class Progression {
    private static final String GAME_INFO = "What number is missing in the progression?";

    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_INIT_VALUE = 100;
    private static final int MIN_PROGRESSION_STEP = 1;
    private static final int MAX_PROGRESSION_STEP = 10;
    private static final int MIN_RANDOM_INDEX = 0;

    public static void play() {
        var gameData = getGameData();
        Engine.process(gameData, GAME_INFO);
    }

    private static List<String[]> getGameData() {
        ArrayList<String[]> data = new ArrayList<>();

        for (int i = 0; i < Engine.GAME_ROUNDS; i++) {
            String[] round = new String[Engine.GAME_ROUNDS];
            int length = Utils.randomValue(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int randomIndex = Utils.randomValue(length, MIN_RANDOM_INDEX);
            int currentValue = Utils.randomValue(MAX_INIT_VALUE);
            int step = Utils.randomValue(MAX_PROGRESSION_STEP, MIN_PROGRESSION_STEP);
            String[] progression = progression(currentValue, step, length);
            round[Engine.ANSWER_INDEX] = String.valueOf(progression[randomIndex]);
            progression[randomIndex] = "..";
            round[Engine.QUESTION_INDEX] = String.join(" ", progression);
            data.add(round);
        }

        return data;
    }

    private static String[] progression(int start, int step, int length) {
        String[] result = new String[length];

        for (int i = 0; i <= length - 1; i++) {
            result[i] = String.valueOf(start);
            start += step;
        }

        return result;
    }
}
