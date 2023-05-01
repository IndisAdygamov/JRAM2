package com.javarush.romeo.island;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        Island island = Island.getInstance();
        island.init();

    }
}