package com.javarush.romeo.island.model.resident.animals.predators;

public class Wolf extends Predator {
    @Override
    public void eatable() {
        System.out.printf("========== Logs: %s - eats ==========", this.getName());
    }

    @Override
    public void move() {
        System.out.printf("========== Logs: %s - moves ==========", this.getName());
    }

    @Override
    public void reproduce() {
        System.out.printf("========== Logs: %s - reproduces ==========", this.getName());
    }
}
