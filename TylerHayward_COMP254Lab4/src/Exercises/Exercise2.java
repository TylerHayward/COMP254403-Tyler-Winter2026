package Exercises;

import java.util.Stack;

public class Exercise2 {

    public static void transfer(Stack<Integer> S, Stack<Integer> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();

        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);

        System.out.println("S before: " + S);
        System.out.println("T before: " + T);

        transfer(S, T);

        System.out.println("S after: " + S);
        System.out.println("T after: " + T);
    }
}