package hangman;

import hangman.game.GameDifficulty;
import hangman.game.HangmanGame;
import hangman.utility.TextFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String fileName = "resources/words.txt";
        TextFileReader fileReader = new TextFileReader();
        List<String> words = fileReader.readWords(fileName);

        HangmanGame game = new HangmanGame(words, GameDifficulty.MEDIUM);
        game.start();
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