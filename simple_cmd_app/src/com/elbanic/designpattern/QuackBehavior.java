package com.elbanic.designpattern;

public interface QuackBehavior {
    public void quack();
}



class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack Quack");
    }

}



class NoQuack implements QuackBehavior {
    @Override
    public void quack(){
        System.out.println("Qick Qick.");
    }
}



class MuteQuack implements QuackBehavior {
    @Override
    public void quack(){
        System.out.println("Quiet");
    }
}
