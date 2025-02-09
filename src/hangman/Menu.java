package hangman;

import hangman.assets.messages.MenuMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final int FIRST_ID = 1;

    private final Scanner scanner = new Scanner(System.in);
    private String title;
    private final String description;
    private final String error;
    private final List<Item> items;
    private int idCounter = FIRST_ID;

    public Menu(String title, String description, String error) {
        this.title = title;
        this.description = description;
        this.error = error;
        items = new ArrayList<>();
    }

    public void add(String text, Runnable action) {
        items.add(new Item(idCounter, text, action));
        idCounter++;
    }

    public void addSubMenu(String text, Menu menu) {
        Runnable action = () -> {
            menu.show();
            menu.select();
            this.show();
            this.select();
        };
        add(text, action);
    }

    public void show() {
        System.out.println(title);
        System.out.println(MenuMessages.THIN_BORDER);
        for (Item item : items) {
            System.out.printf("%s (%d)%n", item.text, item.id);
        }
        System.out.println(MenuMessages.THIN_BORDER);
    }

    public void select() {
        System.out.println(description);
        while (true) {
            String input = scanner.nextLine();
            if (isInteger(input)) {
                int option = Integer.parseInt(input);
                if (FIRST_ID <= option && option <= items.getLast().id) {
                    Item item = items.get(option - FIRST_ID);
                    item.action.run();
                    break;
                }
            }
            System.out.println(error);
        }
    }

    private boolean isInteger(String input) {
        return input.matches("^-?\\d+$");
    }

    private record Item(int id, String text, Runnable action) {
    }
}
