package hangman.models;

public class HangedMan {
    private int health;

    public HangedMan(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth() {
        if (health > 0) {
            health--;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}

