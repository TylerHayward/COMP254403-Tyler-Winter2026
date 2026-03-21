package Exercises;

import java.util.ArrayList;

public class Exercise1 {

    // Simple Position class
    static class Position<E> {
        E element;

        Position(E e) {
            element = e;
        }
    }

    // Simple Positional List using ArrayList
    static class PositionalList<E> {
        private ArrayList<Position<E>> list = new ArrayList<>();

        public Position<E> addLast(E e) {
            Position<E> p = new Position<>(e);
            list.add(p);
            return p;
        }

        public int indexOf(Position<E> p) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == p) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        PositionalList<Integer> list = new PositionalList<>();

        Position<Integer> p1 = list.addLast(10);
        Position<Integer> p2 = list.addLast(20);
        Position<Integer> p3 = list.addLast(30);

        System.out.println("Index of p1: " + list.indexOf(p1));
        System.out.println("Index of p2: " + list.indexOf(p2));
        System.out.println("Index of p3: " + list.indexOf(p3));
    }
}