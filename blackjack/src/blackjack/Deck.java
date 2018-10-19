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
        for (int i = 1; i <= 4; i++) {
            for(int k = 1; i <= 13; i++){
                Card card = new Card(i, k);
                cards.add(card);
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}