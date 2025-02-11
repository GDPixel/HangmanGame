package hangman.assets.messages;

public final class GameMessages {
    public static final String YOU_CAN_MAKE_MORE_MISTAKES = "You can make %d more mistake(s)%n";
    public static final String WORD_TO_GUESS = "Word to guess is: %s%n";
    public static final String WRONG_LETTERS = "Wrong letters: %s%n";
    public static final String ENTER_YOUR_GUESS = "Enter your guess: ";
    public static final String CURRENT_STAGE_STATUS = WORD_TO_GUESS + WRONG_LETTERS;
    public static final String WRONG_INPUT_LETTER = "Wrong input. Enter a letter";
    public static final String ALREADY_GUESSED_LETTER = "You have already entered this letter.";
    public static final String CONGRATULATION_WIN = "Congratulation! You won!";
    public static final String YOU_LOST = "You lost!";
    public static final String GUESSED_WORD_WAS = "The guessed word was ";

    public static final String THIN_BORDER = MenuMessages.THIN_BORDER;

    private GameMessages() {}
}