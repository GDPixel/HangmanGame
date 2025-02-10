package hangman.game;

import hangman.input.Menu;
import hangman.assets.messages.MenuMessages;
import hangman.models.WordSelector;
import hangman.models.puzzleword.PuzzleWord;
import hangman.models.puzzleword.ScrambledPuzzleWord;

import java.util.List;

public class HangmanGame {

    private enum GameType {
        REGULAR,
        SCRAMBLED
    }

    private Menu mainMenu;
    private final WordSelector wordSelector;
    private GameDifficulty gameDifficulty;

    public HangmanGame(List<String> words, GameDifficulty defaultGameDifficulty) {
        wordSelector = new WordSelector(words);
        this.gameDifficulty = defaultGameDifficulty;
        createMainMenu();
    }

    public void start() {
        showWelcomeScreen();
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
        System.out.printf(MenuMessages.STARTING_WHICH_GAME, gameDifficulty.name(),gameType.name());
        game.play();
        showMainMenu();
    }

    private void newRegularGame() {
        startNewGame(GameType.REGULAR);
    }

    private void newScrambleGame() {
        startNewGame(GameType.SCRAMBLED);
    }


    private void createMainMenu() {
        mainMenu = new Menu(MenuMessages.MAIN_MENU, MenuMessages.ENTER_YOUR_CHOICE, MenuMessages.WRONG_INPUT);

        Menu difficultySubMenu = new Menu(MenuMessages.CHANGE_DIFFICULTY, MenuMessages.ENTER_YOUR_CHOICE, MenuMessages.WRONG_INPUT);
        difficultySubMenu.add(GameDifficulty.EASY.name(), () -> changeDifficulty(GameDifficulty.EASY));
        difficultySubMenu.add(GameDifficulty.MEDIUM.name(), () -> changeDifficulty(GameDifficulty.MEDIUM));
        difficultySubMenu.add(GameDifficulty.HARD.name(), () -> changeDifficulty(GameDifficulty.HARD));

        mainMenu.add(MenuMessages.START_REGULAR_GAME, this::newRegularGame);
        mainMenu.add(MenuMessages.START_SCRAMBLE_GAME, this::newScrambleGame);
        mainMenu.addSubMenu(MenuMessages.CHANGE_DIFFICULTY, difficultySubMenu);
        mainMenu.add(MenuMessages.EXIT, this::exit);
    }

    private void showWelcomeScreen() {
        System.out.println(MenuMessages.WELCOME_SCREEN);
    }

    private void showMainMenu() {

        mainMenu.show();
        mainMenu.select();
    }

    private void changeDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    private void exit() {
        System.out.println(MenuMessages.EXITING_GAME);
    }
}
