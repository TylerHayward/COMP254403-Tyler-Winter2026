package Exercises;

class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
    }
}

class LinkedQueue<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) return null;
        E value = head.data;
        head = head.next;
        size--;
        if (isEmpty()) tail = null;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void concatenate(LinkedQueue<E> Q2) {
        if (Q2.isEmpty()) return;

        if (this.isEmpty()) {
            this.head = Q2.head;
            this.tail = Q2.tail;
        } else {
            this.tail.next = Q2.head;
            this.tail = Q2.tail;
        }

        this.size += Q2.size;

        Q2.head = null;
        Q2.tail = null;
        Q2.size = 0;
    }
}

public class Exercise3 {

    public static void main(String[] args) {
        LinkedQueue<Integer> q1 = new LinkedQueue<>();
        LinkedQueue<Integer> q2 = new LinkedQueue<>();

        q1.enqueue(1);
        q1.enqueue(2);

        q2.enqueue(3);
        q2.enqueue(4);

        q1.concatenate(q2);

        System.out.println("Q1 after concatenate:");
        while (!q1.isEmpty()) {
            System.out.print(q1.dequeue() + " ");
        }

        System.out.println("\nQ2 is empty: " + q2.isEmpty());
    }
}