package hometask2.t03;

public class Protractor extends Stationery implements MeterDevice {
    public Protractor(Color color, double price) {
        super(color, price);
    }

    @Override
    public double measure(Double pointA, double pointB) {
        return 0;
    }

    @Override
    public double measure() {
        return 0;
    }
}
