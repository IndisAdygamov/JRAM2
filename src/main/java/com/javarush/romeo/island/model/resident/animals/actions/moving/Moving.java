package com.javarush.romeo.island.model.resident.animals.actions.moving;

import com.javarush.romeo.island.model.resident.Resident;

public class Moving {

    void move(Resident resident) {
        int direction = Direction.selectDirection();

    }

    private int checkDirection() {
        //написать логику проверки направления, или зачем?
        return 0;
    }

    private int checkDistance() {
            //написать логику проверки дистанции
        return 0;
    }


}
