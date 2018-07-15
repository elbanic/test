package com.elbanic.util;
import java.util.EmptyStackException;

public class Stack {

    private Node top;
    private long size;

    private class Node{
        private Object data;
        private Node under;
        public Node(Object input) {
            this.data = input;
            this.under = null;
        }
        public String toString(){
            return String.valueOf(this.data);
        }
    }
    
    public Stack(Object item) {
        top = new Node(item);
        size = 1;
    }

    public Object pop() {
        if (size <=0) throw new EmptyStackException();
        Object ret = top.data;
        top = top.under;
        size--;
        return ret;
    }

    public void push(Object item) {
        Node under = top;
        top = new Node(item);
        top.under = under;
        size++;
    }

    public long getSize() { return size; }
}
