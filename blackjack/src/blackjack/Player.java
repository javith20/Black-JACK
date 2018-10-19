package blackjack;
import java.util.List;

public abstract class Player {

    private final String name;
    protected Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public Hand getHand() {
        return this.hand;
    }

    public Hand getOpenHand() {
        Hand openHand = new Hand();
        List<Card> cards = this.hand.getCards();
        if (!cards.isEmpty()) {
            openHand.addCard(this.hand.getCards().get(0));
        }
        return openHand;
    }

    public abstract boolean wantsToHit();

    public abstract boolean wantsToPlayAgain();

    @Override
    public String toString() {
        return "Player: " + name;
    }
}
