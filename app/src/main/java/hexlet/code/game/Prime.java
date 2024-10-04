package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    private static final String GAME_INFO = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_NUMBER = 100;

    public static void play() {
        var gameData = getGameData();
        Engine.process(gameData, GAME_INFO);
    }

    private static List<String[]> getGameData() {
        ArrayList<String[]> data = new ArrayList<>();

        for (int i = 0; i < Engine.GAME_ROUNDS; i++) {
            String[] round = new String[Engine.GAME_ROUNDS];
            int value = Utils.randomValue(MAX_NUMBER);
            boolean result = isPrime(value);
            String answer = Utils.booleanToString(result);

            round[Engine.QUESTION_INDEX] = String.valueOf(value);
            round[Engine.ANSWER_INDEX] = answer;
            data.add(round);
        }

        return data;
    }

    private static boolean isPrime(int a) {
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
}
