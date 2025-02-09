package hangman.assets.messages;

public final class MenuMessages {
    public static final int NEW_REGULAR_GAME = 1;
    public static final int NEW_SCRAMBLE_GAME = 2;
    public static final int EXIT = 3;

    public static final String BORDER = "═════════════════════════════════";
    public static final String HANGMAN_TITLE =
        """
                                       \s
                        ┓┏
                        ┣┫┏┓┏┓┏┓┏┳┓┏┓┏┓
                        ┛┗┗┻┛┗┗┫┛┗┗┗┻┛┗
                               ┛
               \s""";

    public static final String WELCOME_SCREEN = BORDER + HANGMAN_TITLE + BORDER;

    public static final String GAME_DIFFICULTY = "Game difficulty: ";
    public static final String START_REGULAR_GAME = "Start the regular game (%d)%n".formatted(NEW_REGULAR_GAME);
    public static final String START_SCRAMBLE_GAME = "Start the scramble game (%d)%n".formatted(NEW_SCRAMBLE_GAME);
    public static final String EXIT_GAME = "Exit the game (%d)%n".formatted(EXIT);
    public static final String MAIN_MENU_ITEMS = START_REGULAR_GAME + START_SCRAMBLE_GAME + EXIT_GAME;
    public static final String ENTER_YOUR_CHOICE = "Please enter your choice: ";
    public static final String WRONG_INPUT = "Wrong input.";

    public static final String EXITING_GAME = "Exiting game...";

    private MenuMessages() {}
}


