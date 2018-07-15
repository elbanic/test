package com.elbanic.designpattern;

public class StrategyImplement02 extends Strategy {
    public StrategyImplement02(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display(){
        System.out.println("StrategyImplement02.");
    }
}