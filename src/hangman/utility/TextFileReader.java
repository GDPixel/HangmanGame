package hangman.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader {
    public List<String> readWords(String fileName) {
        Path path = Paths.get(fileName);
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(Files.newBufferedReader(path))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }

        } catch (IOException e) {
            System.out.println("File not found " + path);
            System.exit(1);
        }
        return words;
    }
}
