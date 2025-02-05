package hangman;

public class HangmanPictures {
    private final String[] pictures = {
            """
              +--+
              |  |
                 |
                 |
                 |
                 |
            ======
            """,
            """
              +--+
              |  |
              O  |
                 |
                 |
                 |
            ======
            """,
            """
              +--+
              |  |
              O  |
              |  |
                 |
                 |
            ======
            """,
            """
              +--+
              |  |
              O  |
             /|  |
                 |
                 |
            ======
            """,
            """
              +--+
              |  |
              O  |
             /|\\ |
                 |
                 |
            ======
            """,
            """
              +--+
              |  |
              O  |
             /|\\ |
             /   |
                 |
            ======
            """,
            """
              +--+
              |  |
              O  |
             /|\\ |
             / \\ |
                 |
            ======
            """
    };

    public void print(int stage) {
        System.out.print(pictures[stage]);
    }
}
