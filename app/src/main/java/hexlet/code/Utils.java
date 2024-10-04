package hexlet.code;

public class Utils {
    private static final String ANSWER_YES = "yes";
    private static final String ANSWER_NO = "no";

    public static int randomValue(int max, int min) {
        int value = (int) (Math.random() * max);
        return Math.max(value, min);
    }

    public static int randomValue(int max) {
        return randomValue(max, 0);
    }

    public static String booleanToString(boolean b) {
        return b ? ANSWER_YES : ANSWER_NO;
    }
}
