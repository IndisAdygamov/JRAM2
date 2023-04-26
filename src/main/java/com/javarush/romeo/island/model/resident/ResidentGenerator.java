package com.javarush.romeo.island.model.resident;

public abstract class ResidentGenerator {

    public void reproduceResident() {
        Resident resident = createResident();
        resident.reproduce();
    }

    public abstract Resident createResident();
}
