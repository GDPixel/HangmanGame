package hangman.game;

public enum GameDifficulty {
    EASY(6, 2),
    MEDIUM(5, 1),
    HARD(4, 0);

    private final int initialHealth;
    private final int numberOfOpenLetters;

    GameDifficulty(int initialHealth, int numberOfOpenLetters) {
        this.initialHealth = initialHealth;
        this.numberOfOpenLetters = numberOfOpenLetters;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public int getNumberOfOpenLetters() {
        return numberOfOpenLetters;
    }
}

