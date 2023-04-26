package com.javarush.romeo.island;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.romeo.island.model.resident.Resident;
import com.javarush.romeo.island.model.resident.animals.predators.Wolf;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Resident wolf;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            wolf = objectMapper.readValue(
                    new File("src/main/resources/parametersForWolf.json"), Wolf.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(wolf);
    }
}