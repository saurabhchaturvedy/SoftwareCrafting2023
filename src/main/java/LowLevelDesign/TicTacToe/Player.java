package main.java.LowLevelDesign.TicTacToe;

public class Player {

    private String Id;
    private String name;
    private final Piece piece;

    public Player(String Id, String name, Piece piece) {
        this.Id = Id;
        this.name = name;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}