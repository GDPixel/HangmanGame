package hangman;

import java.util.List;
import java.util.Random;

public class WordSelector {
    private final List<String> words;
    private final Random rand = new Random();

    public WordSelector(List<String> words) {
        this.words = words;
    }

    public String selectWord() {
        return words.get(rand.nextInt(words.size()));
    }
}
