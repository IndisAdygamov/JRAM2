package com.javarush.romeo.island.model.resident;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.romeo.island.model.resident.animals.herbivores.*;
import com.javarush.romeo.island.model.resident.animals.predators.*;
import com.javarush.romeo.island.model.resident.animals.omnivores.Boar;
import com.javarush.romeo.island.model.resident.plants.Plant;

import java.io.File;
import java.io.IOException;

public class ResidentLoaderUtil {
    public static Resident loadFromJSON(String residentName) {
        Resident result;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            result = switch (residentName) {
                case "Wolf" -> objectMapper.readValue(
                        new File("src/main/resources/statsWolf.json"), Wolf.class);
                case "Snake" -> objectMapper.readValue(
                        new File("src/main/resources/statsSnake.json"), Snake.class);
                case "Fox" -> objectMapper.readValue(
                        new File("src/main/resources/statsFox.json"), Fox.class);
                case "Bear" -> objectMapper.readValue(
                        new File("src/main/resources/statsBear.json"), Bear.class);
                case "Eagle" -> objectMapper.readValue(
                        new File("src/main/resources/statsEagle.json"), Eagle.class);
                case "Horse" -> objectMapper.readValue(
                        new File("src/main/resources/statsHorse.json"), Horse.class);
                case "Deer" -> objectMapper.readValue(
                        new File("src/main/resources/statsDeer.json"), Deer.class);
                case "Rabbit" -> objectMapper.readValue(
                        new File("src/main/resources/statsRabbit.json"), Rabbit.class);
                case "Mouse" -> objectMapper.readValue(
                        new File("src/main/resources/statsMouse.json"), Mouse.class);
                case "Goat" -> objectMapper.readValue(
                        new File("src/main/resources/statsGoat.json"), Goat.class);
                case "Sheep" -> objectMapper.readValue(
                        new File("src/main/resources/statsSheep.json"), Sheep.class);
                case "Boar" -> objectMapper.readValue(
                        new File("src/main/resources/statsBoar.json"), Boar.class);
                case "Buffalo" -> objectMapper.readValue(
                        new File("src/main/resources/statsBuffalo.json"), Buffalo.class);
                case "Duck" -> objectMapper.readValue(
                        new File("src/main/resources/statsDuck.json"), Duck.class);
                case "Caterpillar" -> objectMapper.readValue(
                        new File("src/main/resources/statsCaterpillar.json"), Caterpillar.class);
                default -> objectMapper.readValue(
                        new File("src/main/resources/statsPlant.json"), Plant.class);
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
