package blackjack;

public interface BlackjackView {

    void welcome();

    void showInitialHand(Player player);

    void showHand(Player player);

    void askForTurn(Player player);

    void displayTotal(Player player);

    void showWinner(Player player);

    void thanksForPlaying();

    void playerHit(Player player);

    void playerStay(Player player);
}