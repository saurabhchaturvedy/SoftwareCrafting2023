package main.java.LowLevelDesign.HashMap;

public class Main {

    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();

        map.put(1, "saurabh");
        map.put(2, "annu");


        System.out.println(map.get(2));
    }
}
