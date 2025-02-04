package hangman;

import java.util.List;
import java.util.Scanner;

public class HangmanGame {
    private static final int MAX_ERRORS = 6;
    private static final int NEW_GAME = 1;
    private static final int EXIT = 2;

    private final HangmanPictures hangmanPictures;
    private final List<String> words;
    private final WordSelector wordSelector;
    private final Scanner scanner = new Scanner(System.in);

    public HangmanGame(List<String> words) {
        this.words = words;
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
        boolean isWin = false;
        while (error != MAX_ERRORS) {
            hangmanPictures.print(error);
            System.out.println("Word to guess is: " + puzzleWord.getMaskedWord());
            System.out.println("Entered letters: " + userLettersInput.getLetters());
            System.out.println("Enter your guess: ");
            char letter = scanner.next().charAt(0);
            while (userLettersInput.hasLetter(letter)) {
                System.out.println("You have already entered this letter.");
                System.out.println("Entered letters: " + userLettersInput.getLetters());
                System.out.println("Enter your guess again: ");
                letter = scanner.next().charAt(0);
            }
            userLettersInput.addLetter(letter);
            if (puzzleWord.hasLetter(letter)) {
                puzzleWord.putLetter(letter);
            } else {
                error++;
            }

            isWin = guessWord.equals(puzzleWord.getMaskedWord());
            if (isWin) {
                break;
            }
        }

        if (isWin) {
            System.out.println("You win!");
            System.out.println("The guessed word is " + guessWord);
        } else {
            System.out.println("You lost!");
            hangmanPictures.print(MAX_ERRORS);
        }

        mainMenu();
    }


    private void mainMenu() {
        System.out.println("Welcome to Hangman Game!");
        System.out.printf("Start the game (%d)%n", NEW_GAME);
        System.out.printf("Exit the game (%d)%n", EXIT);
        System.out.print("Please enter your choice: ");
        int choice = scanner.nextInt();
        if (choice == NEW_GAME) {
            run();
        }
        if (choice == EXIT) {
            System.exit(0);
        }
    }
}
