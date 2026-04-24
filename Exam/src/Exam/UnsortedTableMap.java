package Exam;

import java.util.ArrayList;

public class UnsortedTableMap<K, V> {

    private class Entry {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    private ArrayList<Entry> table = new ArrayList<>();

    public V find(K key) {
        for (Entry e : table) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }

    public void put(K key, V value) {
        for (Entry e : table) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        table.add(new Entry(key, value));
    }

    public V putIfAbsent(K key, V value) {
        V existing = find(key);
        if (existing == null) {
            put(key, value);
            return null;
        }
        return existing;
    }
}