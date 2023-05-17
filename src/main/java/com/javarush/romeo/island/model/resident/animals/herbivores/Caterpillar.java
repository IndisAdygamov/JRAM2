package com.javarush.romeo.island.model.resident.animals.herbivores;

import com.javarush.romeo.island.model.resident.Resident;

public class Caterpillar extends Herbivore {
    @Override
    public void eat() {
        System.out.printf("========== Logs: %s - eats ==========", this.getName());
    }

    @Override
    public Resident reproduce() {
        System.out.printf("========== Logs: %s - reproduces ==========", this.getName());
        return new Caterpillar();
    }
}
