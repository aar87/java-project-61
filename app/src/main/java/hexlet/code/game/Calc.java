package hexlet.code.game;

import hexlet.code.Cli;

import java.util.Random;

public final class Calc implements BrainGame {
    private static final int MAX_NUMBER = 10;

    private final String sum = "+";
    private final String subtract = "-";
    private final String multiply = "*";

    private final String[] methodsArray = {sum, subtract, multiply};

    @Override
    public String getQuestion() {
        int methodIndex = new Random().nextInt(getMethodsArray().length);
        int leftOperand = GameUtils.randomValue(MAX_NUMBER);
        int rightOperand = GameUtils.randomValue(MAX_NUMBER);

        String answer = String.valueOf(calculate(leftOperand, rightOperand, getMethodsArray()[methodIndex]));

        Cli.println("Question: " + leftOperand + " " + getMethodsArray()[methodIndex] + " " + rightOperand);
        return answer;
    }

    private String[] getMethodsArray() {
        return this.methodsArray;
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
}
