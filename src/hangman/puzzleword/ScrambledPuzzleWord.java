package hangman.puzzleword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrambledPuzzleWord extends PuzzleWord {
    private String scrambledWord;

    public ScrambledPuzzleWord(String word) {
        super(word);
        scrambleWord();
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

    public String getScrambledWord() {
        return scrambledWord;
    }

    private void scrambleWord() {
        List<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters);

        StringBuilder resultWord = new StringBuilder();
        for (char c : characters) {
            resultWord.append(c);
        }

        scrambledWord = resultWord.toString();
    }
}
