package com.elbanic.util;

public class Queue {

    private Node bottom;
    private long size;

    private class Node{
        private Object data;
        private Node upper;
        public Node(Object input) {
            this.data = input;
            this.upper = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    public Queue(Object item) {
        bottom = new Node(item);
        size = 1;
    }

    public void enqueue(Object item) {
        Node upper = bottom;
        bottom = new Node(item);
        bottom.upper = upper;
        size++;
    }

    public Object dequeue() {
        if (size <=0) return null;
        Object ret = bottom.data;
        bottom = bottom.upper;
        size--;
        return ret;
    }

    public long getSize() { return size; }
}
