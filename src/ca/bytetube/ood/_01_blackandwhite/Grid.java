package ca.bytetube.ood._01_blackandwhite;

public class Grid {
    private int[][] grid;
    private int rows;
    private int cols;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initBoard();
    }


    public void initBoard() {
        this.grid = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.grid[r][c] = GridPosition.EMPTY.ordinal();
            }
        }
    }


    public int[][] getGrid() {
        return grid;
    }


    public int getCols() {
        return cols;
    }

    public int placePiece(int col, GridPosition piece) {
        if (col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid column");
        }
        if (piece == GridPosition.EMPTY) {
            throw new RuntimeException("Invalid piece");
        }

        //place piece in the lowest empty row
        for (int r = rows - 1; r >= 0; r--) {
            if (grid[r][col] == GridPosition.EMPTY.ordinal()) {
                grid[r][col] = piece.ordinal();
                return r;
            }
        }
        return -1;
    }

    public boolean checkWinCondition(int connectN, int row, int col, GridPosition piece) {
        //1.row
        int count = 0;
        for (int c = 0; c < cols; c++) {
            if (grid[row][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }
        //2.col

        count = 0;
        for (int r = 0; r < rows; r++) {
            if (grid[r][col] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }
        //3.Diagonal
        count = 0;
        for (int r = 0; r < rows; r++) {
            int c = row + col - r; //row + col = r + c
            if (c >= 0 && c < cols && grid[r][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }


        }

        count = 0;
        for (int r = 0; r < rows; r++) {
            int c = col - row + r;//row - col = r - c
            if (c >= 0 && c < cols && grid[r][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }


        }
        return false;
    }
}
