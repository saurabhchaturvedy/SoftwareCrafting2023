package main.java.LowLevelDesign.HashMap;

public class CustomHashMap<K, V> {

    public static final int INITIAL_CAPACITY = 1 << 4;
    public static final int MAXIMUM_CAPACITY = 1 << 30;

    Entry<K, V>[] entries;

    CustomHashMap() {
        entries = new Entry[INITIAL_CAPACITY];
    }

    CustomHashMap(int capacity) {
        capacity = capacity > MAXIMUM_CAPACITY ? 1 : capacity;
        entries = new Entry[capacity];
    }


    public void put(K key, V value) {
        int index = key.hashCode() / entries.length;
        Entry node = entries[index];

        if (node == null) {
            Entry newNode = new Entry(key, value);
            entries[index] = newNode;
        } else {
            Entry previousNode = node;

            while (node != null) {
                if (node.getKey().equals(key)) {
                    node.value = value;
                    return;
                }

                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previousNode.next = newNode;
        }
    }

    public V get(K key) {
        int index = key.hashCode() / entries.length;
        Entry node = entries[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                return (V) node.getValue();
            }
            node = node.next;
        }

        return null;
    }
}
