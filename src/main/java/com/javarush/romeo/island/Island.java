package com.javarush.romeo.island;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.romeo.island.model.resident.ResidentLoaderUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Setter
@Getter
public class Island {
    public static volatile Island island;

    private Integer sizeX;
    private Integer sizeY;
    private Map<String, Integer> residentsOnStart;

    //List<CellPlace> cells = new ArrayList<>();
    CellPlace[][] cells;


    public void init() {
        loadStats();
        createCells();
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

    private void createCells() {
        System.out.print("Create cells: ");
        int countCells = 0;

        cells = new CellPlace[island.sizeX][island.sizeY];

        for(int i = 0; i < island.sizeX; i++) {
            for (int j = 0; j < island.sizeY; j++) {
                cells[i][j]=new CellPlace(i, j);
                countCells++;
            }
        }
        System.out.println(countCells);
    }

    private void spawnResidents() {
        int count = 0;

       //for(CellPlace[] cell : cells) {
        for(int i = 0; i < island.sizeX; i++) {
            for(int j = 0; j < island.sizeY; j++) {
                for (Map.Entry<String, Integer> map : island.residentsOnStart.entrySet()) {
                    for (int y = 0; y < map.getValue(); y++) {
                        cells[i][j].addResident(ResidentLoaderUtil.loadFromJSON(map.getKey()));
                        count++;
                    }
                }

                System.out.println(cells[i][j].getCounterOfResidents().toString());
            }
        }
        System.out.println("Spawned " + count + " residents");
    }
}
