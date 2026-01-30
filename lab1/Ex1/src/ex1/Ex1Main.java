package ex1;

public class Ex1Main {

    
    static class DoublyLinkedList<E> {
        private static class Node<E> {
            E element;
            Node<E> prev;
            Node<E> next;

            Node(E e, Node<E> p, Node<E> n) {
                element = e;
                prev = p;
                next = n;
            }
        }

        private Node<E> header;
        private Node<E> trailer;
        private int size = 0;

        public DoublyLinkedList() {
            header = new Node<>(null, null, null);
            trailer = new Node<>(null, header, null);
            header.next = trailer;
        }

        public int size() { return size; }
        public boolean isEmpty() { return size == 0; }

        private Node<E> addBetween(E e, Node<E> predecessor, Node<E> successor) {
            Node<E> newest = new Node<>(e, predecessor, successor);
            predecessor.next = newest;
            successor.prev = newest;
            size++;
            return newest;
        }

        public void addLast(E e) {
            addBetween(e, trailer.prev, trailer);
        }

        
        public void concatenate(DoublyLinkedList<E> M) {
            if (M == null || M.isEmpty()) return;
            if (this == M) return; // safety

          
            Node<E> lastL = this.trailer.prev;
            Node<E> firstM = M.header.next;
            Node<E> lastM = M.trailer.prev;

          
            lastL.next = firstM;
            firstM.prev = lastL;

            lastM.next = this.trailer;
            this.trailer.prev = lastM;

          
            this.size += M.size;

            
            M.header.next = M.trailer;
            M.trailer.prev = M.header;
            M.size = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node<E> walk = header.next;
            while (walk != trailer) {
                sb.append(walk.element);
                walk = walk.next;
                if (walk != trailer) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> L = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> M = new DoublyLinkedList<>();

        L.addLast(1);
        L.addLast(2);
        L.addLast(3);

        M.addLast(10);
        M.addLast(20);

        System.out.println("L before: " + L);
        System.out.println("M before: " + M);

        L.concatenate(M);

        System.out.println("L after:  " + L);
        System.out.println("M after:  " + M + " (should be empty)");
    }
}
