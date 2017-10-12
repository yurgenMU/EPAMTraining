package hometask2.t03;

import hometask2.t01.Pen;
import hometask2.t02.StationeryList;

public class NeophyteSet<T> {
    private StationeryList<Stationery> stationeryList;


    public NeophyteSet() {
        this.stationeryList = new StationeryList<Stationery>();
        stationeryList.add(new Pencil(Stationery.Color.PLAIN).setPrice(40));
        stationeryList.add(new Eraser().setPrice(15));
        stationeryList.add(new Ruler().setLength(30).setColor(Stationery.Color.RED).setPrice(20));
        stationeryList.add(new Pen(Stationery.Color.BLUE).setPrice(42));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NeophyteSet<?> that = (NeophyteSet<?>) o;

        return stationeryList != null ? stationeryList.equals(that.stationeryList) : that.stationeryList == null;
    }

    @Override
    public int hashCode() {
        return stationeryList != null ? stationeryList.hashCode() : 0;
    }

    public StationeryList<Stationery> getStationeryList() {

        return stationeryList;
    }

    public void setStationeryList(StationeryList<Stationery> stationeryList) {
        this.stationeryList = stationeryList;
    }
}
