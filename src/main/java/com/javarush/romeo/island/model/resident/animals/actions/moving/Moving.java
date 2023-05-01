package com.javarush.romeo.island.model.resident.animals.actions.moving;

import com.javarush.romeo.island.CellPlace;
import com.javarush.romeo.island.Island;
import com.javarush.romeo.island.model.resident.Resident;

import java.util.Random;

public class Moving {

    void move(Resident resident) {
        int direction = Direction.selectDirection();
        int x = resident.getCellPlace().getX();
        int y = resident.getCellPlace().getY();
        int newX = x;
        int newY = y;
        int distance = new Random().nextInt(resident.getSpeed());

        switch(direction) {
            case 1 -> { //North - Up
//                if(y == 0) {
//                    distance = 0;
//                }
//                else if(y == 1) {
//                    distance = distance > 1 ? 1 : distance;
//                }
//                else if (y == 2) {
//                    distance = distance > 2 ? 2 : distance;
//                }
//                else if (y == 3) {
//                    distance = distance > 3 ? 3 : distance;
//                }
//                else if (y >= 4) {
//                    distance = distance > 4 ? 4 : distance;
//                }
                distance = Math.min(distance, y);
                newY -= distance;
            }
            case 2 -> { //East - Right
                distance = Math.min(distance,(Island.getInstance().getSizeX() - x));
                newX += distance;
            }

            case 3 -> { //South - Down
                distance = Math.min(distance, (Island.getInstance().getSizeY() - y));
                newY += distance;
            }
            case 4 -> { //West - Left
                distance = Math.min(distance, x);
                newX -= distance;
            }
            case 5 -> { //Northeast

            }
            case 6 -> { //Southeast

            }
            case 7 -> { //Southwest

            }
            case 8 -> { //Northwest

            }
            default -> {
            }
        }
        //Island.getInstance().getCells()[newX][newY].getResidentList().

    }
}
