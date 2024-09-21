package hexlet.code.game;

import hexlet.code.Cli;

public class Progression implements Game {
    final int MIN_PROGRESSION_LENGTH = 5;
    final int MAX_PROGRESSION_LENGTH = 10;
    final int MAX_INIT_VALUE = 100;

    @Override
    public String name() {
        return "Progression";
    }

    @Override
    public int code() {
        return 5;
    }

    @Override
    public boolean play() {
        return askQuestion();
    }

    @Override
    public void printRules() {
        Cli.println("What number is missing in the progression?");
    }

    public boolean askQuestion() {
        int correctAnswer = getQuestion();

        Cli.print("Your answer: ");

        String answer = Cli.getString();

        if (correctAnswer == Integer.parseInt(answer)) {
            Cli.println("Correct!");
            return true;
        }

        Cli.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        return false;
    }

    public int getQuestion() {
        int length = randomValue(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int randomIndex = randomValue(MIN_PROGRESSION_LENGTH, length);
        int currentValue = randomValue(0, MAX_INIT_VALUE);
        int step = randomValue(0, MAX_PROGRESSION_LENGTH);
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

        return answer;
    }

    int randomValue(int min, int max) {
        int value = (int) (Math.random() * max);
        return Math.max(value, min);
    }
}
