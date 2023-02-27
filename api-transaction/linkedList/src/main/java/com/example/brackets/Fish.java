package com.example.brackets;

import java.util.Stack;

public class Fish {

    //new int[] {4,8,2,6,7}, new int[]{0,1,1,0,0}
    public int solution(int[] A, int[] B )  {

        Stack<Integer> stack = new Stack<>();
        int survivors = 0;

        for (int i = 0; i < A.length ; i++) {
            int weight = A[i] ;
            if(B[i] == 1 ) {
              stack.push(weight);

            } else {

                int weightDown = stack.isEmpty() ? -1 : stack.pop();
                while (weightDown != -1 && weightDown < weight)
                       weightDown = stack.isEmpty() ? -1 : stack.pop();

                if(weightDown == -1) {
                    survivors +=1;
                } else {
                    stack.push(weightDown);
                }
            }
        }
        return  survivors + stack.size();
    }


    public static void main(String[] args) {

        System.out.println(new Fish().solution(new int[] {4,8,2,6,7}, new int[]{0,1,1,0,0} ));
    }

}
