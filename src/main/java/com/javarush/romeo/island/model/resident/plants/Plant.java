package com.javarush.romeo.island.model.resident.plants;

import com.javarush.romeo.island.model.resident.Resident;
import com.javarush.romeo.island.model.resident.animals.Reproducible;

public class Plant extends Resident {
    @Override
    public Resident reproduce() {
        System.out.println("========== Logs: The Plant reproduces ==========");
        return new Plant();
    }
}
