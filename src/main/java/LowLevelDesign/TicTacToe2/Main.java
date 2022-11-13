package main.java.LowLevelDesign.TicTacToe2;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(3, 3);
        board.initializeBoard();
        TicTacToe ticTacToe = new TicTacToe(board);
        Player playerX = new Player(Piece.X);
        Player playerO = new Player(Piece.O);

        ticTacToe.play(playerO, 0, 0);
        ticTacToe.play(playerX, 1, 0);
        ticTacToe.play(playerO, 2, 0);
        ticTacToe.play(playerX, 0, 1);
        ticTacToe.play(playerO, 1, 1);
        ticTacToe.play(playerX, 2, 1);
        ticTacToe.play(playerO, 0, 2);



    }
}
