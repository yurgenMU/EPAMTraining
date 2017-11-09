package hometask2.t03;

public abstract class Stationery implements Comparable<Stationery> {
    private final double price;
    private Color color;
    private final String name;


    public Stationery(double price) {
        name = this.getClass().getSimpleName();
        this.price = price;

    }

    public Stationery(Color color, double price) {
        this.color = color;
        name = this.getClass().getSimpleName();
        this.price = price;
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


    @Override
    public int compareTo(Stationery o) {
        return 0;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public enum Color {
        RED, BLUE, PLAIN, GREEN, YELLOW
    }

}
