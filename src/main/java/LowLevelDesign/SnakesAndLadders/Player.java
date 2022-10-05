package main.java.LowLevelDesign.SnakesAndLadders;

public class Player {

    String name;
    int position;

    Player(String name) {
        this.name = name;
        this.position = 0;
    }

    boolean move(Board board, int rolledDiceNumber) {
        int newPosition = this.position + rolledDiceNumber;

        if (newPosition > board.size) return false;

        System.out.println(" player's piece is now at position : " + newPosition);
        Cell cell = board.getCell(newPosition);

        if (cell.type == CellType.TARGET) {
            return true;
        } else if (cell.type == CellType.SNAKE || cell.type == CellType.LADDER) {

            this.position = cell.end;
            System.out.println("Player's piece is on a " + cell.type.toString() + " piece moved to value : " + this.position);
        } else {
            this.position = newPosition;
        }

        return false;
    }
}
