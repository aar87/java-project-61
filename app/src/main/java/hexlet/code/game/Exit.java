package hexlet.code.game;

public class Exit implements Game {

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    public void printRules() {}
}
