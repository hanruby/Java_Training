package ch16.ex16_11;

public class DumbPlayer extends Player {

    @Override
    public void play(Game game) {
        TicTacToe t = new TicTacToe();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                t.setMark(x, y, t.getPlayer());
                if (t.isWin()) {
                    break;
                }
            }
        }
        t.printGrid();
        game.setScore(t.getScore());
    }
}
