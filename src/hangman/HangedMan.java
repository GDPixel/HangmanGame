package hangman;

public class HangedMan {
    private int hitPoints;

    public HangedMan(int initialHitPoints) {
        this.hitPoints = initialHitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void decreaseHitPoints() {
        if (hitPoints > 0) {
            hitPoints--;
        }
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }
}

