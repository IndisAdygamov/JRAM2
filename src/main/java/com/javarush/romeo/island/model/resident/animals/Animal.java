package com.javarush.romeo.island.model.resident.animals;

import com.javarush.romeo.island.model.resident.Resident;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public abstract class Animal extends Resident implements Movable, Eatable, Reproducible {
    private int satiety;
    private int foodThresholdForSatiate;

    private Map<String, Integer> footMap;

    @Override
    public String toString() {
        return "Animal{" +
                "satiety=" + satiety +
                ", foodForSatiate=" + foodThresholdForSatiate +
                ", mapEating=" + footMap +
                "} " + super.toString();
    }
}
