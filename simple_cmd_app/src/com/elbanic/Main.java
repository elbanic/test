package com.elbanic;

import com.elbanic.algorithms.*;
import com.elbanic.designpattern.*;
import com.elbanic.util.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //Singleton
        System.out.println("----- Singleton Test -----");
        Singleton singleton = Singleton.getInstance();


        //Factory
        System.out.println();
        System.out.println("----- Factory Test -----");
        Factory factory = new Factory();
        Product product01 = Factory.getProduct("ticket", "Travel", 500000);
        Product product02 = Factory.getProduct("computer", "MacBook", 1000000);
        System.out.println(String.format("%s => %s", product01.toString(), product01.getType()));
        System.out.println(String.format("%s => %s", product02.toString(), product02.getType()));


        //Strategy
        System.out.println();
        System.out.println("----- Strategy Test -----");
        StrategyImplement01 strategyImplement01 = new StrategyImplement01();
        StrategyImplement02 strategyImplement02 = new StrategyImplement02();

        strategyImplement01.display();
        strategyImplement01.doFly();
        strategyImplement01.doQuack();

        strategyImplement02.display();
        strategyImplement02.doFly();
        strategyImplement02.doQuack();


        //LinkedList
        System.out.println();
        System.out.println("----- LinkedList Test -----");
        LinkedList linkedList = new LinkedList();
        People p1 = new People("p1");
        People p2 = new People("p2");
        People p3 = new People("p3");

        linkedList.add(p1);
        linkedList.add(p2);
        linkedList.add(p3);
        linkedList.add(p2);

        for (int i=0; i<linkedList.size(); i++)
            ((People) linkedList.get(i)).printName();

        linkedList.remove(3);

        for (int i=0; i<linkedList.size(); i++)
            ((People) linkedList.get(i)).printName();


        //BinaryTree
        System.out.println();
        System.out.println("----- BinaryTree Test -----");
        BinaryTree bt = new BinaryTree();
        People p4 = new People("p4");
        People p5 = new People("p5");
        People p6 = new People("p6");
        People p7 = new People("p7");

        p1.setAge(10);
        p2.setAge(45);
        p3.setAge(20);
        p4.setAge(5);
        p5.setAge(7);
        p6.setAge(61);
        p7.setAge(88);

        bt.add(p1, p1.getAge());
        bt.add(p2, p2.getAge());
        bt.add(p3, p3.getAge());
        bt.add(p4, p4.getAge());
        bt.add(p5, p5.getAge());
        bt.add(p6, p6.getAge());
        bt.add(p7, p7.getAge());

        Node root = bt.getRoot();
        System.out.print("InOrder : ");
        bt.traverseInOrder(root); System.out.println();
        System.out.print("PreOrder : ");
        bt.traversePreOrder(root); System.out.println();
        System.out.print("PostOrder : ");
        bt.traversePostOrder(root); System.out.println();


        //Breadth first search
        System.out.println();
        System.out.println("----- Breadth Test -----");
        BFS bfs = new BFS(bt.getRoot(), new Node(p6, p6.getAge()));
        bfs.doSearch();

        //Depth first search
        System.out.println();
        System.out.println("----- Depth Test -----");
        DFS dfs = new DFS(bt.getRoot(), new Node(p7,p7.getAge()));
        dfs.doSearch();


        //Trie
        System.out.println();
        System.out.println("----- Trie Test -----");
        Trie trie = new Trie();

        trie.insert("hello");
        trie.insert("worl");
        trie.insert("world");
        if (trie.search("hello"))
            System.out.println("hello is in Tire");
        if (trie.search("world"))
            System.out.println("world is in Tire");


        //Stack
        System.out.println();
        System.out.println("----- Stack Test -----");
        Stack stack = new Stack(1);
        stack.push(10);
        stack.push(5);
        stack.push(20);
        stack.push(25);

        System.out.print("stack poped : ");
        long stackSize = stack.getSize();
        for (int i=0; i<stackSize; i++) {
            System.out.print(String.format("%s%s", stack.pop(), " "));
        }
        System.out.println();


        //Queue
        System.out.println();
        System.out.println("----- Queue Test -----");
        Queue queue = new Queue(100);
        queue.enqueue(10);
        queue.enqueue(511);
        queue.enqueue(20);
        System.out.print("queue dequeued : ");
        long queueSize = queue.getSize();
        for (int i=0; i<queueSize; i++) {
            System.out.print(String.format("%s%s", queue.dequeue(), " "));
        }
        System.out.println();


        //Vector
        System.out.println();
        System.out.println("----- Vector Test -----");
        Vector vector = new Vector(1);
        vector.add(5);
        vector.add(15);
        vector.add(11);
        vector.add(3);
        vector.add(6);
        vector.add(18);
        vector.add(12);

        System.out.print("first result : ");
        for (int i=0; i<vector.getSize(); i++)
            System.out.print(String.format("%s%s", vector.get(i), " "));
        System.out.println();

        vector.remove(5);
        vector.remove(2);

        System.out.print("Second result : ");
        for (int i=0; i<vector.getSize(); i++)
            System.out.print(String.format("%s%s", vector.get(i), " "));
        System.out.println();


        //Map
        System.out.println();
        System.out.println("----- Map Test -----");
        String str = "aabbcdefggggg";

        Map<Character, Integer> map = new Map<Character, Integer>();

        for (int i=0; i<str.length(); i++) {
            try{
                int cnt = (int)map.get(str.charAt(i));
                map.put(str.charAt(i), cnt+1);
            }catch(NoSuchElementException e){
                map.put(str.charAt(i), 1);
            }
        }

        for (Character c : map.getKeys())
            System.out.println(String.format("%s, %s", c, map.get(c)));
        System.out.println();


        //HashMap
        System.out.println();
        System.out.println("----- HashMap Test -----");
        String str2 = "14231112345555";

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

        int a =0;
        for (int i=0; i<str2.length(); i++) {
            if (hashMap.get(str2.charAt(i)) != null) {
                int cnt = (int)hashMap.get(str2.charAt(i));
                hashMap.put(str2.charAt(i), cnt+1);
            } else {
                hashMap.put(str2.charAt(i), 1);
            }
        }

        for (Character c : hashMap.getKeys())
            System.out.println(String.format("%s, %s", c, hashMap.get(c)));
        System.out.println();

        hashMap.remove('1');
        hashMap.remove('5');
        for (Character c : hashMap.getKeys())
            System.out.println(String.format("%s, %s", c, hashMap.get(c)));
        System.out.println();


        //BinarySearch
        System.out.println();
        System.out.println("----- BinarySearch Test -----");

        ArrayList<Integer> testArray3 = new ArrayList<>();
        for (int i=0; i<12; i++) {
            Random random = new Random();
            testArray3.add(random.nextInt(100));
        }

        BinarySearch binarySearch = new BinarySearch();
        int searched = binarySearch.binarySearch(testArray3, 0, testArray3.size()-1, testArray3.get(2));
        System.out.println(searched);


        //MergeSort
        System.out.println();
        System.out.println("----- MergeSort Test -----");

        ArrayList<Integer> testArray = new ArrayList<>();
        for (int i=0; i<12; i++) {
            Random random = new Random();
            testArray.add(random.nextInt(100));
        }

        System.out.println("\n Non-sorted >> ");
        for (Integer item : testArray){
            System.out.print(String.format("%s%s", item.toString(), " "));
        }
        System.out.println();

        MergeSort mergeSort = new MergeSort(testArray);
        mergeSort.mergeSort(testArray, 0, testArray.size()-1);


        System.out.println("\n MergeSorted >> ");
        for (Integer item : testArray){
            System.out.print(String.format("%s%s", item.toString(), " "));
        }
        System.out.println();


        //QuickSort
        System.out.println();
        System.out.println("----- QuickSort Test -----");

        ArrayList<Integer> testArray2 = new ArrayList<>();
        for (int i=0; i<12; i++) {
            Random random = new Random();
            testArray2.add(random.nextInt(100));
        }

        System.out.println("\n Non-sorted >> ");
        for (Integer item : testArray2){
            System.out.print(String.format("%s%s", item.toString(), " "));
        }
        System.out.println();

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(testArray2, 0, testArray2.size()-1);

        System.out.println("\n QuickSorted >> ");
        for (Integer item : testArray2){
            System.out.print(String.format("%s%s", item.toString(), " "));
        }
        System.out.println();


    }
}