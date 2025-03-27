package ca.bytetube.ood._01_blackandwhite;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Grid grid;
    private int connectN;
    private Player[] players;
    private Map<String, Integer> score;
    private int targetScore;

    static Scanner input = new Scanner(System.in);


    public Game(Grid grid, int connectN, int targetScore) {
        this.grid = grid;
        this.connectN = connectN;
        this.targetScore = targetScore;
        this.players = new Player[]{
                new Player("Player 1", GridPosition.BLACK),
                new Player("Player 2", GridPosition.WHITE)
        };
        this.score = new HashMap<>();
        for (Player player : players) {
            this.score.put(player.getName(), 0);
        }


    }


    private void printBoard() {
        System.out.println("Board:");
        int[][] grid = this.grid.getGrid();
        for (int i = 0; i < grid.length; i++) {
            String row = "";
            for (int piece : grid[i]) {
                if (piece == GridPosition.EMPTY.ordinal()) {
                    row += "0 ";
                } else if (piece == GridPosition.BLACK.ordinal()) {
                    row += "B ";
                } else if (piece == GridPosition.WHITE.ordinal()) {
                    row += "W ";
                }
            }
            System.out.println(row);

        }
        System.out.println();
    }

    private int[] playMove(Player player) {
        printBoard();
        System.out.println(player.getName() + "'s turn");
        int colNum = grid.getCols();
        System.out.println("enter col 0 to " + (colNum - 1) + " to add piece:");
        int moveCol = input.nextInt();
        int movRow = grid.placePiece(moveCol, player.getPieceColor());

        return new int[]{movRow, moveCol};
    }

    private Player playRound() {
        while (true) {
            for (Player player : players) {
                int[] pos = playMove(player);
                int row = pos[0];
                int col = pos[1];
                GridPosition pieceColor = player.getPieceColor();
                if (this.grid.checkWinCondition(connectN, row, col, pieceColor)) {
                    score.put(player.getName(), this.score.get(player.getName()) + 1);
                    return player;
                }
            }
        }

    }

    public void play() {
        int maxScore = 0;
        Player winner = null;
        while (maxScore < this.targetScore) {
            winner = playRound();
            System.out.println(winner.getName() + "won the round");
            maxScore = Math.max(this.score.get(winner.getName()), maxScore);
            grid.initBoard();

        }

        System.out.println("winner is " + winner.getName());
    }

    public static void main(String[] args) {
        Grid grid = new Grid(15, 15);
        Game game = new Game(grid, 5, 3);
        game.play();
    }
}
