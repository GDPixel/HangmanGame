public class PuzzleWord {
    private static final String MASK = "_";
    private final String word;
    private final StringBuilder maskedWord;


    public PuzzleWord(String word) {
        this.word = word;
        maskedWord = new StringBuilder(MASK.repeat(word.length()));
    }

    public String getMaskedWord() {
        return maskedWord.toString();
    }

    public boolean hasLetter(char letter) {
        return word.contains(String.valueOf(letter));
    }

    public void putLetter(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                maskedWord.setCharAt(i, letter);
            }
        }
    }
}
