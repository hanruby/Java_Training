package ch16.ex16_11;

import java.util.Random;

import ch16.ex16_11.TicTacToe.Mark;

public class RandomPlayer extends Player {

    @Override
    public void play(Game game) {
        TicTacToe t = new TicTacToe();
        Random rand = new Random();
        
        while( ! t.isFinish() ) {
            t.setMark(rand.nextInt(3), rand.nextInt(3), Mark.O);
            t.printGrid();
            if (t.isWin()) {
                break;
            }
        }
        game.setScore(t.getScore());
    }
}
