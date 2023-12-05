package com.queue.animalshelter;


import java.util.EmptyStackException;

public class SinglyLinkedList<T> {
    class Node<T> {

        T data;

        Node next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }

    }
    public Node head = null;

    public Node tail = null;

    private int size =0;

    public void insert(T data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void displayList() {
        Node current = head;
        if(head == null) {
            System.out.println("The given list is empty");
        }

        while(current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }
    public T remove(){
        if(this.head == null)
            throw new EmptyStackException();
        Node newNode = this.head;
        this.head = newNode.next;
        size--;
        return (T)newNode.data;
    }
    public boolean isEmpty(){
        return size<=0;
    }
    public T peek(){
        if(this.head == null)
            throw new EmptyStackException();
        return (T)this.head.data;
    }

}