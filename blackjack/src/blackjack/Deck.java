package blackjack;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards = new Stack<>();

    public Deck() {
        fillDeckWithAllCards();
    }

    public Card draw() {
        if (cards.isEmpty()) {
            fillDeckWithAllCards();
        }
        return cards.pop();
    }

    public Card peek() {
        if (cards.isEmpty()) {
            fillDeckWithAllCards();
        }
        return cards.peek();
    }

    private void fillDeckWithAllCards() {
        for (int i = 0; i < 4; i++) {
            for (Card card : Card.values()) {
                cards.push(card);
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}