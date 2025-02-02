import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordFileReader {
    public List<String> readWords(String fileName) throws FileNotFoundException {
        // check if file exist
        // add words to List
        // check if word empty throw exception
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found" + fileName);
        }

        return words;
    }
}
