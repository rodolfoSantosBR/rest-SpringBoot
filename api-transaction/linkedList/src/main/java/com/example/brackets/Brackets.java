package com.example.brackets;

import java.util.Stack;

public class Brackets {

    public int solution (String s) {
            Stack<Character> stack  = new Stack<>();

        for(char chr : s.toCharArray()) {
           if(chr == '{' || chr == '[' || chr == '(') {
                stack.push(chr);
           } else if (chr == '}') {
               if(stack.isEmpty() || stack.pop() != '{') return 0 ;
           } else if (chr == ']') {
               if(stack.isEmpty() || stack.pop() != '[') return 0 ;
           } else if (chr == ')') {
               if(stack.isEmpty() || stack.pop() != '(') return 0 ;
           }
        }
        return stack.isEmpty() ? 1 : 0 ;

    }
    public static void main(String[] args) {
        System.out.println( new  Brackets().solution("{[(]}"));
    }

}
