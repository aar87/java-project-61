package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    private static final String GAME_INFO = "What is the result of the expression?'.";
    private static final int MAX_NUMBER = 10;

    public static void play() {
        var gameData = getGameData();
        Engine.process(gameData, GAME_INFO);
    }

    private static List<String[]> getGameData() {
        ArrayList<String[]> data = new ArrayList<>();

        for (int i = 0; i < Engine.GAME_ROUNDS; i++) {
            String[] round = new String[Engine.GAME_ROUNDS];
            int firstValue = Utils.randomValue(MAX_NUMBER);
            int secondValue = Utils.randomValue(MAX_NUMBER);
            String method = Utils.METHODS_ARRAY[Utils.randomValue(Utils.METHODS_ARRAY.length)];
            int result = Utils.calculate(firstValue, secondValue, method);

            round[Engine.QUESTION_INDEX] = firstValue + " " + method + " " + secondValue;
            round[Engine.ANSWER_INDEX] = String.valueOf(result);
            data.add(round);
        }

        return data;
    }
}
