package hangman.puzzleword;

import java.util.Random;

public class PuzzleWord {
    protected static final String MASK = "_";
    protected final String word;
    protected final StringBuilder maskedWord;


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

    public boolean hasMaskedWordLetter(char letter) {
        return getMaskedWord().contains(String.valueOf(letter));
    }

    public void openLetter(char letter) {
        openLetterInWord(letter, word);
    }

    protected void openLetterInWord(char letter, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                maskedWord.setCharAt(i, letter);
            }
        }
    }

    public void openRandomLetter() {
        openRandomLetterInWord(word);
//        if (isSolved()) {
//            return;
//        }
//
//        Random random = new Random();
//        int position = random.nextInt(maskedWord.length());
//        char letter = maskedWord.charAt(position);
//        while (letter != MASK.charAt(0)) {
//            position = random.nextInt(maskedWord.length());
//            letter = maskedWord.charAt(position);
//        }
//
//        openLetter(word.charAt(position));
    }

    protected void openRandomLetterInWord(String word) {
        if (isSolved()) {
            return;
        }

        Random random = new Random();
        int position = random.nextInt(maskedWord.length());
        char letter = maskedWord.charAt(position);
        while (letter != MASK.charAt(0)) {
            position = random.nextInt(maskedWord.length());
            letter = maskedWord.charAt(position);
        }

        openLetter(word.charAt(position));
    }

    public boolean isSolved() {
        return word.equals(getMaskedWord());
    }
}
