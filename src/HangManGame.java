import java.util.List;
import java.util.Scanner;

public class HangManGame {
    private List<String> words;
    private final WordSelector wordSelector;
    private final Scanner scanner = new Scanner(System.in);

    public HangManGame(List<String> words) {
        this.words = words;
        wordSelector = new WordSelector(words);
    }

    public void start(){
        mainMenu();
        run();
    }

    private void run() {
        String guessWord = wordSelector.selectWord();
        PuzzleWord puzzleWord = new PuzzleWord(guessWord);
        UserLettersInput userLettersInput = new UserLettersInput();
        System.out.println("Log: The guessed word is " + guessWord);
        int stage = 0;
        while (stage < 6) {
            System.out.println("Word to guess is: " + puzzleWord.getMaskedWord());
            System.out.println("Entered letters: " + userLettersInput.getLetters());
            System.out.println("Enter your guess: ");
            char letter = scanner.next().charAt(0);
            while (userLettersInput.hasLetter(letter)) {
                System.out.println("You have already entered this letter.");
                System.out.println("Entered letters: " + userLettersInput.getLetters());
                System.out.println("Enter your guess again: ");
                letter = scanner.next().charAt(0);
            }
            userLettersInput.addLetter(letter);
            puzzleWord.putLetter(letter);
            stage++;
        }
    }


    private void mainMenu() {
        System.out.println("Welcome to HangMan Game!");
        System.out.println("Start the game (1)");
        System.out.println("Exit the game (2)");
        System.out.print("Please enter your choice: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            run();
        }
        if (choice == 2) {
            System.exit(0);
        }
    }
}
