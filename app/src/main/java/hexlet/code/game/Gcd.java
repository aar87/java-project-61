package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class Gcd {
    private static final String GAME_INFO = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 1;

    public static void play() {
        var gameData = getGameData();
        Engine.process(gameData, GAME_INFO);
    }

    private static List<String[]> getGameData() {
        ArrayList<String[]> data = new ArrayList<>();

        for (int i = 0; i < Engine.GAME_ROUNDS; i++) {
            String[] round = new String[Engine.GAME_ROUNDS];
            int firstValue = Utils.randomValue(MAX_NUMBER, MIN_NUMBER);
            int secondValue = Utils.randomValue(MAX_NUMBER, MIN_NUMBER);
            int result = findGcd(firstValue, secondValue);

            round[Engine.QUESTION_INDEX] = firstValue + " " + secondValue;
            round[Engine.ANSWER_INDEX] = String.valueOf(result);
            data.add(round);
        }

        return data;
    }

    private static int findGcd(int a, int b) {
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
