package com.elbanic.designpattern;


public interface FlyBehavior {

    public void fly();

}

class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Fly!!");
    }
}

class FlyNoWay implements FlyBehavior{

    @Override
    public void fly(){
        System.out.println("Cannot Fly!!");
    }
}