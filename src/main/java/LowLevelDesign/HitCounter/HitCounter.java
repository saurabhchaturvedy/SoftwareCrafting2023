package main.java.LowLevelDesign.HitCounter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    Queue<Integer> window = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {

    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        window.offer(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (!window.isEmpty() && timestamp - window.peek() >= 300) {
            window.poll();
        }
        return window.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */