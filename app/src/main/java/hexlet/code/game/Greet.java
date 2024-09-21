package hexlet.code.game;

public final class Greet implements Game {
    private static final int gameCode = 1;

    @Override
    public String name() {
        return "Greet";
    }

    @Override
    public int code() {
        return gameCode;
    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    public void printRules() {

    }
}
