package main.java.LowLevelDesign.SnakesAndLadders;

public class Main {

    public static void main(String[] args) {
        SnakesAndLadders game = new SnakesAndLadders();
        game.addPlayer(new Player("Saurabh"));
        game.addPlayer(new Player("Annu"));
        game.play();
    }
}
