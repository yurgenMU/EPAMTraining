package hometask2.t02;

import hometask2.t03.Stationery;

class Employee {
    private String name;
    private StationeryList<Stationery> stationeryList;

    Employee(String name) {
        this.name = name;
        stationeryList = new StationeryList<>();
    }

    String getName() {
        return name;
    }

    StationeryList<Stationery> getStationeryList() {
        return stationeryList;
    }
}
