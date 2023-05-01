package com.javarush.romeo.island.model.resident.animals.actions.moving;

import java.util.Random;

public class Direction {

    static int selectDirection() {
        //return new Random().nextInt(Direct.values().length);
        return new Random().nextInt(4);
    }

    private enum Direct {
        NORTH,
        EAST,
        SOUTH,
        WEST,
        NORTH_EAST,
        SOUTHEAST,
        SOUTHWEST,
        NORTHWEST
    }
}
