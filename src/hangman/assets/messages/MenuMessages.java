package hangman.assets.messages;

public final class MenuMessages {
    public static final int NEW_REGULAR_GAME = 1;
    public static final int NEW_SCRAMBLE_GAME = 2;
    public static final int EXIT = 3;

    public static final String BORDER = "==========================";
    public static final String WELCOME = "Welcome to Hangman Game!";
    public static final String GAME_DIFFICULTY = "Game difficulty: ";
    public static final String START_REGULAR_GAME = "Start the regular game (%d)%n".formatted(NEW_REGULAR_GAME);
    public static final String START_SCRAMBLE_GAME = "Start the scramble game (%d)%n".formatted(NEW_SCRAMBLE_GAME);
    public static final String EXIT_GAME = "Exit the game (%d)%n".formatted(EXIT);
    public static final String WRONG_INPUT = "Wrong input. Enter " + NEW_REGULAR_GAME + " or " + EXIT;
    public static final String ENTER_YOUR_CHOICE = "Please enter your choice: ";
    public static final String EXITING_GAME = "Exiting game...";
}
