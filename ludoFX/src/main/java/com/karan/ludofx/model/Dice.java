package com.karan.ludofx.model;

import java.util.random.RandomGenerator;

public class Dice {
    private final RandomGenerator rnd;
    public Dice() {
        this.rnd = RandomGenerator.getDefault();
    }
    public int roll(){
        return rnd.nextInt(6)+1;
    }
}
