package blackjack;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class HumanPlayer extends Player {

    private final Scanner userInput;

    public HumanPlayer() {
        this("Unnamed HumanPlayer");
    }

    public HumanPlayer(final String name) {
        super(name);
        this.userInput = new Scanner(System.in);
    }

    @Override
    public boolean wantsToHit() {
        return chooseBetweenOptions("hit", "stay");
    }

    @Override
    public boolean wantsToPlayAgain() {
        return chooseBetweenOptions("y", "n");
    }

    private boolean chooseBetweenOptions(String option1, String option2) {
         int op =-10;
        
       
        while (op!=0 && op!=1 ) {
           op=JOptionPane.showConfirmDialog(null, "¿Desea otra carta?\nSi = Otra carta\nNo = Se queda");
        }
        return op==0;
    }
    
    public  void decidedToStay(){
        stayed = true;
    }
}
