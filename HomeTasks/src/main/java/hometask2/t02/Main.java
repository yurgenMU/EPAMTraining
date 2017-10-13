package hometask2.t02;

import hometask2.t01.Pen;
import hometask2.t03.Pencil;
import hometask2.t03.Ruler;
import hometask2.t03.Stationery;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Iosif Stalin");
        employee1.getStationeryList().add(new Pen(Stationery.Color.BLUE).setPrice(40));
        employee1.getStationeryList().add(new Pencil(Stationery.Color.PLAIN).setPrice(35));
        employee1.getStationeryList().add(new Ruler().setColor(Stationery.Color.YELLOW).setPrice(15));
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
