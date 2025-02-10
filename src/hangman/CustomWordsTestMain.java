package hangman;

import hangman.game.GameDifficulty;
import hangman.game.HangmanGame;

import java.util.ArrayList;
import java.util.List;

public class CustomWordsTestMain {
    public static void main(String[] args) {
        List<String> customWords = new ArrayList<>();
        customWords.add("chair");
        customWords.add("glasses");

        HangmanGame game = new HangmanGame(customWords, GameDifficulty.EASY);
        game.start();
    }
}
