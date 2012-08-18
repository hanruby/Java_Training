package ch16.ex16_11;

import ch16.ex16_11.TicTacToe.Mark;

public class RandomPlayer extends Player {

    @Override
    public void play(Game game) {
        TicTacToe t = new TicTacToe(); 
        t.setMark(2, 2, Mark.O);
        game.setScore(100);
    }
}
