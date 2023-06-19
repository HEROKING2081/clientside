package ru.clientside.model;

import java.util.Objects;

public class RailwayCarriage {

    private int number;

    private int loadCapacity;

    private int wagonWeight;

    private int axialLoad;

    private String type;

    private String location;

    public RailwayCarriage() {}

    public RailwayCarriage(int number, int loadCapacity, int wagonWeight, int axialLoad, String type, String location) {
        this.number = number;
        this.loadCapacity = loadCapacity;
        this.wagonWeight = wagonWeight;
        this.axialLoad = axialLoad;
        this.type = type;
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getWagonWeight() {
        return wagonWeight;
    }

    public void setWagonWeight(int wagonWeight) {
        this.wagonWeight = wagonWeight;
    }

    public int getAxialLoad() {
        return axialLoad;
    }

    public void setAxialLoad(int axialLoad) {
        this.axialLoad = axialLoad;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RailwayCarriage that = (RailwayCarriage) o;
        return number == that.number && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }
}
