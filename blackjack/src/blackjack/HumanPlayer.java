import java.util.Scanner;

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
        String input = userInput.nextLine();
        while (!(input.equals(option1) || input.equals(option2))) {
            input = userInput.nextLine();
        }
        return input.equals(option1);
    }
    
    public  void decidedToStay(){
        stayed = true;
    }
}
