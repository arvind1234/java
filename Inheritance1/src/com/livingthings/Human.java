package com.livingthings;

public class Human extends LivingThings{

    public static final int numberOfLegs = 2;
    public Human(String name) {
        // invoke the parent constructor
        super(name);
    }

    public void breathe() {
        System.out.println("Current human is " + this.getName() + ". Human breathe with their nose");
    }

}
