package hometask2.t03;

import java.util.Arrays;

public class Pencil extends Stationery implements WriterDevice, Erasable {

    public Pencil(Color color) {
        super(color);
    }

    @Override
    public void erase(char[] c) {

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
