import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words;
        final String fileName = "resources//words.txt";
        TextFileReader fileReader = new TextFileReader();
        words = fileReader.readWords(fileName);

        HangManGame game = new HangManGame(words);
        game.start();
    }
}

// TODO: add check win or lose
//  add checking user input
//      make userSelectedInput for menu
//      check user input for english letters
//  add platform independent file reader
//  add class asciipictures
//  add README.md GITHUB

// ТЗ Виселица
//
// 1. При старте, приложение предлагает начать новую игру или выйти из приложения
// 2. При начале новой игры, случайным образом загадывается слово,
// и игрок начинает процесс по его отгадыванию
// 3. После каждой введенной буквы выводим в консоль счётчик ошибок,
// текущее состояние виселицы (нарисованное ASCII символами)
// 4. По завершении игры выводим результат (победа или поражение) и возвращаемся
// к состоянию #1 - предложение начать новую игру или выйти из приложения