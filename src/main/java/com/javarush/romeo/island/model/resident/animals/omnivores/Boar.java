package com.javarush.romeo.island.model.resident.animals.omnivores;

public class Boar extends Omnivore {
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
