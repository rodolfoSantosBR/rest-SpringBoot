package com.example.linkedlist;

public class Client {


    public static void main(String[] args) {


        LinkedList<Integer> linkedList = new LinkedList<Integer> ();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(1);

        System.out.println("Primeiro: " + linkedList.getFirst().getValor());
        System.out.println("Ultimo: " + linkedList.getLast().getValor());
        System.out.println("Length: "+ linkedList.getLength());

        for (int i = 0; i < linkedList.getLength(); i++) {
            System.out.println(linkedList.get(i).getValor());
        }

    }

}
