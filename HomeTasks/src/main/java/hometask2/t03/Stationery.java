package hometask2.t03;

public class Stationery implements Comparable<Stationery> {
    private double price;
    private Color color;
    private String name;


    public Stationery() {

    }

    public Stationery(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "price=" + price +
                ", color=" + color +
                '}';
    }


    public Color getColor() {
        return color;
    }

    public Stationery setColor(Color color) {
        this.color = color;
        return this;
    }

    public Stationery setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public int compareTo(Stationery o) {
        return 0;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        name = this.getClass().getSimpleName();
        return name;
    }

    public enum Color {
        RED, BLUE, PLAIN, GREEN, YELLOW
    }

}
