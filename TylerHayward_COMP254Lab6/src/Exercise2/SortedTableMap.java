package Exercise2;

import java.util.ArrayList;

public class SortedTableMap<K extends Comparable<K>, V> {

    private ArrayList<Entry<K, V>> table = new ArrayList<>();

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    // Find index using linear search (simplified)
    private int findIndex(K key) {
        int i = 0;
        while (i < table.size() && table.get(i).key.compareTo(key) < 0) {
            i++;
        }
        return i;
    }

    public void put(K key, V value) {
        int i = findIndex(key);

        if (i < table.size() && table.get(i).key.equals(key)) {
            table.get(i).value = value;
        } else {
            table.add(i, new Entry<>(key, value));
        }
    }

    public V get(K key) {
        int i = findIndex(key);

        if (i < table.size() && table.get(i).key.equals(key)) {
            return table.get(i).value;
        }
        return null;
    }

    // ✅ THIS IS THE REQUIRED METHOD
    public boolean containsKey(K key) {
        int i = findIndex(key);

        if (i < table.size() && table.get(i).key.equals(key)) {
            return true;
        }
        return false;
    }
}