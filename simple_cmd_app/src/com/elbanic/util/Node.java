package com.elbanic.util;

import java.util.ArrayList;

public class Node {
    int value;
    Object data;
    Node left;
    Node right;
    public Node(Object data, int value) {
        this.data = data;
        this.value = value;
        right = null;
        left = null;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node)obj;
        return value==node.value && data.equals(node.data);
    }

    public ArrayList<Node> getChildren() {
        ArrayList<Node> children = new ArrayList<>();
        children.add(left);
        children.add(right);
        return children;
    }

    public int getValue() {
        return value;
    }
}