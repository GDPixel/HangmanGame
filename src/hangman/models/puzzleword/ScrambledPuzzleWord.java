package hangman.models.puzzleword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrambledPuzzleWord extends PuzzleWord {
    private static final int FROM_INDEX_SCRAMBLE = 1;
    private final String scrambledWord;

    /**
     *   To make it easier for non-native English speakers,
     *   scramble word from index: {@value FROM_INDEX_SCRAMBLE} to the end
     */
    public ScrambledPuzzleWord(String word) {
        this(word, FROM_INDEX_SCRAMBLE, word.length());
    }

    public ScrambledPuzzleWord(String word, int fromIndex, int toIndex) {
        super(word);
        scrambledWord = scramble(word, fromIndex, toIndex);
    }

    @Override
    public void openLetter(char letter) {
        openLetterInWord(letter, scrambledWord);
    }

    @Override
    public void openRandomLetter() {
        openRandomLetterInWord(scrambledWord);
    }

    @Override
    public boolean isSolved() {
        return scrambledWord.equals(getMaskedWord());
    }

    private String scramble(String word, int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > word.length() || fromIndex >= toIndex) {
            throw new IllegalArgumentException("Invalid indices for scrambling.");
        }

        String substringToScramble = word.substring(fromIndex, toIndex);
        List<Character> letters = new ArrayList<>();
        for (char c : substringToScramble.toCharArray()) {
            letters.add(c);
        }

        Collections.shuffle(letters);
        StringBuilder resultWord = new StringBuilder();
        resultWord.append(word, 0, fromIndex);
        for (char c : letters) {
            resultWord.append(c);
        }
        resultWord.append(word, toIndex, word.length());

        return resultWord.toString();
    }
}
