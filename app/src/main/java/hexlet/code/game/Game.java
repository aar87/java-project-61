package hexlet.code.game;

public final class Game {
    private final String name;
    private final String rules;
    private final BrainGame brainGame;
    public final boolean withWelcome;
    public boolean withPlay;

    public Game(String name, String rules, BrainGame brainGame, boolean withWelcome, boolean withPlay) {
        this.name = name;
        this.rules = rules;
        this.brainGame = brainGame;
        this.withWelcome = withWelcome;
        this.withPlay = withPlay;
    }

    public Game(String name, String rules, BrainGame brainGame, boolean withWelcome) {
        this(name, rules, brainGame, withWelcome, false);
    }

    public Game(String name, String rules, BrainGame brainGame) {
        this(name, rules, brainGame, true, true);
    }


    public String getName() {
        return name;
    }

    public String getRules() {
        return rules;
    }

    public String getQuestion() {
        return brainGame.getQuestion();
    }
}
