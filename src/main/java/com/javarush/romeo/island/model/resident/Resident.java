package com.javarush.romeo.island.model.resident;

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

    public Resident(String name, String icon, int speed, double weight, int limitOnCell) {
        this.name = name;
        this.icon = icon;
        this.speed = speed;
        this.weight = weight;
        this.limitOnCell = limitOnCell;
    }
}