package hangman.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextFileReader {
    private final String fileName;

    public TextFileReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readWords() {
        Path path = Paths.get(fileName);
        List<String> words;
        try {
            words = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return words;

    }
}
