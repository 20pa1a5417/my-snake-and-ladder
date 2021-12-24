package snakesandladders;

public class Dice {
    private int noofdice;

    Dice(int noofdice) {
        this.noofdice = noofdice;
    }

    public int rollDiceNo() {
        return ((int) (Math.random() * (6 * noofdice - 1 * noofdice))) + 1;
    }
}
