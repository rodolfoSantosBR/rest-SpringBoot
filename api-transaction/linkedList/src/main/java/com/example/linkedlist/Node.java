package com.example.linkedlist;

public class Node<T> {

    private T valor ;
    private Node<T> next ;
    public Node(T valor) {
        this.valor = valor;
    }
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
