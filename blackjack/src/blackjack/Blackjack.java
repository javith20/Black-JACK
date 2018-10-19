package blackjack;
import java.util.ArrayList;
import java.util.List;

public class Blackjack {

    private final int WINNING_SCORE = 21;
    private List<Player> players;
    private Deck deck = new Deck();


    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public Blackjack(Dealer dealer, List<Player> players) {
        this.players = new ArrayList<>();
        this.players.add(dealer); // dealer is first
        this.players.addAll(players);
        dealInitialCards();
    }


    public void dealCard(Player player) {
        Card card = deck.draw();
        player.receiveCard(card);
    }

    private void dealInitialCards() {
        for (Player player : players) {
            dealCard(player);
            dealCard(player);
        }
    }

    public Player getWinner() {
        int highest = 0;
        Player topPlayer = players.get(0);
        for (Player player : players) {
            int total = player.getHand().getTotal();
            if (total >= highest && total <= WINNING_SCORE) {
                highest = total;
                topPlayer = player;
            }
        }
        return topPlayer;
    }
}