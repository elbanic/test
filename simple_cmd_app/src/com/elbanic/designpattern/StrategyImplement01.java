package com.elbanic.designpattern;

public class StrategyImplement01 extends Strategy {
    public StrategyImplement01(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new NoQuack();
    }

    @Override
    public void display(){ System.out.println("StrategyImplement01."); }
}