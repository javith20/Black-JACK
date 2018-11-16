package blackjack;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        Player playerOne = new HumanPlayer("Player 1");
        Player playerTwo = new HumanPlayer("Player 2");
        List<Player> allPlayers = new ArrayList<>();
        
        allPlayers.add(playerOne);
        allPlayers.add(playerTwo);
        Blackjack blackjack = new Blackjack(dealer, allPlayers);
        BlackjackView view = new ConsoleView();
        BlackjackController controller = new BlackjackController(blackjack, view);
        controller.run();
    }
}
