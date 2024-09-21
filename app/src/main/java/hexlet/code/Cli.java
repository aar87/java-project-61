package hexlet.code;
import java.util.Scanner;

public class Cli {
    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int getInt() {
        return Integer.parseInt(Cli.getString());
    }
}
