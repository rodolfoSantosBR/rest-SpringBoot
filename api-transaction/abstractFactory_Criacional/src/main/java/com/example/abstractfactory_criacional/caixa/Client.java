package com.example.abstractfactory_criacional.caixa;

import java.util.*;

public class Client {

    public static void main(String[] args) {

        List<Object> sequence =  Arrays.asList(36,6,24,4,47,7,2,3,27); // true
        List<Object> sequence2 =  Arrays.asList("p", "aba", "a", "b", "perso", "o", "r", "e", "s"); // true
        List<Object> sequence3 =  Arrays.asList("p", "abac", "a", "b", "perso", "o", "r", "e", "s"); // false
        List<Object> sequence4 =  Arrays.asList(39,26,24,4,47,7,2,3,27); // false
        List<Object> sequence5 =  Arrays.asList(40,76,24,4,47,7,2,3,27); // false
        List<Object> sequence6 =  Arrays.asList(39,6,27); // false
        List<Object> sequence7 =  Arrays.asList(39,3,9); // true
        List<Object> sequence8 =  Arrays.asList(39,86,24,4,9); // false
        List<Object> sequence9 =  Arrays.asList("p", "rodo", "l", "f", "o", "o", "r", "d", "p"); // false 'f' missing
        List<Object> sequence10 =  Arrays.asList("m", "marcia", "a", "m", "r", "c", "a", "i"); // true
        ChainValidator chainValidator = new ChainValidator();

        System.out.println( chainValidator.validate(sequence));
        System.out.println( chainValidator.validate(sequence2));
        System.out.println( chainValidator.validate(sequence3));
        System.out.println( chainValidator.validate(sequence4));
        System.out.println( chainValidator.validate(sequence5));
        System.out.println( chainValidator.validate(sequence6));
        System.out.println( chainValidator.validate(sequence7));
        System.out.println( chainValidator.validate(sequence8));
        System.out.println( chainValidator.validate(sequence9));
        System.out.println( chainValidator.validate(sequence10));


    }

}


class ChainValidator {

    boolean validate( List<Object> sequence) {

        List<Node<Object>> nodeSet = new ArrayList<>();

        sequence.stream().forEach(x -> {
            Node<Object> node = null;
            if (String.valueOf(x).length() > 1) {
                for (int i = 0; i < String.valueOf(x).length(); i++) {
                    nodeSet.add(new Node<>(String.valueOf(String.valueOf(x).charAt(i))));
                }
            } else {
                nodeSet.add(new Node<>(String.valueOf(x)));
            }
        }) ;
        List<Object> sequence9 =  Arrays.asList("p", "rodo", "l", "f", "o", "o", "r", "d", "p");
        boolean isValid =  true;

        for (int i = nodeSet.size() -1 ; i > 0 ; i--) {
            for (int j = 0; j < nodeSet.size() ; j++) {
                if((String.valueOf(nodeSet.get(i))).equals(String.valueOf(nodeSet.get(j))) && i != j) {
                    isValid =  true;
                    break;
                } else {
                    isValid = false ;
                }
            }
            if (!isValid) break;
        }
        return isValid ;
    }
}


class Node<T> {

    private T value ;
    private Node<T> next ;
    public Node(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
