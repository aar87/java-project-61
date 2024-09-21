package hexlet.code.game;

import hexlet.code.Cli;

import java.util.Random;

public class Calc implements Game {
    protected final int CODE = 3;

    private final String SUM = "+";
    private final String SUBTRACT = "-";
    private final String MULTIPLY = "*";

    protected String[] MethodsArray = {SUM, SUBTRACT, MULTIPLY};

    @Override
    public String name() {
        return "Calc";
    }

    @Override
    public int code() {
        return CODE;
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
            case SUM -> {
                return sum(a, b);
            }
            case SUBTRACT -> {
                return subtract(a, b);
            }
            case MULTIPLY -> {
                return multiply(a, b);
            }
        }
        return 0;
    }

    public int getQuestion() {
        int methodIndex = new Random().nextInt(MethodsArray.length);
        int leftOperand = randomValue();
        int rightOperand = randomValue();

        Cli.println("Question: " + leftOperand + " " + MethodsArray[methodIndex] + " " + rightOperand);

        return calculate(leftOperand, rightOperand, MethodsArray[methodIndex]);
    }

    public boolean askQuestion() {
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

    int randomValue() {
        int MAX_NUMBER = 10;
        return (int) (Math.random() * MAX_NUMBER);
    }
}
