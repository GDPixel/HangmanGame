package hangman;

import hangman.game.GameDifficulty;
import hangman.game.HangmanGame;
import hangman.utility.TextFileReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String fileName = "resources/words.txt";
        List<String> words;
        try {
            var reader = new TextFileReader(fileName);
            words = reader.readWords();
        } catch (RuntimeException e) {
            words = getAnimals();
        }

        var game = new HangmanGame(words, GameDifficulty.MEDIUM);
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

// TODO: add README.md GITHUB

// ТЗ Виселица
//
// 1. При старте, приложение предлагает начать новую игру или выйти из приложения
// 2. При начале новой игры, случайным образом загадывается слово,
// и игрок начинает процесс по его отгадыванию
// 3. После каждой введенной буквы выводим в консоль счётчик ошибок,
// текущее состояние виселицы (нарисованное ASCII символами)
// 4. По завершении игры выводим результат (победа или поражение) и возвращаемся
// к состоянию #1 - предложение начать новую игру или выйти из приложения