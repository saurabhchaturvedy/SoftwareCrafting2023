package main.java.LowLevelDesign.NokiaSnakeGame;

import java.util.LinkedList;

public class Snake {

    LinkedList<Cell> snakeList = new LinkedList<>();
    Cell head;

    Snake(Cell initPos) {
        head = initPos;
        snakeList.add(head);
    }

    public void grow() {
        snakeList.add(head);
    }

    public void move(Cell nextCell) {
        System.out.println("Snake is moving to cell : " + nextCell.getRow() + " : " + nextCell.getCol());
        Cell tail = snakeList.removeLast();
        tail.setType(CellType.EMPTY);

        head = nextCell;
        snakeList.addFirst(head);
    }

    public boolean hasCollision(Cell nextCell) {
        System.out.println("Checking for collision : ");
        for (Cell cell : snakeList) {
            if (cell == nextCell) {
                System.out.println("*** Collision has happened ***");
                return true;
            }
        }

        return false;
    }

    public LinkedList<Cell> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(LinkedList<Cell> snakeList) {
        this.snakeList = snakeList;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }
}
