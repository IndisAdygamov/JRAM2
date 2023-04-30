package com.javarush.romeo.island;

import com.javarush.romeo.island.model.resident.Resident;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CellPlace {
    private int x;
    private int y;
    List<Resident> residentList = new ArrayList<>();

    public CellPlace(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
