package com.javarush.romeo.island.model.resident.animals;

import com.javarush.romeo.island.model.resident.Resident;
import com.javarush.romeo.island.model.resident.animals.actions.moving.Moving;
import lombok.*;

import java.util.Map;

@Getter
@Setter
public abstract class Animal extends Resident{
    private int satiety;
    private int foodThresholdForSatiate;

    private Map<String, Integer> footMap;
    private int id;
    private static int count = 0;

    public boolean isMovedStatus() {
        return movedStatus;
    }

    public void setMovedStatus(boolean movedStatus) {
        this.movedStatus = movedStatus;
    }

    private boolean movedStatus = false;
    public Animal(){
        super();
        count++;
        this.id = count;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "satiety=" + satiety +
                ", foodForSatiate=" + foodThresholdForSatiate +
                ", mapEating=" + footMap +
                "} " + super.toString();
    }
    public void move() {
        Moving.move(this);
        System.out.printf("%s - %s move from xxxxxx",this.id,this.getName());
    }
    public abstract void eat();
}
