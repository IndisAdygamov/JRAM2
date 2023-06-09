package com.javarush.romeo.island;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.romeo.island.model.resident.Resident;
import com.javarush.romeo.island.model.resident.ResidentLoaderUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


@Setter
@Getter
public class Island {
    public static volatile Island island;

    private Integer sizeX;
    private Integer sizeY;
    private Map<String, Integer> residentsOnStart;

    FilledSector[][] filledSectors;

    public void init() {
        loadStats();
        createSectors();
        spawnResidents();
    }

    private Island() {
    }

    public static Island getInstance() {
        Island result = island;

        if(result != null) {
            return result;
        }
        synchronized (Island.class) {
            if(island == null) {
                island = new Island();
            }
            return island;
        }
    }

    private void loadStats() {
        System.out.println("Load stats from file: statsIsland.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            island = objectMapper.readValue(
                    new File("src/main/resources/statsIsland.json"), Island.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Island has size: x = %s, y = %s \n", island.sizeX, island.sizeY);
    }

    private void createSectors() {
        System.out.print("Create cells: ");
        int countCells = 0;

        filledSectors = new FilledSector[island.sizeX][island.sizeY];

        for(int i = 0; i < island.sizeX; i++) {
            for (int j = 0; j < island.sizeY; j++) {
                filledSectors[i][j]=new FilledSector(i, j);
                countCells++;
            }
        }
        System.out.println(countCells);
    }

    private void spawnResidents() {
        int count = 0;

        for(int i = 0; i < island.sizeX; i++) {
            for(int j = 0; j < island.sizeY; j++) {
                for (Map.Entry<String, Integer> map : island.residentsOnStart.entrySet()) {
                    for (int y = 0; y < map.getValue(); y++) {
                        Resident resident = ResidentLoaderUtil.loadFromJSON(map.getKey());
                        resident.setSector(new Sector(i,j));
                        filledSectors[i][j].addResident(resident);
                        count++;
                    }
                }

                System.out.println(filledSectors[i][j].getCounterOfResidents().toString());
            }
        }
        System.out.println("Spawned " + count + " residents");
    }

    void islandLive() {
        Arrays.stream(filledSectors).forEach(a-> Arrays.stream(a).toList().forEach(FilledSector::sectorLive));
    }

    public void islandPrintShortStatus() {
        for (int i = 0; i < island.sizeX; i++) {
            for (int j = 0; j < island.sizeY; j++) {
                filledSectors[i][j].sectorPrintShortStatus();
            }
        }
    }
}
