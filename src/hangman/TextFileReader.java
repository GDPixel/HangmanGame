package hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader {
    public List<String> readWords(String fileName) {
        // check if file exist
        // add words to List
        // check if word empty throw exception
        Path path = Paths.get(fileName);
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(Files.newBufferedReader(path))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }

        } catch (IOException e) {
            System.out.println("File not found " + path);
            System.out.println(path.toAbsolutePath());
            System.exit(1);
        }
        System.out.println(path.toAbsolutePath());
        return words;
    }
}
