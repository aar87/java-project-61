package hexlet.code.game;

public class Greet implements Game {

    @Override
    public String name() {
        return "Greet";
    }

    @Override
    public int code() {
        return 1;
    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    public void printRules() {}
}
