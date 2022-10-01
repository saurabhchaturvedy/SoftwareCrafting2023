package main.java.LowLevelDesign.NokiaSnakeGame;

public class Main {

    public static void main(String[] args) {

        System.out.println("Going to start game");

        Cell initPos = new Cell(0, 0);
        Snake snake = new Snake(initPos);
        Board board = new Board(10, 10);
        Game newGame = new Game(board, snake);
        newGame.isGameOver = false;
        newGame.direction = Direction.RIGHT;

        // We need to update the game at regular intervals,
        // and accept user input from the Keyboard.

        // here I have just called the different methods
        // to show the functionality
        for (int i = 0; i < 5; i++) {
            if (i == 2) newGame.board.generateFood();
            newGame.play();
            if (i == 3) newGame.direction = Direction.RIGHT;
            if (newGame.isGameOver == true) break;
        }
    }
}
