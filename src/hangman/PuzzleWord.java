package hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PuzzleWord {
    private static final String MASK = "_";
    private final String word;
    private final StringBuilder maskedWord;


    public PuzzleWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("PuzzleWord constructor argument can't be null");
        }
        this.word = word;
        maskedWord = new StringBuilder(MASK.repeat(word.length()));
    }

    public String getWord() {
        return word;
    }

    public String getMaskedWord() {
        return maskedWord.toString();
    }

    public boolean hasLetter(char letter) {
        return word.contains(String.valueOf(letter));
    }

    public void openLetter(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                maskedWord.setCharAt(i, letter);
            }
        }
    }

    public void openRandomLetters(int count) {
        // TODO bug if count > word.length infinite cycle
        Set<Character> uniqueLetters = new HashSet<>();
        Random rand = new Random();
        while (count > 0) {
            int letterPosition = rand.nextInt(word.length());
            char letter = word.charAt(letterPosition);
            if (!uniqueLetters.contains(letter)) {
                uniqueLetters.add(letter);
                openLetter(letter);
                count--;
            }
        }
    }

    public boolean isSolved() {
        return word.equals(getMaskedWord());
    }
}
