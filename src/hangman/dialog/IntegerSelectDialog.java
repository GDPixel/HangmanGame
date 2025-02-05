package hangman.dialog;

import java.util.Scanner;
import java.util.Set;

public class IntegerSelectDialog implements Dialog<Integer> {
    private final String title;
    private final String error;
    private final Set<Integer> options;

    public IntegerSelectDialog(String title, String error, Set<Integer> options) {
        this.title = title;
        this.error = error;
        this.options = options;
    }

    @Override
    public Integer input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(title);
            String input = scanner.nextLine();
            if (isInteger(input)) {
                int option = Integer.parseInt(input);
                if (options.contains(option)) {
                    return option;
                }
            }
            System.out.println(error);
        }
    }

    private boolean isInteger(String input) {
        return input.matches("^-?\\d+$");
    }
}


