package com.javarush.romeo.island;

import com.javarush.romeo.island.model.resident.Resident;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CellPlace {
    @Getter
    private int x;
    @Getter
    private int y;
    private List<Resident> residentList = new ArrayList<>();
    private Map<String, Integer> counterOfResidents = new HashMap<>();

    public CellPlace(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addResident(Resident resident) {
        this.residentList.add(resident);

        if(this.counterOfResidents.containsKey(resident.getName())) {
            this.counterOfResidents.put(resident.getName(), this.counterOfResidents.get(resident.getName())+1);
        }
        else {
            this.counterOfResidents.put(resident.getName(), 1);
        }
    }

    public Object getCounterOfResidents() {
        return counterOfResidents;
    }
}
