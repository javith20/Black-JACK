package blackjack;

import Servidor.Servidor;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BlackjackController {

    private Blackjack blackjack;
    private BlackjackView view;
    private Servidor servidor;

    public BlackjackController() {
    }

    public void run() {
        try {
            servidor = new Servidor(9999, 2);

        } catch (IOException e) {
        }
        playOneGame();
        view.thanksForPlaying();
    }

    public BlackjackController(Blackjack blackjack, BlackjackView view) {
        this.blackjack = blackjack;
        this.view = view;
    }

    private void playOneGame() {

        view.welcome();
        while (true) {
            Player player = blackjack.getPlayers().get(servidor.getTurno());
            JOptionPane.showMessageDialog(null, player.getName()+servidor.getTurno());
            servidor.establecerConexion(player.getName());
            System.out.println(servidor.getServer());
            servidor.escribirCliente(view.showInitialHand(blackjack.getPlayers().get(servidor.getTurno())));
            servidor.escribirCliente(view.showHand(blackjack.getPlayers().get(servidor.getTurno())));

            /*while (!blackjack.allPlayersStayed()) {
                for (Player player : blackjack.getPlayers()) {
                    if (!player.stayed) {
                        letPersonPlayItsTurn(player);
                    }
                }
            }
            for (Player player : blackjack.getPlayers()) {
                view.displayTotal(player);
            }

            Player winner = blackjack.getWinner();
            view.showWinner(winner);
            
            if (winner.wantsToPlayAgain()) {
                playOneGame();*/
        }
    }

    private void letPersonPlayItsTurn(Player player) {

        view.showHand(player);
        view.askForTurn(player);
        if (player.wantsToHit()) { // reads in from Scanner if 'hit'
            blackjack.dealCard(player);
            view.playerHit(player);
            view.showHand(player);
        } else {
            view.playerStay(player);
            player.decidedToStay();
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
