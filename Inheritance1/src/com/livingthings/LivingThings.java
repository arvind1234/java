package com.livingthings;

public abstract class LivingThings {

    private String name;
    public static String name1;

//    public LivingThings() {
//        
//    }

    public LivingThings(String name) {
        this.name = name;
        name1 = name;
    }

    public String getName() {
        return name;
    }

    
    public abstract void breathe();

}
