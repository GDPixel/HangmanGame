package hangman;

import hangman.dialog.EnglishLetterDialog;

public class Game {
    private static final int MAX_HIT_POINTS = 6;
    private static final String WRONG_INPUT_LETTER = "Wrong input. Enter a letter";

    private final PuzzleWord puzzleWord;
    private final UserLettersInput userLettersInput;
    private final HangmanPictures hangmanPictures;
    private final HangedMan hangedMan;

    public Game(String selectedWord, GameDifficulty gameDifficulty) {
        puzzleWord = new PuzzleWord(selectedWord);
        hangedMan = new HangedMan(gameDifficulty.getInitialHealth());
        hangmanPictures = new HangmanPictures();
        userLettersInput = new UserLettersInput();
        // TODO remove log
        System.out.println("Log: The guessed word is " + puzzleWord.getWord());
        puzzleWord.openRandomLetters(gameDifficulty.getNumberOfOpenLetters());
    }

    public void run() {
        while (isRunning()) {
            hangmanPictures.print(MAX_HIT_POINTS - hangedMan.getHealth());
            System.out.printf("You can make %d more mistake(s)%n", hangedMan.getHealth());
            String title = "Word to guess is: " + puzzleWord.getMaskedWord()
                    + "\nEntered letters: " + userLettersInput.getLetters()
                    + "\nEnter your guess: ";
            EnglishLetterDialog dialog = new EnglishLetterDialog(title, WRONG_INPUT_LETTER);
            char letter = dialog.input();
            while (userLettersInput.hasLetter(letter)) {
                System.out.println("You have already entered this letter.");
                letter = dialog.input();
            }
            userLettersInput.addLetter(letter);
            if (puzzleWord.hasLetter(letter)) {
                puzzleWord.openLetter(letter);
            } else {
                hangedMan.decreaseHealth();
            }
        }
        printGameResult();
    }

    private void printGameResult() {
        if (isWin()) {
            System.out.println("Congratulation! You won!");
        } else if (isLose()) {
            System.out.println("You lost!");
            System.out.println("The guessed word was " + puzzleWord.getWord());
            hangmanPictures.print(MAX_HIT_POINTS);
        }
    }

    private boolean isRunning() {
        return hangedMan.isAlive() && !isWin();
    }

    private boolean isWin() {
        return puzzleWord.isSolved();
    }

    private boolean isLose() {
        return !hangedMan.isAlive();
    }

}
