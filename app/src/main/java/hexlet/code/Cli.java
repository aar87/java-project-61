package hexlet.code;
import java.util.Scanner;

public class Cli {
    public static void greet() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");
    }
}
