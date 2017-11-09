package hometask2.t03;

public class Ruler extends Stationery implements MeterDevice {
    private final int length;

    public Ruler(Color color, double price, int length) {
        super(color, price);
        this.length = length;
    }


    public int getLength() {
        return length;
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
