package hangman.input.dialog;

import java.util.Scanner;

public class EnglishLetterDialog implements Dialog<Character> {
    private final String title;
    private final String error;

    public EnglishLetterDialog(String title, String error) {
        this.title = title;
        this.error = error;
    }

    @Override
    public Character input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(title);
            String input = scanner.nextLine();
            if (isEnglishLetter(input)) {
                return input.toLowerCase().charAt(0);
            }
            System.out.println(error);
        }
    }

    boolean isEnglishLetter(String input) {
        return input.matches("[a-zA-Z]");
    }
}
