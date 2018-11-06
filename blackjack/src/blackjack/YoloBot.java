
package blackjack;

public class YoloBot extends Player {

    public YoloBot(String name) {
        super(name);
    }

    @Override
    public boolean wantsToHit() {
        return true;
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
    public  void decidedToStay(){
        stayed = true;
    }
}
