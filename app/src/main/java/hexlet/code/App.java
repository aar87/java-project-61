package hexlet.code;

import hexlet.code.game.Even;
import hexlet.code.game.Calc;
import hexlet.code.game.Gcd;
import hexlet.code.game.Progression;
import hexlet.code.game.Prime;

import java.util.Scanner;

public class App {
    public static final int GREET_CHOICE = 1;
    public static final int EVEN_CHOICE = 2;
    public static final int CALC_CHOICE = 3;
    public static final int GCD_CHOICE = 4;
    public static final int PROGRESSION_CHOICE = 5;
    public static final int PRIME_CHOICE = 6;

    public static String gameMenuText() {
        return """
        Please enter the game number and press Enter.
        1 - Greet
        2 - Even
        3 - Calc
        4 - Gcd
        5 - Progression
        6 - Prime
        0 - Exit""";
    }

    public static void main(String[] args) {
        System.out.println(gameMenuText());
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {
            case GREET_CHOICE -> Cli.greet();
            case EVEN_CHOICE -> Even.play();
            case CALC_CHOICE -> Calc.play();
            case GCD_CHOICE -> Gcd.play();
            case PROGRESSION_CHOICE -> Progression.play();
            case PRIME_CHOICE -> Prime.play();
            default -> { }
        }
    }
}
