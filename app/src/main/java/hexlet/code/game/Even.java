package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;


public class Even {
    private static final String GAME_INFO = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER = 1000;

    public static void play() {
        var gameData = getGameData();
        Engine.process(gameData, GAME_INFO);
    }

    private static List<String[]> getGameData() {
        ArrayList<String[]> data = new ArrayList<>();

        for (int i = 0; i < Engine.GAME_ROUNDS; i++) {
            String[] round = new String[Engine.GAME_ROUNDS];
            int value = Utils.randomValue(MAX_NUMBER);
            boolean isValueEven = isEven(value);

            String answer = Utils.booleanToString(isValueEven);
            round[Engine.QUESTION_INDEX] = String.valueOf(value);
            round[Engine.ANSWER_INDEX] = answer;
            data.add(round);
        }

        return data;
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
