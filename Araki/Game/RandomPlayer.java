//package Game;

import java.util.Random;
import ch16.ex16_11.Player;
import ch16.ex16_11.Game;

public class RandomPlayer extends Player {

    @Override
    public void play(Game game) {
        TicTacToe t = new TicTacToe();
        Random rand = new Random();
        
        while( ! t.isFinish() ) {
            if (! t.setMark(rand.nextInt(3), rand.nextInt(3), t.getPlayer()) ) {
                continue;
            }
            if (t.isWin()) {
                break;
            }
        }
        t.printGrid();
        game.setScore(t.getScore());
    }
}
