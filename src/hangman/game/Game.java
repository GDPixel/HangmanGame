package hangman.game;

import hangman.assets.messages.GameMessages;
import hangman.assets.HangmanPictures;
import hangman.input.dialog.EnglishLetterDialog;
import hangman.models.HangedMan;
import hangman.models.WrongLetters;
import hangman.models.puzzleword.PuzzleWord;

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

        for (int i = 0; i < gameDifficulty.getNumberOfOpenLetters(); i++) {
            puzzleWord.openRandomLetter();
        }
    }

    public void play() {
        while (isRunning()) {
            showGameStage();
            char letter = getUserGuess();
            processUserGuess(letter);
        }
        printGameResult();
    }

    private void showGameStage() {
        int stage = MAX_HEALTH - hangedMan.getHealth();
        hangmanPictures.print(stage);
        System.out.printf(GameMessages.YOU_CAN_MAKE_MORE_MISTAKES, hangedMan.getHealth());
    }

    private char getUserGuess() {
        String currentStatusTitle = GameMessages.CURRENT_STAGE_STATUS
                .formatted(puzzleWord.getMaskedWord(), wrongLetters.getLetters())
                + GameMessages.ENTER_YOUR_GUESS;

        EnglishLetterDialog dialog = new EnglishLetterDialog(currentStatusTitle, GameMessages.WRONG_INPUT_LETTER);
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
        if (isWin()) {
            System.out.println(GameMessages.CONGRATULATION_WIN);
        } else if (isLose()) {
            hangmanPictures.print(MAX_HEALTH);
            System.out.println(GameMessages.YOU_LOST);
        }
        System.out.println(GameMessages.GUESSED_WORD_WAS + puzzleWord.getWord());
        System.out.println(GameMessages.THIN_BORDER);
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
