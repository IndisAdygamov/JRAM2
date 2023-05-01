package com.javarush.romeo.island.model.resident;

import com.javarush.romeo.island.CellPlace;
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
    private int limitOnCell;
    private CellPlace cellPlace;

    public Resident(String name, String icon, int speed, double weight, int limitOnCell, CellPlace cellPlace) {
        this.name = name;
        this.icon = icon;
        this.speed = speed;
        this.weight = weight;
        this.limitOnCell = limitOnCell;
        this.cellPlace = cellPlace;
    }

    public abstract Resident reproduce();
}
