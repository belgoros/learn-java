package com.sca.basic;

public class EnumsWithGenerics<T extends Enum<T>> {

    private Class<T> clazz;

    public EnumsWithGenerics(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    public static void main(String[] args) {
        System.out.println("++++++++++ Enum 'values'");
        for (Locations m : Locations.values()) {
            System.out.println(m);
        }
        System.out.println("+++++++++++++++++++++++++++++++++");

        EnumsWithGenerics<Locations> test = new EnumsWithGenerics<Locations>(Locations.class);
        System.out.println("++++++++++ Marx values from using class:");
        for (Locations m : test.values()) {
            System.out.println(m);
            Class<? extends Vehicle> vehicle = m.getVehicle();
        }
        System.out.println("++++++++++++end++++++++++++");

        Locations location = Locations.getByKind("car");
        try {
            Car car = (Car) location.getVehicle().newInstance();
            car.setWheels(4);
            car.getWheels();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public T[] values() {
        return clazz.getEnumConstants();
    }

    private static enum Marx {
        Harpo, Groucho, Chico;
    }

}
