package com.javarush.romeo.island.model.resident.animals.actions.moving;

import com.javarush.romeo.island.Island;
import com.javarush.romeo.island.Sector;
import com.javarush.romeo.island.model.resident.animals.Animal;

import java.util.Random;

public class Moving {

    public static void move(Animal resident) {
        int direction = Direction.selectDirection();
        int x = resident.getSector().getX();
        int y = resident.getSector().getY();
        int newX = x;
        int newY = y;
        int distance = new Random().nextInt(resident.getSpeed());

        switch(direction) {
            case 1 -> { //North - Up
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

        //проверка на возможность перехода в новый сектор
        int limitOnSector = resident.getLimitOnSector();
        int onSector = Island.
                getInstance().
                  getFilledSectors()[newX][newY].
                getCounterOfResidents().
                get(resident.getName());

        if(onSector < limitOnSector) {
            Island.getInstance().getFilledSectors()[x][y].removeResident(resident);
            resident.setSector(new Sector(newX, newY));
            Island.getInstance().getFilledSectors()[newX][newY].addResident(resident);
        }
        else
            System.out.printf("%s - %s not moved from [%s][%s] to [%s][%s], because the limit is full",
                    resident.getId(), resident.getName(), x, y, resident.getSector().getX(), resident.getSector().getY());
        resident.setMovedStatus(true);
    }
}
