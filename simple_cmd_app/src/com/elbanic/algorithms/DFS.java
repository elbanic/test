package com.elbanic.algorithms;

import com.elbanic.util.BinaryTree;
import com.elbanic.util.Node;

import java.util.ArrayList;
import java.util.Stack;


public class DFS {
    Node start;
    Node goal;
    public DFS(Node start, Node goal){
        this.start = start;
        this.goal = goal;
    }

    public boolean doSearch(){
        if(this.start.equals(goal)){
            System.out.println("Goal Node Found at 0 depth");
            System.out.println(start);
        }
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> visitedNodes = new ArrayList<>();
        stack.add(start);
        while(!stack.isEmpty()){
            Node current = stack.pop();
            if(current.equals(goal)){
                for (Node node : visitedNodes) {
                    System.out.print(String.format("%d ",node.getValue()));
                }
                System.out.println(current.getValue());
                System.out.println(String.format("Goal node found at %d depth", stack.size()));
                return true;
            }
            else {
                visitedNodes.add(current);
                stack.addAll(current.getChildren());
            }
        }
        return false;
    }
}
