package hexlet.code.game;

import hexlet.code.Cli;

import java.util.Random;

public final class Calc implements Game {
    private static final int gameCode = 3;
    private static final int maxNumber = 10;

    private final String sum = "+";
    private final String subtract = "-";
    private final String multiply = "*";

    public String[] methodsArray = {sum, subtract, multiply};

    @Override
    public String name() {
        return "Calc";
    }

    @Override
    public int code() {
        return gameCode;
    }

    @Override
    public boolean play() {
        return askQuestion();
    }

    @Override
    public void printRules() {
        Cli.println("What is the result of the expression?");
    }

    private int sum(Integer a, Integer b) {
        return a + b;
    }

    private int multiply(Integer a, Integer b) {
        return a * b;
    }

    private int subtract(Integer a, Integer b) {
        return a - b;
    }

    private int calculate(int a, int b, String method) {
        switch (method) {
            case sum -> {
                return sum(a, b);
            }
            case subtract -> {
                return subtract(a, b);
            }
            case multiply -> {
                return multiply(a, b);
            }
            default -> {
                return 0;
            }
        }
    }

    private int getQuestion() {
        int methodIndex = new Random().nextInt(methodsArray.length);
        int leftOperand = randomValue();
        int rightOperand = randomValue();

        Cli.println("Question: " + leftOperand + " " + methodsArray[methodIndex] + " " + rightOperand);

        return calculate(leftOperand, rightOperand, methodsArray[methodIndex]);
    }

    private boolean askQuestion() {
        int correctAnswer = getQuestion();

        Cli.print("Your answer: ");
        String answer = Cli.getString();

        if (Integer.parseInt(answer) == correctAnswer) {
            Cli.println("Correct!");
            return true;
        }

        Cli.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        return false;
    }

    private int randomValue() {
        return (int) (Math.random() * maxNumber);
    }
}
