package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    private static final String GAME_INFO = "What is the result of the expression?'.";
    private static final int MAX_NUMBER = 10;

    private static final String SUM_METHOD = "+";
    private static final String SUBTRACT_METHOD = "-";
    private static final String MULTIPLY_METHOD = "*";

    public static final String[] METHODS_ARRAY = {SUM_METHOD, SUBTRACT_METHOD, MULTIPLY_METHOD};

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
            String method = METHODS_ARRAY[Utils.randomValue(METHODS_ARRAY.length)];
            int result = calculate(firstValue, secondValue, method);

            round[Engine.QUESTION_INDEX] = firstValue + " " + method + " " + secondValue;
            round[Engine.ANSWER_INDEX] = String.valueOf(result);
            data.add(round);
        }

        return data;
    }

    public static int calculate(int a, int b, String method) {
        switch (method) {
            case SUM_METHOD -> {
                return sum(a, b);
            }
            case SUBTRACT_METHOD -> {
                return subtract(a, b);
            }
            case MULTIPLY_METHOD -> {
                return multiply(a, b);
            }
            default -> {
                return 0;
            }
        }
    }

    private static int sum(Integer a, Integer b) {
        return a + b;
    }

    private static int multiply(Integer a, Integer b) {
        return a * b;
    }

    private static int subtract(Integer a, Integer b) {
        return a - b;
    }
}
