package hexlet.code;

public class Utils {
    private static final String ANSWER_YES = "yes";
    private static final String ANSWER_NO = "no";

    private static final String SUM_METHOD = "+";
    private static final String SUBTRACT_METHOD = "-";
    private static final String MULTIPLY_METHOD = "*";

    public static final String[] METHODS_ARRAY = {SUM_METHOD, SUBTRACT_METHOD, MULTIPLY_METHOD};

    public static int randomValue(int max, int min) {
        int value = (int) (Math.random() * max);
        return Math.max(value, min);
    }

    public static int randomValue(int max) {
        return randomValue(max, 0);
    }

    public static boolean isPrime(int a) {
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

    public static int[] progression(int start, int step, int length) {
        int[] result = new int[length];

        for (int i = 0; i <= length - 1; i++) {
            result[i] = start;
            start += step;
        }

        return result;
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
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

    public static String booleanToString(boolean b) {
        return b ? ANSWER_YES : ANSWER_NO;
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
