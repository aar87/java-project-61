package hexlet.code.game;

public final class Game {
    private final String name;
    private final String rules;
    private final BrainGame brainGame;
    private final boolean withWelcome;
    private final boolean withPlay;

    public Game(String gameName, String gameRules, BrainGame bGame, boolean welcome, boolean play) {
        this.name = gameName;
        this.rules = gameRules;
        this.brainGame = bGame;
        this.withWelcome = welcome;
        this.withPlay = play;
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

    public boolean getWithWelcome() {
        return withWelcome;
    }

    public boolean getWithPlay() {
        return withPlay;
    }

    public String getQuestion() {
        return brainGame.getQuestion();
    }
}
