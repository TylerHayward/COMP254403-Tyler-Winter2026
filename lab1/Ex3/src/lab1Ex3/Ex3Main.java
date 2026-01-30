package lab1Ex3;

public class Ex3Main {

    static class CircularlyLinkedList<E> implements Cloneable {
        static class Node<E> {
            E element;
            Node<E> next;
            Node(E e, Node<E> n) { element = e; next = n; }
        }

        private Node<E> tail = null; // tail points to last node
        private int size = 0;

        public int size() { return size; }
        public boolean isEmpty() { return size == 0; }

        public E first() {
            if (isEmpty()) return null;
            return tail.next.element;
        }

        public E last() {
            if (isEmpty()) return null;
            return tail.element;
        }

        public void addLast(E e) {
            Node<E> newest = new Node<>(e, null);
            if (isEmpty()) {
                newest.next = newest; // points to itself
                tail = newest;
            } else {
                newest.next = tail.next; // new points to head
                tail.next = newest;      // old tail points to new
                tail = newest;           // new becomes tail
            }
            size++;
        }

        // === REQUIRED METHOD: clone the circular list (deep copy)
        @Override
        public CircularlyLinkedList<E> clone() {
            CircularlyLinkedList<E> other = new CircularlyLinkedList<>();
            if (this.isEmpty()) return other;

            // Walk size times starting from head
            Node<E> walk = this.tail.next; // head
            for (int i = 0; i < this.size; i++) {
                other.addLast(walk.element);
                walk = walk.next;
            }
            return other;
        }

        public String toString() {
            if (isEmpty()) return "[]";
            StringBuilder sb = new StringBuilder("[");
            Node<E> walk = tail.next; // head
            for (int i = 0; i < size; i++) {
                sb.append(walk.element);
                walk = walk.next;
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        CircularlyLinkedList<String> c1 = new CircularlyLinkedList<>();
        c1.addLast("A");
        c1.addLast("B");
        c1.addLast("C");

        CircularlyLinkedList<String> c2 = c1.clone();

        System.out.println("Original: " + c1);
        System.out.println("Clone:    " + c2);

        // Prove it's a deep copy by changing original
        c1.addLast("D");
        System.out.println("Original after add: " + c1);
        System.out.println("Clone stays same:   " + c2);
    }
}
