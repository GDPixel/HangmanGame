package hangman;

import java.util.HashSet;
import java.util.Set;

public class UserLettersInput {
    private final Set<Character> letters = new HashSet<>();

    public boolean hasLetter(char letter) {
        if (letters.isEmpty()) {
            return false;
        }
        return letters.contains(letter);
    }

    public void addLetter(char letter) {
        letters.add(letter);
    }

    public Set<Character> getLetters() {
        return letters;
    }
}
