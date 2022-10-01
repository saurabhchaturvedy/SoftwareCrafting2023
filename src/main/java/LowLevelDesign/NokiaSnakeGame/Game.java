package main.java.LowLevelDesign.NokiaSnakeGame;

public class Game {


    Board board;
    Snake snake;
    Direction direction;
    boolean isGameOver;

    Game(Board board, Snake snake) {
        this.board = board;
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }


    public Cell getNextCell(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        if (direction == Direction.LEFT) {
            col--;
        }

        if (direction == Direction.RIGHT) {
            col++;
        }

        if (direction == Direction.UP) {
            row--;
        }

        if (direction == Direction.DOWN) {
            row++;
        }

        Cell nextCell = board.getCells()[row][col];

        return nextCell;
    }


    public void play() {
        System.out.println("Playing the game : ");

        if (!isGameOver) {
            if (direction != Direction.IDLE) {
                Cell nextCell = getNextCell(snake.getHead());

                if (snake.hasCollision(nextCell)) {
                    System.out.println("Collision has happened ::");
                    setDirection(Direction.IDLE);
                    isGameOver = true;
                } else {
                    snake.move(nextCell);
                    if (nextCell.getType() == CellType.FOOD) {
                        System.out.println("Snake in food cell...growing in size");
                        snake.grow();
                        board.generateFood();
                    }
                }
            }
        }
    }
}
