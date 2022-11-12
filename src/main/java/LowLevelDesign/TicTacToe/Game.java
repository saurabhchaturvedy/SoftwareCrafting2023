package main.java.LowLevelDesign.TicTacToe;

public class Game {

    private final Board board;
    private final Player[] players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private final int size = 3;
    private final int[] arrRow = new int[size];
    private final int[] arrCol = new int[size];
    private int drl = 0;
    private int dlr = 0;

    public Game(Player p1, Player p2) {

        players = new Player[2];
        players[0] = p1;
        players[1] = p2;
        board = new Board(size);
        currentPlayer = players[0];
        gameStatus = GameStatus.PLAYING;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean play(int row, int col) {
        if (GameStatus.PLAYING == gameStatus) {
            if (isValidMove(row, col)) {
                board.cells[row][col].setPiece(currentPlayer.getPiece());
                if (checkIfWon(row, col)) {
                    board.printBoardStatus();
                    return false;
                } else if (checkIfDraw(row, col)) {
                    board.printBoardStatus();
                    return false;
                }
                gameStatus = GameStatus.PLAYING;
                changeTurn();
                board.printBoardStatus();
                return true;
            }
            System.out.println(currentPlayer.getName() + " Please put valid move!");
            board.printBoardStatus();
            return false;
        } else {
            System.out.println(currentPlayer.getName() + " has already won the game! GAME IS OVER");
            board.printBoardStatus();
            return false;
        }
    }

    private boolean checkIfDraw(int row, int col) {
        if (drl > size || dlr > size || arrCol[col] > size || arrRow[row] > size || -size > arrRow[row] || drl < -size || dlr < -size || arrCol[col] < -size) {

            gameStatus = GameStatus.DRAW;
            System.out.println("Game has been finished with status DRAW!!");
            return true;
        }
        return false;
    }

    private void changeTurn() {
        if (currentPlayer.getId().equals(players[0].getId())) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }
    }


    private boolean checkIfWon(int row, int col) {

        if (currentPlayer.getId().equals(players[0].getId())) {
            if (row == col) {
                dlr++;
            } else if (row + col == size - 1) {
                drl++;
            }
            arrRow[row] = arrRow[row] + 1;
            arrCol[col] = arrCol[col] + 1;
            if (arrRow[row] == size || arrCol[col] == size || drl == size || dlr == size) {
                gameStatus = GameStatus.WON;
                System.out.println(currentPlayer.getName() + " has won the Game!!");
                return true;
            }
        } else {
            if (row == col) {
                dlr--;
            } else if (row + col == -(size - 1)) {
                drl--;
            }
            arrRow[row] = arrRow[row] - 1;
            arrCol[col] = arrCol[col] - 1;
            if (arrRow[row] == -size || arrCol[col] == -size || drl == -size || dlr == -size) {
                gameStatus = GameStatus.WON;
                System.out.println(currentPlayer.getName() + " has won the Game!!");
                return true;
            }

        }

        return false;
    }

    private boolean isValidMove(int row, int col) {
        return row < size && col < size && board.cells[row][col] != null;
    }


}