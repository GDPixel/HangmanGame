package hangman.game;

import hangman.dialog.IntegerSelectDialog;
import hangman.models.WordSelector;
import hangman.models.puzzleword.PuzzleWord;
import hangman.models.puzzleword.ScrambledPuzzleWord;

import java.util.List;
import java.util.Set;

public class HangmanGame {
    private static final int NEW_REGULAR_GAME = 1;
    private static final int NEW_SCRAMBLE_GAME = 2;
    private static final int EXIT = 3;
    private static final String MENU_START_REGULAR_GAME = "Start the regular game (%d)%n".formatted(NEW_REGULAR_GAME);
    private static final String MENU_START_SCRAMBLE_GAME = "Start the scramble game (%d)%n".formatted(NEW_SCRAMBLE_GAME);
    private static final String MENU_EXIT_GAME = "Exit the game (%d)%n".formatted(EXIT);
    private static final String ENTER_YOUR_CHOICE = "Please enter your choice: ";
    private static final String WELCOME = "Welcome to Hangman Game!";
    private static final String WRONG_INPUT = "Wrong input. Enter " + NEW_REGULAR_GAME + " or " + EXIT;
    private static final String EXIT_GAME = "Exiting game...";

    private final WordSelector wordSelector;
    private final GameDifficulty gameDifficulty;

    public HangmanGame(List<String> words, GameDifficulty defaultGameDifficulty) {
        wordSelector = new WordSelector(words);
        this.gameDifficulty = defaultGameDifficulty;
    }

    public void start() {
        mainMenu();
    }

    private void newRegularGame() {
        String selectedWord = wordSelector.selectRandomWord();
        PuzzleWord puzzleWord = new PuzzleWord(selectedWord);
        Game game = new Game(puzzleWord, gameDifficulty);
        game.run();
        mainMenu();
    }

    private void newScrambleGame() {
        String selectedWord = wordSelector.selectRandomWord();
        PuzzleWord puzzleWord = new ScrambledPuzzleWord(selectedWord);
        Game game = new Game(puzzleWord, gameDifficulty);
        game.run();
        mainMenu();
    }

    private void mainMenu() {
        System.out.println(WELCOME);
        String border = "---------------------------";
        System.out.println(border);
        System.out.println("Game difficulty: " + gameDifficulty);
        String title = MENU_START_REGULAR_GAME + MENU_START_SCRAMBLE_GAME + MENU_EXIT_GAME + ENTER_YOUR_CHOICE;
        IntegerSelectDialog dialog = new IntegerSelectDialog(title, WRONG_INPUT,
                Set.of(NEW_REGULAR_GAME, NEW_SCRAMBLE_GAME, EXIT));
        int choice = dialog.input();
        if (choice == NEW_REGULAR_GAME) {
            newRegularGame();
        }
        if (choice == NEW_SCRAMBLE_GAME) {
            newScrambleGame();
        }
        if (choice == EXIT) {
            System.out.println(EXIT_GAME);
        }
    }
}
