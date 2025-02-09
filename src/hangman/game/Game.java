package hangman.game;

import hangman.assets.messages.GameMessages;
import hangman.assets.HangmanPictures;
import hangman.dialog.EnglishLetterDialog;
import hangman.models.HangedMan;
import hangman.models.WrongLetters;
import hangman.models.puzzleword.PuzzleWord;
import hangman.models.puzzleword.ScrambledPuzzleWord;

public class Game {
    private static final int MAX_HEALTH = 6;

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
            showGameStage();
            char letter = getUserGuess();
            processUserGuess(letter);
        }
        printGameResult();
    }

    private void showGameStage() {
        hangmanPictures.print(MAX_HEALTH - hangedMan.getHealth());
        System.out.printf(GameMessages.YOU_CAN_MAKE_MORE_MISTAKES, hangedMan.getHealth());
    }

    private char getUserGuess() {
        String statusTitle = GameMessages.WORD_TO_GUESS + puzzleWord.getMaskedWord()
                + "\n" + GameMessages.WRONG_LETTERS + wrongLetters.getLetters()
                + "\n" + GameMessages.ENTER_YOUR_GUESS;
        EnglishLetterDialog dialog = new EnglishLetterDialog(statusTitle, GameMessages.WRONG_INPUT_LETTER);
        char letter = dialog.input();
        while (isLetterGuessed(letter)) {
            System.out.println(GameMessages.ALREADY_GUESSED_LETTER);
            letter = dialog.input();
        }

        return letter;
    }

    private boolean isLetterGuessed(char letter) {
        return wrongLetters.hasLetter(letter) || puzzleWord.hasMaskedWordLetter(letter);
    }

    private void processUserGuess(char letter) {
        if (puzzleWord.hasLetter(letter)) {
            puzzleWord.openLetter(letter);
        } else {
            wrongLetters.addLetter(letter);
            hangedMan.decreaseHealth();
        }
    }

    private void printGameResult() {
        System.out.println(GameMessages.GUESSED_WORD_WAS + puzzleWord.getWord());
        if (isWin()) {
            System.out.println(GameMessages.CONGRATULATION_WIN);
        } else if (isLose()) {
            System.out.println(GameMessages.YOU_LOST);
            hangmanPictures.print(MAX_HEALTH);
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
