package MyHashMap;

import java.util.Random;

public class TestHashMap {
    public static void main(String[] args) {

        MyHashMap<Integer, Integer> map = new MyHashMap<>(10, 0.5);

        Random rand = new Random();

        long start = System.nanoTime();

        // Insert random keys
        for (int i = 0; i < 10000; i++) {
            map.put(rand.nextInt(100000), i);
        }

        long end = System.nanoTime();

        System.out.println("Time: " + (end - start));
        System.out.println("Size: " + map.size());
    }
}