package ca.bytetube.ood._01_backandwhite;

public class Player {
    private String name;
    private GridPosition piece;

    public Player() {
    }

    public Player(String name, GridPosition piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GridPosition getPieceColor() {
        return piece;
    }

    public void setPiece(GridPosition piece) {
        this.piece = piece;
    }


}
