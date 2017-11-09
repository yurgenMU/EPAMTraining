package hometask2.t01;

import hometask2.t03.Stationery;
import hometask2.t03.WriterDevice;

import java.util.Arrays;

public class Pen extends Stationery implements WriterDevice {
    private final Color color;

    public Pen(Color color, double price) {
        super(price);
        this.color = color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return color != null ? color.equals(pen.color) : pen.color == null;
    }

    @Override
    public int hashCode() {
        return color != null ? color.hashCode() : 0;
    }

    @Override
    public void write(char c) {
        System.out.println(c);
    }

    @Override
    public void write(char[] c) {
        System.out.println(Arrays.toString(c));
    }
}
