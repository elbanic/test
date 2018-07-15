package com.elbanic.algorithms;

import com.elbanic.util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    Node start;
    Node goal;
    public BFS(Node start, Node goal){
        this.start = start;
        this.goal = goal;
    }

    public boolean doSearch(){
        if(this.start.equals(goal)){
            System.out.println("Goal Node Found at 0 depth");
            System.out.println(start);
        }
        LinkedList<Node> queue = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        queue.add(this.start);
        explored.add(start);

        while(!queue.isEmpty()){
            Node current = queue.getLast();
            if(current.equals(this.goal)) {
                for (Node node : explored) {
                    System.out.print(String.format("%d ",node.getValue()));
                }
                System.out.println(current.getValue());
                System.out.println(String.format("Goal node found at %d depth", queue.size()));
                return true;
            }
            else{
                if(current.getChildren().isEmpty())
                    return false;
                else
                    queue.addAll(current.getChildren());
            }
            explored.add(current);
        }
        return false;
    }
}



