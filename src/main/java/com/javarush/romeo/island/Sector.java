package com.javarush.romeo.island;

import com.javarush.romeo.island.model.resident.Resident;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class Sector {
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;
    @Getter
    private List<Resident> residentList = new ArrayList<>();
    private Map<String, Integer> counterOfResidents = new HashMap<>();

    public Sector(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
