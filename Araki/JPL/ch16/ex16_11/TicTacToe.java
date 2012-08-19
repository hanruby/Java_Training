package ch16.ex16_11;

public class TicTacToe {

    public enum Mark {
        None (" "),
        X ("X"),
        O ("O");
        
        String m;
        private Mark(String m) {
            this.m = m;
        }
        
        @Override
        public String toString() {
            return this.m;
        }
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

            // ゲームカウントをインクリメント
            count++;
            
            // winner調査
            checkWinner(m);
            
            return true;
        }
        return false;
    }
    
    public boolean isFinish() {
        // カウントがフルになっているか、または、winnerが決まっていればおわり
        return (count >= GRID_X*GRID_Y) || (this.winner != Mark.None);
    }
    
    public int getScore() {
        return GRID_X*GRID_Y - count;
    }
    
    private void checkWinner(Mark m) {
        // Horizontal
        for (int y = 0; y < GRID_Y; y++) {
            if ( isHorizontal(m, y) ) {
                this.winner = m;
                return;
            } 
        }

        // Vertical
        for (int x = 0; x < GRID_X; x++) {
            if ( isVertical(m, x) ) {
                this.winner = m;
                return;
            } 
        }

        // Diagonal
        if ( isDiagonal(m) ) {
            this.winner = m;
            return;
        } 
    }
    
    public boolean isWin() {
        return (winner != Mark.None);
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
    
    public void printGrid() {
        
        /* 
         * -----
         * O X O
         * X O X
         * O X O
         * -----
         */
        
        StringBuilder output = new StringBuilder(30);
        output.append("-----%n");
        for (int y = 0; y < GRID_Y; y++) {
            for (int x = 0; x < GRID_X; x++) {
                output.append(grid[x][y].toString());
                output.append(" ");
            }
            output.append("%n");
        }
        output.append("-----%n");

        System.out.printf(output.toString());
    }
}
