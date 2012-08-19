package ch16.ex16_11;

public class TicTacToe {

    public enum Mark {
        None,
        X ,
        O ,
    }

    private Mark winner = Mark.None;
    
    private final int GRID_X = 3;
    private final int GRID_Y = 3;
    Mark[][] grid = new Mark[GRID_X][GRID_Y];

    private int count = 0;
    
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

            count++;
            return true;
        }
        return false;
    }
    
    public int getScore() {
        return GRID_X*GRID_Y - count;
    }
    
    public boolean isWin() {

        // Horizontal
        for (int y = 0; y < GRID_Y; y++) {
            if ( isHorizontal(Mark.O, y) ) {
                this.winner = Mark.O;
                return true;
            } 
            else if ( isHorizontal(Mark.X, y) ) {
                this.winner = Mark.X;
                return true;
            } 
        }

        // Vertical
        for (int x = 0; x < GRID_X; x++) {
            if ( isVertical(Mark.O, x) ) {
                this.winner = Mark.O;
                return true;
            } 
            else if ( isVertical(Mark.X, x) ) {
                this.winner = Mark.X;
                return true;
            } 
        }

        // Diagonal
        if ( isDiagonal(Mark.O) ) {
            this.winner = Mark.O;
            return true;
        } 
        else if ( isDiagonal(Mark.X) ) {
            this.winner = Mark.X;
            return true;
        } 
        
        return false;
    }
    
    private boolean isHorizontal (Mark m, int y) {
        return ( grid[0][y] == m && grid[1][y] == m && grid[2][y] == m );
    }

    private boolean isVertical (Mark m, int x) {
        return ( grid[x][0] == m && grid[x][1] == m && grid[x][2] == m );
    }

    private boolean isDiagonal (Mark m) {
        return ( ( grid[0][0] == m && grid[1][1] == m && grid[2][2] == m ) || ( grid[0][2] == m && grid[1][1] == m && grid[2][0] == m ) ); 
    }
    
    public Mark getWinner() {
        return winner;
    }
}
