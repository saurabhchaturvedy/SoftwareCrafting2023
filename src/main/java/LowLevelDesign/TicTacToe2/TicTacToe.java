package main.java.LowLevelDesign.TicTacToe2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicTacToe {

    Board board;
    static int moves = 0;
    static boolean isWon = false;

    public TicTacToe(Board board) {
        this.board = board;
    }

    public void play(Player player, int row, int col) {


        board.showBoardStatus();
        if (moves == board.row * board.cols || isWon) {
            if (moves == board.row * board.cols) {
                System.out.println("No player won the game...it's a DRAW !!");
            }
            return;
        }
        Cell cell = new Cell(row, col, player.piece);
        moves++;
        System.out.println(" moves : " + moves);
        board.cells[row][col] = cell;
        player.addMove(cell);
        board.showBoardStatus();
        if (player.getMoves().size() >= board.row) {
            isWon = checkIfWon(player.getMoves());
            if (isWon) {
                System.out.println("Player with piece " + player.piece + " has won");
            }
        }
        if (moves == board.row * board.cols) {
            System.out.println("No player won the game...it's a DRAW !!");
        }
    }


    private boolean checkIfWon(List<Cell> moves) {

        boolean isDiagonalStrike = isDiagonalStrike(moves);
        if (isDiagonalStrike) return true;
        boolean isColumnStrike = isColumnStrike(moves);
        if (isColumnStrike) return true;
        boolean isRowStrike = isRowStrike(moves);
        if (isRowStrike) return true;
        return false;
    }

    private boolean isDiagonalStrike(List<Cell> moves) {

        int row = 0;
        int col = 0;
        List<Cell> diagonalCells_1 = new ArrayList<>();
        while (row < board.row && col < board.cols) {
            Cell cell = new Cell(row, col);
            diagonalCells_1.add(cell);
            row++;
            col++;
        }

        row = 0;
        col = 2;
        List<Cell> diagonalCells_2 = new ArrayList<>();
        while (row < board.row && col >= 0) {
            Cell cell = new Cell(row, col);
            diagonalCells_2.add(cell);
            row++;
            col--;
        }
        int diagonalCell1count = 0;
        for (Cell cell : moves) {
            if (diagonalCells_1.contains(cell)) {
                diagonalCell1count++;

            }
        }

        int diagonalCell2count = 0;
        for (Cell cell : moves) {
            if (diagonalCells_2.contains(cell)) {
                diagonalCell2count++;
            }
        }

        return diagonalCell1count == board.row || diagonalCell2count == board.row;
    }

    private boolean isColumnStrike(List<Cell> moves) {
        moves.sort(Comparator.comparingInt(x -> x.col));
        Map<Integer, List<Cell>> collect = moves.stream().collect(Collectors.groupingBy(Cell::getCol));
        for (Map.Entry<Integer, List<Cell>> entry : collect.entrySet()) {
            if (entry.getValue().size() == board.row) {
                return true;
            }
        }
        return false;
    }

    private boolean isRowStrike(List<Cell> moves) {
        moves.sort(Comparator.comparingInt(x -> x.row));
        Map<Integer, List<Cell>> collect = moves.stream().collect(Collectors.groupingBy(Cell::getRow));
        for (Map.Entry<Integer, List<Cell>> entry : collect.entrySet()) {
            if (entry.getValue().size() == board.row) {
                return true;
            }
        }
        return false;
    }
}
