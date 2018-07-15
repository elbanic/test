package com.elbanic.designpattern;

public abstract class Product {
    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }
    public String toString() {
        return "product name : " + getName() + ", price :" + getPrice();
    }

    public abstract String getType();
}

class Computer extends Product {
    public Computer(String name, int price) {
        super(name, price);
    }
    @Override
    public String getType() { return "Computer"; }
}


class Ticket extends Product {
    public Ticket(String name, int price) {
        super(name, price);
    }
    @Override
    public String getType() { return "Ticket"; }
}