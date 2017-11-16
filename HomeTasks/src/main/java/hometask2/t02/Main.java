package hometask2.t02;

import hometask2.t01.Pen;
import hometask2.t03.Pencil;
import hometask2.t03.Ruler;
import hometask2.t03.Stationery;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Igor Nikolaev");
        employee1.getStationeryList().add(new Pen(Stationery.Color.BLUE, 40));
        employee1.getStationeryList().add(new Pencil(Stationery.Color.PLAIN, 32));
        employee1.getStationeryList().add(new Ruler(Stationery.Color.YELLOW, 15, 20));
        System.out.println(employee1.getName() + " " + findAveragePrice(employee1.getStationeryList()));
    }

    public static double findAveragePrice(StationeryList<Stationery> stationeryList) {
        double sum = 0;
        for (int i = 0; i < stationeryList.getSize(); i++) {
            sum += stationeryList.get(i).getPrice();
        }
        return sum;
    }
}
