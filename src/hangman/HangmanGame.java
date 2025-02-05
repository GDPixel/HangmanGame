package hangman;

import hangman.dialog.EngLetterDialog;
import hangman.dialog.IntegerSelectDialog;

import java.util.List;
import java.util.Set;

public class HangmanGame {
    private static final int MAX_ERRORS = 6;
    private static final int NEW_GAME = 1;
    private static final int EXIT = 2;
    public static final String START_GAME = "Start the game (%d)%n".formatted(NEW_GAME);
    public static final String EXIT_GAME = "Exit the game (%d)%n".formatted(EXIT);
    public static final String ENTER_YOUR_CHOICE = "Please enter your choice: ";
    public static final String WELCOME = "Welcome to Hangman Game!";
    public static final String WRONG_INPUT = "Wrong input";

    private final HangmanPictures hangmanPictures;
    private final WordSelector wordSelector;
    private PuzzleWord puzzleWord;
    private UserLettersInput userLettersInput;

    public HangmanGame(List<String> words) {
        wordSelector = new WordSelector(words);
        hangmanPictures = new HangmanPictures();
    }

    public void start() {
        mainMenu();
    }

    private void newGame() {
        String guessWord = wordSelector.selectRandomWord();
        puzzleWord = new PuzzleWord(guessWord);
        userLettersInput = new UserLettersInput();
        System.out.println("Log: The guessed word is " + puzzleWord.getWord());
        run();
    }

    private void run() {
        int error = 0;
        while (error != MAX_ERRORS && !isWin()) {
            hangmanPictures.print(error);
            String title = "Word to guess is: " + puzzleWord.getMaskedWord()
                    + "\nEntered letters: " + userLettersInput.getLetters()
                    + "\nEnter your guess: ";
            EngLetterDialog dialog = new EngLetterDialog(title, WRONG_INPUT);
            char letter = dialog.input();
            while (userLettersInput.hasLetter(letter)) {
                System.out.println("You have already entered this letter.");
                letter = dialog.input();
            }
            userLettersInput.addLetter(letter);
            if (puzzleWord.hasLetter(letter)) {
                puzzleWord.openLetter(letter);
            } else {
                error++;
            }
        }
        printGameResult();
        mainMenu();
    }

    private void printGameResult() {
        if (isWin()) {
            System.out.println("Congratulation! You win!");
        } else {
            System.out.println("You lose!");
            System.out.println("The guessed word was " + puzzleWord.getWord());
            hangmanPictures.print(MAX_ERRORS);
        }

    }

    private void mainMenu() {
        System.out.println(WELCOME);
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

    private boolean isWin() {
        return puzzleWord.isSolved();
    }
}
