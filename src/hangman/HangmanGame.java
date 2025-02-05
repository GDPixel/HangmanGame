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

    public HangmanGame(List<String> words) {
        wordSelector = new WordSelector(words);
        hangmanPictures = new HangmanPictures();
    }

    public void start() {
        mainMenu();
    }

    private void run() {
        String guessWord = wordSelector.selectWord();
        PuzzleWord puzzleWord = new PuzzleWord(guessWord);
        UserLettersInput userLettersInput = new UserLettersInput();
        System.out.println("Log: The guessed word is " + guessWord);
        int error = 0;
        while (error != MAX_ERRORS && !puzzleWord.isSolved()) {
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

        if (puzzleWord.isSolved()) {
            System.out.println("You win!");
            System.out.println("The guessed word is " + guessWord);
        } else {
            System.out.println("You lost!");
            hangmanPictures.print(MAX_ERRORS);
        }

        mainMenu();
    }


    private void mainMenu() {
        System.out.println(WELCOME);
        String title = START_GAME + EXIT_GAME + ENTER_YOUR_CHOICE;
        IntegerSelectDialog dialog = new IntegerSelectDialog(title, WRONG_INPUT, Set.of(NEW_GAME, EXIT));
        int choice = dialog.input();
        if (choice == NEW_GAME) {
            run();
        }
        if (choice == EXIT) {
            System.exit(0);
        }
    }
}
