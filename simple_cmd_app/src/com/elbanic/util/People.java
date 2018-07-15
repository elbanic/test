package com.elbanic.util;

public class People {
    private String name;
    private int age;
    public People(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }
    public void printName () {
        System.out.println(name);
    }
}
