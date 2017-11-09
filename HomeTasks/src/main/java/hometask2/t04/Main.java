package hometask2.t04;

import hometask2.t01.Pen;
import hometask2.t03.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Comparator<Stationery> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Stationery> priceComparator = (o1, o2) -> {
            if (o1.getPrice() > o2.getPrice())
                return 1;
            else if (o1.getPrice() < o2.getPrice())
                return -1;
            return 0;
        };
        Comparator<Stationery> multipleComparator = priceComparator.thenComparing(priceComparator);
        List<Stationery> stationeryList = new ArrayList<>();
        stationeryList.add(new Pencil(Stationery.Color.PLAIN, 40));
        stationeryList.add(new Eraser(15));
        stationeryList.add(new Ruler(Stationery.Color.RED, 30, 20));
        stationeryList.add(new Pen(Stationery.Color.BLUE, 42));
        Collections.sort(stationeryList, priceComparator);
        System.out.println(stationeryList);
        Collections.sort(stationeryList, nameComparator);
        System.out.println(stationeryList);
        Collections.sort(stationeryList, multipleComparator);
        System.out.println(stationeryList);

    }

}
