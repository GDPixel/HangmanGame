package hangman.assets;

public class HangmanPictures {
    private final String[] pictures = {
            """
                ╒════╗
                │    ║
                     ║
                     ║
                     ║
                     ║
            ═════════╩═════
            """,
            """
                ╒════╗
                │    ║
                O    ║
                     ║
                     ║
                     ║
            ═════════╩═════
            """,
            """
                ╒════╗
                │    ║
                O    ║
                │    ║
                     ║
                     ║
            ═════════╩═════
            """,
            """
                 ╒════╗
                 │    ║
                 O    ║
                /│    ║
                      ║
                      ║
            ══════════╩════
            """,
            """
                 ╒════╗
                 │    ║
                 O    ║
                /│\\   ║
                      ║
                      ║
            ══════════╩════
            """,
            """
                 ╒════╗
                 │    ║
                 O    ║
                /│\\   ║
                /     ║
                      ║
            ══════════╩════
            """,
            """
                 ╒════╗
                 │    ║
                 O    ║
                /│\\   ║
                / \\   ║
                      ║
            ══════════╩════
            """
    };

    public void print(int stage) {
        if (stage < 0 || stage >= pictures.length) {
            throw new IllegalArgumentException("Invalid stage number, it has to be between 0 and " + (pictures.length - 1));
        }
        System.out.print(pictures[stage]);
    }
}
