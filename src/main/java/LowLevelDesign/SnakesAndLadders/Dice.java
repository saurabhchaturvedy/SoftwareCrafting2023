package main.java.LowLevelDesign.SnakesAndLadders;

import java.util.Random;

public class Dice {

    int num;

    Dice(int num) {
        this.num = num;
    }

    int roll() {
        Random random = new Random();
        return 1 + random.nextInt(num);
    }
}
