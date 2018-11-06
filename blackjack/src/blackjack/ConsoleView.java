package blackjack;

public class ConsoleView implements BlackjackView {

    @Override
    public void welcome() {
        System.out.println("\n\n\nWelcome to a new Blackjack game!\n\n");
    }

    @Override
    public void showInitialHand(Player player) {
        Hand hand = player.getOpenHand();
        System.out.println(player + " has " + hand + ".\n");
    }

    @Override
    public void showHand(Player player) {
        Hand hand = player.getHand();
        System.out.println(player.toString() + " has " + hand.toString() + ".\n");
        System.out.println("That makes a total of " + hand.getTotal() + ".\n");
    }

    @Override
    public void askForTurn(Player player) {
        System.out.print("Does " + player + " want to 'hit' or 'stay'? ");
    }

    @Override
    public void displayTotal(Player player) {
        System.out.println(player.toString() + "'s total is " + player.getHand().getTotal() + ".");
    }

    @Override
    public void showWinner(Player player) {
        System.out.println(player.toString() + " is the winner!\n");
    }

    @Override
    public void thanksForPlaying() {
        System.out.println("\nThanks for playing!");
    }

    @Override
    public void playerHit(Player player) {
        System.out.println(player + " chose to hit");
    }

    @Override
    public void playerStay(Player player) {
        System.out.println(player + " chose to stay");
    }
}