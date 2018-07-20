package com.sca.basic;

import java.util.HashMap;
import java.util.Map;

public enum Locations {

    MOTO("moto", Moto.class), TRUCK("truck", Truck.class), CAR("car", Car.class), UKNOWN("UKNOWN", null);

    private static final Map<String, Locations> MAP_BY_KIND_VALUE = new HashMap<String, Locations>();

    /**
     * Initialization of the MAP_BY_CODE Map
     */
    static {
        for (final Locations vehicle : values()) {
            MAP_BY_KIND_VALUE.put(vehicle.kind, vehicle);
        }
    }

    private final String kind;
    private final Class<? extends Vehicle> vehicle;

    private Locations(String kind, Class<? extends Vehicle> vehicle) {
        this.kind = kind;
        this.vehicle = vehicle;
    }

    public static Locations getByKind(final String kind) {
        final Locations vehicle = MAP_BY_KIND_VALUE.get(kind);
        if (vehicle == null) {
            return UKNOWN;
        }
        return vehicle;
    }

    public String getKind() {
        return kind;
    }

    public Class<? extends Vehicle> getVehicle() {
        return vehicle;
    }
}
