package blackjack;

public interface BlackjackView {

    void welcome();

    String showInitialHand(Player player);

    String showHand(Player player);

    void askForTurn(Player player);

    void displayTotal(Player player);

    void showWinner(Player player);

    void thanksForPlaying();

    void playerHit(Player player);

    void playerStay(Player player);
}