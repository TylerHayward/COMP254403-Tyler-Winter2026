package Exam;

public class LinkedBinaryTree<E> {

    static class Node<E> {
        E data;
        Node<E> left, right;

        Node(E d) { data = d; }
    }

    Node<E> root;

    public void insert(E value) {
        root = insertRec(root, value);
    }

    private Node<E> insertRec(Node<E> node, E value) {
        if (node == null) return new Node<>(value);

        if (Math.random() < 0.5)
            node.left = insertRec(node.left, value);
        else
            node.right = insertRec(node.right, value);

        return node;
    }

    public int pathLength() {
        return pathLength(root, 0);
    }

    private int pathLength(Node<E> node, int depth) {
        if (node == null) return 0;
        return depth
                + pathLength(node.left, depth + 1)
                + pathLength(node.right, depth + 1);
    }
}