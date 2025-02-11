package hangman.game;

import hangman.input.Menu;
import hangman.assets.messages.MenuMessages;
import hangman.models.WordSelector;
import hangman.models.puzzleword.PuzzleWord;
import hangman.models.puzzleword.ScrambledPuzzleWord;
import hangman.utility.TextFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HangmanGame {
    public static final String RESOURCE_FILE = "resources/words.txt";

    private enum GameType {
        REGULAR,
        SCRAMBLED
    }

    private Menu mainMenu;
    private GameDifficulty gameDifficulty;
    private List<String> words;

    public HangmanGame(GameDifficulty defaultGameDifficulty) {
        this(Collections.emptyList(), defaultGameDifficulty);
    }

    public HangmanGame(List<String> customWords, GameDifficulty defaultGameDifficulty) {
        this.words = customWords;
        this.gameDifficulty = defaultGameDifficulty;
        createMainMenu();
    }

    public void start() {
        showWelcomeScreen();
        showMainMenu();
    }

    private void showWelcomeScreen() {
        System.out.println(MenuMessages.WELCOME_SCREEN);
    }

    private void showMainMenu() {
        mainMenu.show();
        mainMenu.select();
    }

    private void createMainMenu() {
        mainMenu = new Menu(MenuMessages.MAIN_MENU, MenuMessages.ENTER_YOUR_CHOICE, MenuMessages.WRONG_INPUT);

        Menu difficultySubMenu = new Menu(MenuMessages.CHANGE_DIFFICULTY, MenuMessages.ENTER_YOUR_CHOICE, MenuMessages.WRONG_INPUT);

        difficultySubMenu.add(MenuMessages.EASY_DIFFICULTY_DESCRIPTION, () -> changeDifficulty(GameDifficulty.EASY));
        difficultySubMenu.add(MenuMessages.MEDIUM_DIFFICULTY_DESCRIPTION, () -> changeDifficulty(GameDifficulty.MEDIUM));
        difficultySubMenu.add(MenuMessages.HARD_DIFFICULTY_DESCRIPTION, () -> changeDifficulty(GameDifficulty.HARD));

        mainMenu.add(MenuMessages.START_REGULAR_GAME, this::newRegularGame);
        mainMenu.add(MenuMessages.START_SCRAMBLED_GAME, this::newScrambleGame);
        mainMenu.addSubMenu(MenuMessages.CHANGE_DIFFICULTY, difficultySubMenu);
        mainMenu.add(MenuMessages.EXIT, this::exit);
    }

    private void newRegularGame() {
        startNewGame(GameType.REGULAR);
    }

    private void newScrambleGame() {
        startNewGame(GameType.SCRAMBLED);
    }

    private void startNewGame(GameType gameType) {
        loadWords();
        WordSelector wordSelector = new WordSelector(words);
        String randomWord = wordSelector.selectRandomWord();
        PuzzleWord puzzleWord;
        switch (gameType) {
            case SCRAMBLED -> puzzleWord = new ScrambledPuzzleWord(randomWord);
            case REGULAR -> puzzleWord = new PuzzleWord(randomWord);
            default -> throw new IllegalArgumentException("Wrong gameType");
        }
        Game game = new Game(puzzleWord, gameDifficulty);
        showGameDescription(gameType);
        game.play();
        showMainMenu();
    }

    private void loadWords() {
        if (words.isEmpty()) {
            try {
                var reader = new TextFileReader(RESOURCE_FILE);
                words = reader.readWords();
            } catch (RuntimeException e) {
                words = new ArrayList<>();
                words.add("elephant");
                words.add("giraffe");
                words.add("dolphin");
                words.add("penguin");
                words.add("kangaroo");
                words.add("cheetah");
                words.add("alligator");
                words.add("octopus");
                words.add("flamingo");
                words.add("rhinoceros");
                words.add("buffalo");
                words.add("crocodile");
            }
        }
    }

    private void showGameDescription(GameType gameType) {
        System.out.printf(MenuMessages.STARTING_WHICH_GAME, gameDifficulty.name(), gameType.name());
        System.out.println(MenuMessages.THIN_BORDER);
        switch (gameType) {
            case SCRAMBLED -> System.out.println(MenuMessages.SCRAMBLED_GAME_DESCRIPTION);
            case REGULAR -> System.out.println(MenuMessages.REGULAR_GAME_DESCRIPTION);
            default -> throw new RuntimeException("Wrong gameType");
        }
        System.out.println(MenuMessages.THIN_BORDER);
    }

    private void changeDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    private void exit() {
        System.out.println(MenuMessages.EXITING_GAME);
    }
}
