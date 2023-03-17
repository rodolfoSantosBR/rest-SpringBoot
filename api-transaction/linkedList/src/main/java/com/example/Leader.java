package com.example;

import java.util.Stack;

public class Leader {

    public int solution (int[] A ) {

        Stack<Integer> candidates =  new Stack<>();
        for(int item : A) {

            if (candidates.isEmpty()) {
                candidates.push(item) ;
            } else if (candidates.pop() == item) {
                candidates.push(item);
            }
        }
      return candidates.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Leader().solution(new int[]{ 3, 0, 2, 2, 4, 2, 2}));
    }

}
