package hangman.game;

import hangman.assets.messages.MenuMessages;
import hangman.dialog.IntegerSelectDialog;
import hangman.models.WordSelector;
import hangman.models.puzzleword.PuzzleWord;
import hangman.models.puzzleword.ScrambledPuzzleWord;

import java.util.List;
import java.util.Set;

public class HangmanGame {

    private enum GameType {
        REGULAR,
        SCRAMBLED
    }

    private final WordSelector wordSelector;
    private final GameDifficulty gameDifficulty;

    public HangmanGame(List<String> words, GameDifficulty defaultGameDifficulty) {
        wordSelector = new WordSelector(words);
        this.gameDifficulty = defaultGameDifficulty;
    }

    public void start() {
        showMainMenu();
    }

    private void startNewGame(GameType gameType) {
        String selectedWord = wordSelector.selectRandomWord();
        PuzzleWord puzzleWord;
        if (gameType == GameType.SCRAMBLED) {
            puzzleWord = new ScrambledPuzzleWord(selectedWord);
        } else {
            puzzleWord = new PuzzleWord(selectedWord);
        }
        Game game = new Game(puzzleWord, gameDifficulty);
        game.run();
        showMainMenu();
    }

    private void newRegularGame() {
        startNewGame(GameType.REGULAR);
    }

    private void newScrambleGame() {
        startNewGame(GameType.SCRAMBLED);
    }

    private void showMainMenu() {
        System.out.println(MenuMessages.WELCOME_SCREEN);
        System.out.println(MenuMessages.GAME_DIFFICULTY + gameDifficulty);
        String mainMenuTitle = MenuMessages.MAIN_MENU_ITEMS + MenuMessages.ENTER_YOUR_CHOICE;
        IntegerSelectDialog dialog = new IntegerSelectDialog(mainMenuTitle, MenuMessages.WRONG_INPUT,
                Set.of(MenuMessages.NEW_REGULAR_GAME, MenuMessages.NEW_SCRAMBLE_GAME, MenuMessages.EXIT));
        int choice = dialog.input();
        selectMenu(choice);
    }

    private void selectMenu(int choice) {
        if (choice == MenuMessages.NEW_REGULAR_GAME) {
            newRegularGame();
        }
        if (choice == MenuMessages.NEW_SCRAMBLE_GAME) {
            newScrambleGame();
        }
        if (choice == MenuMessages.EXIT) {
            System.out.println(MenuMessages.EXITING_GAME);
        }
    }
}
