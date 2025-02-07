package hangman.game;

import hangman.assets.HangmanPictures;
import hangman.dialog.EnglishLetterDialog;
import hangman.models.HangedMan;
import hangman.models.WrongLetters;
import hangman.models.puzzleword.PuzzleWord;
import hangman.models.puzzleword.ScrambledPuzzleWord;

public class Game {
    private static final int MAX_HEALTH = 6;
    private static final String WRONG_INPUT_LETTER = "Wrong input. Enter a letter";

    private final PuzzleWord puzzleWord;
    private final WrongLetters wrongLetters;
    private final HangmanPictures hangmanPictures;
    private final HangedMan hangedMan;

    public Game(PuzzleWord puzzleWord, GameDifficulty gameDifficulty) {
        this.puzzleWord = puzzleWord;
        hangedMan = new HangedMan(gameDifficulty.getInitialHealth());
        hangmanPictures = new HangmanPictures();
        wrongLetters = new WrongLetters();
        // TODO remove log
        System.out.println("Log: The guessed word is " + puzzleWord.getWord());
        if (puzzleWord instanceof ScrambledPuzzleWord scrambledPuzzleWord) {
            System.out.println(scrambledPuzzleWord.getScrambledWord());
        }

        for (int i = 0; i < gameDifficulty.getNumberOfOpenLetters(); i++) {
            puzzleWord.openRandomLetter();
        }
    }

    public void run() {
        while (isRunning()) {
            hangmanPictures.print(MAX_HEALTH - hangedMan.getHealth());
            System.out.printf("You can make %d more mistake(s)%n", hangedMan.getHealth());
            String title = "Word to guess is: " + puzzleWord.getMaskedWord()
                    + "\nWrong letters: " + wrongLetters.getLetters()
                    + "\nEnter your guess: ";
            EnglishLetterDialog dialog = new EnglishLetterDialog(title, WRONG_INPUT_LETTER);
            char letter = dialog.input();
            while (isLetterGuessed(letter)) {
                System.out.println("You have already entered this letter.");
                letter = dialog.input();
            }

            if (puzzleWord.hasLetter(letter)) {
                puzzleWord.openLetter(letter);
            } else {
                wrongLetters.addLetter(letter);
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
            hangmanPictures.print(MAX_HEALTH);
        }
    }

    private boolean isLetterGuessed(char letter) {
        return wrongLetters.hasLetter(letter) || puzzleWord.hasMaskedWordLetter(letter);
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
