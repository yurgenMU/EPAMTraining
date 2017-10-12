package hometask2.t03;

public class Ruler extends Stationery implements MeterDevice {
    private int length;

    public int getLength() {
        return length;
    }

    public Ruler setLength(int length) {
        this.length = length;
        return this;
    }

    @Override
    public double measure(Double pointA, double pointB) {
        return Math.abs(pointA - pointB);
    }

    @Override
    public double measure() {
        return 0;
    }
}
