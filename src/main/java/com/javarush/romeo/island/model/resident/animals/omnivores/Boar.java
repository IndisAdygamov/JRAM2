package com.javarush.romeo.island.model.resident.animals.omnivores;

import com.javarush.romeo.island.model.resident.Resident;

public class Boar extends Omnivore {
    @Override
    public void eat() {
        System.out.printf("========== Logs: %s - eats ==========", this.getName());
    }

    @Override
    public Resident reproduce() {
        System.out.printf("========== Logs: %s - reproduces ==========", this.getName());
        return new Boar();
    }
}
