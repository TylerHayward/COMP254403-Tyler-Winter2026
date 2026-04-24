package Exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Exercise 1
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        for (int i = 1; i <= 5; i++) tree.insert(i);
        System.out.println("Path Length: " + tree.pathLength());

        // Exercise 2
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        System.out.println(map.putIfAbsent("a", 1));
        System.out.println(map.putIfAbsent("a", 2));

        // Exercise 3
        Queue<Account> q = new LinkedList<>();
        q.add(new Account(1, "Alice", 500));
        q.add(new Account(2, "Bob", 200));
        q.add(new Account(3, "Charlie", 800));

        List<Account> list = new ArrayList<>(q);
        list.sort(new AccountComparator());

        for (Account a : list) {
            System.out.println(a.customerName + " " + a.accountBalance);
        }

        // Exercise 4
        String[] tests = {
            "(a+b)", "(a+b*(c-d))", "(a+b*(c-d]", "{[()]}", "((())"
        };

        for (String s : tests) {
            System.out.println(s + " -> " + BalanceChecker.isBalanced(s));
        }
    }
}