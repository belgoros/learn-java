package com.sca.patterns.builder;

public class WoodBuilder extends HouseBuilder {

    @Override
    public House createHouse() {
        house = new WoodHouse();
        return house;
    }

    @Override
    public Floor createFloor() {
        floor = new WoodFloor();
        return floor;
    }

    @Override
    public Walls createWalls() {
        walls = new WoodWalls();
        return walls;
    }

    @Override
    public Roof createRoof() {
        roof = new WoodRoof();
        return roof;
    }

}
