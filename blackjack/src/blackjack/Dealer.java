package blackjack;
import java.util.Random;

public class Dealer extends Player {

    private final int CUSP = 16;
    private final Random rnd = new Random();

    public Dealer() {
        super("Dealer");
    }

    @Override
    public boolean wantsToHit() {
        boolean couldGoEitherWay = hand.getTotal() == CUSP;
        if (couldGoEitherWay) {
            return rnd.nextBoolean(); // true or false instead of  "hit" or "stay";
        }
        return hand.getTotal() < CUSP;
    }

    @Override
    public boolean wantsToPlayAgain() {
        return false;
    }
}