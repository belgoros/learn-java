package com.sca.patterns.builder;

public class HouseClient {

    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();
        HouseBuilder woodBuilder = new WoodBuilder();
        // Build a wooden house
        House woodHouse = director.constructHouse(woodBuilder);
        System.out.println("----------------------------");

        //Build a brick house
        BrickBuilder brickBuilder = new BrickBuilder();
        House brickHouse = director.constructHouse(brickBuilder);

    }

}
