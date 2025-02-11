package hangman;

import hangman.game.GameDifficulty;
import hangman.game.HangmanGame;

public class Main {
    public static void main(String[] args) {
        var game = new HangmanGame(GameDifficulty.MEDIUM);
        game.start();
    }
}