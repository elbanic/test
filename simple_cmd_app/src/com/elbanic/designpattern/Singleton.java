package com.elbanic.designpattern;

public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("call Singleton constructor");
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void print () {
        System.out.println("instance hashCode > " + instance.hashCode());
    }
}

