package ex2;

public class Ex2Main {

    static class SinglyLinkedList<E> {
        static class Node<E> {
            E element;
            Node<E> next;
            Node(E e, Node<E> n) { element = e; next = n; }
            public E getElement() { return element; }
        }

        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        public int size() { return size; }
        public boolean isEmpty() { return size == 0; }

        public Node<E> firstNode() { return head; }  
        public Node<E> lastNode() { return tail; }

        public void addLast(E e) {
            Node<E> newest = new Node<>(e, null);
            if (isEmpty()) head = newest;
            else tail.next = newest;
            tail = newest;
            size++;
        }

        
        public Node<E> findFirst(E value) {
            Node<E> walk = head;
            while (walk != null) {
                if ((value == null && walk.element == null) ||
                    (value != null && value.equals(walk.element))) {
                    return walk;
                }
                walk = walk.next;
            }
            return null;
        }

        
        public void swapNodes(Node<E> node1, Node<E> node2) {
            if (node1 == null || node2 == null) return;
            if (node1 == node2) return;

            // We need prev1 and prev2 to rewire links
            Node<E> prev1 = null, prev2 = null, cur = head;

            while (cur != null && (prev1 == null || prev2 == null)) {
                if (cur.next == node1) prev1 = cur;
                if (cur.next == node2) prev2 = cur;
                cur = cur.next;
            }

           
            if (head == node1) prev1 = null;
            if (head == node2) prev2 = null;

         
            if (node1 != head && prev1 == null) return;
            if (node2 != head && prev2 == null) return;

         
            if (prev1 != null) prev1.next = node2;
            else head = node2;

            if (prev2 != null) prev2.next = node1;
            else head = node1;

       
            if (node1.next == node2) {
                // node1 -> node2
                Node<E> temp = node2.next;
                node2.next = node1;
                node1.next = temp;
            } else if (node2.next == node1) {
                // node2 -> node1
                Node<E> temp = node1.next;
                node1.next = node2;
                node2.next = temp;
            } else {
             
                Node<E> temp = node1.next;
                node1.next = node2.next;
                node2.next = temp;
            }

            
            if (tail == node1) tail = node2;
            else if (tail == node2) tail = node1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node<E> walk = head;
            while (walk != null) {
                sb.append(walk.element);
                walk = walk.next;
                if (walk != null) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Before: " + list);

        
        SinglyLinkedList.Node<Integer> n2 = list.findFirst(2);
        SinglyLinkedList.Node<Integer> n5 = list.findFirst(5);

        list.swapNodes(n2, n5);

        System.out.println("After:  " + list);

       
        SinglyLinkedList.Node<Integer> n3 = list.findFirst(3);
        SinglyLinkedList.Node<Integer> n4 = list.findFirst(4);

        list.swapNodes(n3, n4);

        System.out.println("After adjacent swap: " + list);
    }
}
