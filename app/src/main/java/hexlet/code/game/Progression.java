package hexlet.code.game;

import hexlet.code.Cli;

public final class Progression implements Game {
    final int minProgressionLength = 5;
    final int maxProgressionLength = 10;
    final int maxInitValue = 100;

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

    private boolean askQuestion() {
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

    private int getQuestion() {
        int length = randomValue(minProgressionLength, maxProgressionLength);
        int randomIndex = randomValue(minProgressionLength, length);
        int currentValue = randomValue(0, maxInitValue);
        int step = randomValue(0, maxProgressionLength);
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

    private int randomValue(int min, int max) {
        int value = (int) (Math.random() * max);
        return Math.max(value, min);
    }
}
