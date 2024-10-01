package hexlet.code;

import java.util.List;
import java.util.Scanner;

public class Engine {
    public static final int GAME_ROUNDS = 3;
    public static final int QUESTION_INDEX = 0;
    public static final int ANSWER_INDEX = 1;
    private static final Scanner TEXT_SCANNER = new Scanner(System.in);

    private static void welcome() {
        System.out.println("\nWelcome to the Brain Games!");
    }

    private static String getPlayerName() {
        System.out.print("May I have your name? ");
        String playerName = TEXT_SCANNER.next();
        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }

    public static void process(List<String[]> gameData, String gameRules) {
        welcome();
        String player = getPlayerName();
        System.out.println(gameRules);

        for (String[] currentRound: gameData) {
            System.out.println("Question: " + currentRound[QUESTION_INDEX]);
            String correctAnswer = currentRound[ANSWER_INDEX];
            System.out.print("Your answer: ");
            String playerAnswer = TEXT_SCANNER.next();

            if (playerAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println(
                    "'" + playerAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'"
                );
                return;
            }
        }

        System.out.println("Congratulations, " + player + "!");
    }
}
