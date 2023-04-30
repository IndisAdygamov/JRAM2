package com.javarush.romeo.island.model.resident.animals.predators;

import com.javarush.romeo.island.model.resident.Resident;

public class Wolf extends Predator {
    @Override
    public void eat() {
        System.out.printf("========== Logs: %s - eats ==========", this.getName());
    }

    @Override
    public void move() {
        System.out.printf("========== Logs: %s - moves ==========", this.getName());
    }

    @Override
    public Resident reproduce() {
        System.out.printf("========== Logs: %s - reproduces ==========", this.getName());
        return new Wolf();
    }
}
