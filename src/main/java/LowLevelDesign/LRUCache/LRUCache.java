package main.java.LowLevelDesign.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    private static class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode previous;
    }

    Map<Integer, ListNode> cache = new HashMap<>();
    int count = 0;
    int capacity;
    ListNode head;
    ListNode tail;

    LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        this.head = new ListNode();
        head.previous = null;

        this.tail = new ListNode();
        tail.next = null;

        head.next = tail;
        tail.previous = head;
    }


    public void addNode(ListNode node) {
        node.previous = head;
        node.next = head.next;

        head.next.previous = node;
        head.next = node;
    }

    public void removeNode(ListNode node) {
        ListNode previous = node.previous;
        ListNode next = node.next;

        previous.next = next;
        next.previous = previous;
    }

    public void moveToHead(ListNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    public ListNode popTail() {
        ListNode last = tail.previous;
        this.removeNode(last);
        return last;
    }


    public int get(int key) {

        ListNode node = cache.get(key);

        if (node == null) {
            return -1;
        }

        this.moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        ListNode node = cache.get(key);

        if (node == null) {

            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                ListNode tail = this.popTail();
                this.cache.remove(tail.key);
                this.removeNode(tail);
                --count;

            }
        } else {

            node.value = value;
            this.moveToHead(node);
        }

    }
}
