import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> words;
        final String fileName = "resources//words.txt";
        WordFileReader fileReader = new WordFileReader();
        words = fileReader.readWords(fileName);

        HangManGame game = new HangManGame(words);
        game.run();
    }
}

// ТЗ Виселица
//
// 1. При старте, приложение предлагает начать новую игру или выйти из приложения
// 2. При начале новой игры, случайным образом загадывается слово,
// и игрок начинает процесс по его отгадыванию
// 3. После каждой введенной буквы выводим в консоль счётчик ошибок,
// текущее состояние виселицы (нарисованное ASCII символами)
// 4. По завершении игры выводим результат (победа или поражение) и возвращаемся
// к состоянию #1 - предложение начать новую игру или выйти из приложения