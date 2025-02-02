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
        PuzzleWord puzzleWord = new PuzzleWord(guessWord);
        System.out.println("Log: The word is guessed");
        System.out.println(guessWord);
        int stage = 0;
        while(stage < 6) {
            System.out.println("Word to guess is: " + puzzleWord.getMaskedWord());
            System.out.println("Enter your guess: ");
            char letter = scanner.next().charAt(0);
            while (userLettersInput.hasLetter(letter)) {
                System.out.println("You have already entered this letter.");
                System.out.println("Enter your guess again: ");
                letter = scanner.next().charAt(0);
            }
            userLettersInput.addLetter(letter);
            puzzleWord.putLetter(letter);
            stage++;
        }

        System.out.println(userLettersInput.getLetters());
    }
}
