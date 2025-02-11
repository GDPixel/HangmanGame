package hangman.assets.messages;

import hangman.game.GameDifficulty;

public final class MenuMessages {
    public static final String BORDER = "════════════════════════════════════════";
    public static final String THIN_BORDER = "────────────────────────────────────────";
    public static final String HANGMAN_TITLE = """
            
                        ┓┏
                        ┣┫┏┓┏┓┏┓┏┳┓┏┓┏┓
                        ┛┗┗┻┛┗┗┫┛┗┗┗┻┛┗
                               ┛
            """;

    public static final String WELCOME_SCREEN = BORDER + HANGMAN_TITLE + BORDER;

    public static final String MAIN_MENU = "              Main menu";
    public static final String STARTING_WHICH_GAME = "Starting %s %s Game%n";
    public static final String START_REGULAR_GAME = "Start Regular game";
    public static final String START_SCRAMBLED_GAME = "Start Scrambled game";
    public static final String CHANGE_DIFFICULTY = "Change difficulty";
    public static final String DIFFICULTY_DESCRIPTION = "%s: %d open letter(s), %d health";
    public static final String EASY_DIFFICULTY_DESCRIPTION = makeDifficultyDescription(GameDifficulty.EASY);
    public static final String MEDIUM_DIFFICULTY_DESCRIPTION = makeDifficultyDescription(GameDifficulty.MEDIUM);
    public static final String HARD_DIFFICULTY_DESCRIPTION = makeDifficultyDescription(GameDifficulty.HARD);
    public static final String INSANE_DIFFICULTY_DESCRIPTION = makeDifficultyDescription(GameDifficulty.INSANE);

    public static final String EXIT = "Exit";
    public static final String ENTER_YOUR_CHOICE = "Please enter your choice: ";
    public static final String WRONG_INPUT = "Wrong input";
    public static final String EXITING_GAME = """
            Exiting game
            See you later...
            """;

    public static final String REGULAR_GAME_DESCRIPTION = "Enter letters to uncover the hidden word!";
    public static final String SCRAMBLED_GAME_DESCRIPTION = REGULAR_GAME_DESCRIPTION + """
                        \nThe letters in the word are scrambled,
                        except for the first one.
                        You need to mentally unscramble it.
                        Good luck!""";

    private MenuMessages() {
    }

    private static String makeDifficultyDescription(GameDifficulty difficulty) {
        return DIFFICULTY_DESCRIPTION.formatted(difficulty.name(), difficulty.getNumberOfOpenLetters(), difficulty.getInitialHealth());
    }
}



