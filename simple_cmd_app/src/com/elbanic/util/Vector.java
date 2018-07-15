package com.elbanic.util;

public class Vector {

    Node[] vector;
    private int size;
    private class Node{
        private Object data;
        public Node(Object input) { this.data = input; }
        public String toString(){ return String.valueOf(this.data); }
    }

    public Vector(Object input) {
        size = 1;
        vector = new Node[size];
        vector[0] = new Node(input);
    }

    public Object get(int i) { return vector[i].data; }

    public void add(Object input) {
        Node[] temp = vector;
        vector = new Node[size+1];
        int i = 0;
        for(i=0; i<size; i++) {
            vector[i] = temp[i];
        }
        size++;
        vector[i] = new Node(input);
    }

    public Object remove(int i) {
        Node[] temp = vector;
        Object returnData = vector[i];
        vector = new Node[size-1];
        int j = 0;
        for(j=0; j<size; j++) {
            if (j<i)
                vector[j] = temp[j];
            else if (j>i)
                vector[j-1] = temp[j];
        }
        size--;
        return returnData;
    }

    public int getSize(){ return size; }
}
