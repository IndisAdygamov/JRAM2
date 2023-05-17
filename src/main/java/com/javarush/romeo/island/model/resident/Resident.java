package com.javarush.romeo.island.model.resident;

import com.javarush.romeo.island.Sector;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Resident {
    private String name;
    private String icon;
    private int speed;
    private double weight;
    private int limitOnSector;
    private Sector sector;

    public Resident(String name, String icon, int speed, double weight, int limitOnSector, Sector sector) {
        this.name = name;
        this.icon = icon;
        this.speed = speed;
        this.weight = weight;
        this.limitOnSector = limitOnSector;
        this.sector = sector;
    }

    public abstract Resident reproduce();
}
