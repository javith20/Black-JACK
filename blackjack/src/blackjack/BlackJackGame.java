package blackjack;
public class BlackJackGame {
    private final Blackjack blackjack;
    private final BlackjackView view;
    private final BlackjackController controller;


    public BlackJackGame(Blackjack blackjack, BlackjackView view, BlackjackController controller) {
        this.blackjack = blackjack;
        this.view = view;
        this.controller = controller;
    }

}
