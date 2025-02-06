package hangman;

import hangman.dialog.IntegerSelectDialog;

import java.util.List;
import java.util.Set;

public class HangmanGame {
    private static final int NEW_GAME = 1;
    private static final int EXIT = 2;
    private static final String START_GAME = "Start the game (%d)%n".formatted(NEW_GAME);
    private static final String EXIT_GAME = "Exit the game (%d)%n".formatted(EXIT);
    private static final String ENTER_YOUR_CHOICE = "Please enter your choice: ";
    private static final String WELCOME = "Welcome to Hangman Game!";
    private static final String WRONG_INPUT = "Wrong input. Enter " + NEW_GAME + " or " + EXIT;

    private final WordSelector wordSelector;

    public HangmanGame(List<String> words) {
        wordSelector = new WordSelector(words);
    }

    public void start() {
        mainMenu();
    }

    private void newGame() {
        String selectedWord = wordSelector.selectRandomWord();
        Game game = new Game(selectedWord);
        game.run();
        mainMenu();
    }

    private void mainMenu() {
        System.out.println(WELCOME);
        String border = "---------------------------";
        System.out.println(border);
        String title = START_GAME + EXIT_GAME + ENTER_YOUR_CHOICE;
        IntegerSelectDialog dialog = new IntegerSelectDialog(title, WRONG_INPUT, Set.of(NEW_GAME, EXIT));
        int choice = dialog.input();
        if (choice == NEW_GAME) {
            newGame();
        }
        if (choice == EXIT) {
            System.exit(0);
        }
    }
}
