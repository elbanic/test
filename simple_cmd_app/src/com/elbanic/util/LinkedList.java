package com.elbanic.util;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node{
        private Object data;
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    Node getHead(){
        return head;
    }

    Node getTail(){
        return tail;
    }

    public void add(Object input){
        add(size, input);
    }

    public void add(int k, Object input){
        if (k > size) {
            System.out.println("k is must be less than list size");
            return;
        }

        Node newNode = new Node(input);
        if(k == 0){
            if (size > 0)
                newNode.next = node(0);
            head = newNode;
        }
        else {
            Node prev = node(k-1);
            Node next = prev.next;
            prev.next = newNode;
            newNode.next = next;
        }
        size++;
        if(newNode.next == null){
            tail = newNode;
        }
    }

    public String toString() {
        if(head == null){
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while(temp.next != null){
            str += temp.data + ",";
            temp = temp.next;
        }
        str += temp.data;
        return str+"]";
    }

    public Object remove(int k){
        if (k >= size) {
            System.out.println("k is must be less than list size");
            return null;
        }

        Node deleted;
        if(k == 0) {
            deleted = node(0);
            head = deleted.next;
        }
        else {
            Node prev = node(k-1);
            deleted = prev.next;
            prev.next = prev.next.next;
            if(deleted == tail){
                tail = prev;
            }
        }
        Object deletedData = deleted.data;
        deleted = null;
        size--;
        return deletedData;
    }

    public int size(){
        return size;
    }

    public Object get(int k){
        Node temp = node(k);
        return temp.data;
    }
}
