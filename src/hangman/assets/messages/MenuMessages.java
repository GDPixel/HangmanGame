package hangman.assets.messages;

public final class MenuMessages {
    public static final String BORDER = "═════════════════════════════════";
    public static final String THIN_BORDER = "―――――――――――――――――――";
    public static final String HANGMAN_TITLE =
        """
                              
                        ┓┏
                        ┣┫┏┓┏┓┏┓┏┳┓┏┓┏┓
                        ┛┗┗┻┛┗┗┫┛┗┗┗┻┛┗
                               ┛
                """;

    public static final String WELCOME_SCREEN = BORDER + HANGMAN_TITLE + BORDER;

    public static final String MAIN_MENU = "\t\t\tMain menu";
    public static final String GAME_DIFFICULTY = "Game difficulty is ";
    public static final String START_REGULAR_GAME = "Start Regular game";
    public static final String START_SCRAMBLE_GAME = "Start Scramble game";
    public static final String CHANGE_DIFFICULTY = "Change difficulty";
    public static final String EXIT = "Exit";
    public static final String ENTER_YOUR_CHOICE = "Please enter your choice: ";
    public static final String WRONG_INPUT = "Wrong input";
    public static final String EXITING_GAME = "Exiting game...";

    private MenuMessages() {}
}



