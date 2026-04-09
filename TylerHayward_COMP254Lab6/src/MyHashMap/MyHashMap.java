package MyHashMap;

import java.util.*;

public class MyHashMap<K, V> {

    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int capacity;
    private int size;
    private double maxLoadFactor;

    // Entry class
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    // Constructor
    public MyHashMap(int cap, double loadFactor) {
        capacity = cap;
        maxLoadFactor = loadFactor;
        size = 0;

        table = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // Put method
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(index);

        for (Entry<K, V> e : bucket) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;

        // Resize check
        if ((double) size / capacity > maxLoadFactor) {
            resize();
        }
    }

    // Get method
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(index);

        for (Entry<K, V> e : bucket) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    // Resize method
    private void resize() {
        capacity *= 2;
        ArrayList<LinkedList<Entry<K, V>>> oldTable = table;

        table = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }

        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldTable) {
            for (Entry<K, V> e : bucket) {
                put(e.key, e.value);
            }
        }

        System.out.println("Resized! New capacity: " + capacity);
    }

    public int size() {
        return size;
    }
}