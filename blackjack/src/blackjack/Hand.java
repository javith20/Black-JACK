package blackjack;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;


public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotal() {
        List<Integer> totals = new ArrayList<>();
        totals.add(0);
        for (Card card : cards) {
            for (int i = 0; i < totals.size(); i++) {
                totals.add(i, totals.get(i) + card.getRank());
                totals.remove(i + 1);
            }
            if (card.getRank() == 1) totals.add(totals.get(totals.size() - 1) - 10);
        }
        for (Integer total : totals) {
            if (total <= 21) return total;
        }
        return totals.get(totals.size() - 1);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nHand:\n");
        for (Card card : cards) {
            sb.append(card).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1); // remove last new line
        return sb.toString();
    }
}