package com.javarush.romeo.island;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        Island island = Island.getInstance();
        island.init();
        for (int i = 0; i < 2; i++) {
            System.out.println("Step " + i+1);
            island.islandLive();
        }
    }
}