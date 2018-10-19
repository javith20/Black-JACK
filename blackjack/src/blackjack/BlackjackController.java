package blackjack;
public class BlackjackController {

    private Blackjack blackjack;
    private BlackjackView view;

    public void run() {
        playOneGame();
        view.thanksForPlaying();
    }


    public BlackjackController(Blackjack blackjack, BlackjackView view) {
        this.blackjack = blackjack;
        this.view = view;
    }

    private void playOneGame() {

        view.welcome();
        for (Player player : blackjack.getPlayers()) {
            view.showInitialHand(player);
        }
        for (Player player : blackjack.getPlayers()) {
            letPersonPlayItsTurns(player);
        }
        for (Player player : blackjack.getPlayers()) {
            view.displayTotal(player);
        }

        Player winner = blackjack.getWinner();
        view.showWinner(winner);

        if (winner.wantsToPlayAgain()) {
            playOneGame();
        }
    }

    private void letPersonPlayItsTurns(Player player) {
        view.showHand(player);
        while (true) {
            view.askForTurn(player); // prompts for the hit/stay
            if (player.wantsToHit()) { // reads in from Scanner if 'hit'
                blackjack.dealCard(player);
                view.playerHit(player);
                view.showHand(player);
            } else { // 'stay'
                view.playerStay(player);
                break;
            }
        }
    }

}