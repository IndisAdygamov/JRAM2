package com.javarush.romeo.island.model.resident.animals.actions.moving;

import java.util.Random;

public class Direction {

    static int selectDirection() {
        return new Random().nextInt(Direct.values().length);
    }

    private enum Direct {
        NORTH,
        NORTH_EAST,
        EAST,
        SOUTHEAST,
        SOUTH,
        SOUTHWEST,
        WEST,
        NORTHWEST
    }
}
