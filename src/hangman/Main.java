package hangman;

import hangman.game.GameDifficulty;
import hangman.game.HangmanGame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var game = new HangmanGame(GameDifficulty.MEDIUM);
        game.start();
    }

    private static List<String> getAnimals() {
        List<String> animals = new ArrayList<>();
        animals.add("giraffe");
        animals.add("dolphin");
        animals.add("penguin");
        animals.add("elephant");
        animals.add("kangaroo");
        animals.add("cheetah");
        animals.add("alligator");
        animals.add("octopus");
        animals.add("flamingo");
        animals.add("rhinoceros");
        animals.add("buffalo");
        animals.add("crocodile");

        return animals;
    }
}