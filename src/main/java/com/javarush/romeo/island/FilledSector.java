package com.javarush.romeo.island;

import com.javarush.romeo.island.model.resident.Resident;
import com.javarush.romeo.island.model.resident.animals.Animal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FilledSector extends Sector {

    @Getter
    private List<Resident> residentList = new ArrayList<>();
    private Map<String, Integer> counterOfResidents = new HashMap<>();

    public FilledSector(int x, int y) {
        super(x,y);
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

    public void removeResident(Resident resident) {
        residentList.remove(resident);
        this.counterOfResidents.put(resident.getName(), this.counterOfResidents.get(resident.getName())-1);
    }

    public Map<String,Integer> getCounterOfResidents() {
        return counterOfResidents;
    }

    public void sectorLive() {
        for (Resident resident: residentList) {
            ((Animal)(resident)).move();
        }
    }

    public void sectorPrintShortStatus() {
        for (Map.Entry<String, Integer> entry: counterOfResidents.entrySet()) {
            System.out.printf("%s - %s", entry.getKey(), entry.getValue());
        }
    }
}
