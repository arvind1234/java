package com.livingthings;

public class Reptiles extends LivingThings {

    public Reptiles(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println("Reptiles breathe through their skin");
    }

}
