package ch16.ex16_11;

public class TicTacToe {

    public enum Mark {
        None,
        X ,
        O ,
    }
    
    private final int GRID_X = 3;
    private final int GRID_Y = 3;
    Mark[][] grid = new Mark[GRID_X][GRID_Y];
    
    public TicTacToe() {
        
        // Init
        for (int y = 0; y < GRID_Y; y++) {
            for (int x = 0; x < GRID_X; x++) {
                grid[x][y] = Mark.None;
            }
        }
    }
    
    public boolean setMark(int x, int y, Mark m) {
        if ( !( 0 <= x && x < GRID_X && 0 <= y && y < GRID_Y ) ) {
            throw new IllegalArgumentException("X or Y is invalid : (x,y) = (" + x + "," + y + ")");
        }
        if (grid[x][y] == Mark.None) {
            grid[x][y] = m;
            return true;
        }
        return false;
    }
    
    public String getScore() {

        return null;
    }
}
