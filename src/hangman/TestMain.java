package hangman;

import hangman.game.GameDifficulty;
import hangman.game.HangmanGame;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("chair");
        words.add("glasses");

        HangmanGame game = new HangmanGame(words, GameDifficulty.EASY);
        game.start();
    }
}
