import java.util.List;
import java.util.Scanner;

public class HangManGame {
    private List<String> words;
    private final UserLettersInput userLettersInput = new UserLettersInput();
    private WordSelector wordSelector;

    public HangManGame(List<String> words) {
        this.words = words;
        wordSelector = new WordSelector(words);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String guessWord = wordSelector.selectWord();
        System.out.println("The word is guessed");
        System.out.println(guessWord);
        int stage = 0;
        while(stage < 6) {
            System.out.println("Enter your guess: ");
            char letter = scanner.next().charAt(0);
            while (userLettersInput.hasLetter(letter)) {
                letter = scanner.next().charAt(0);
            }
            userLettersInput.addLetter(letter);
            stage++;
        }

        System.out.println(userLettersInput.getLetters());
    }

}
