package hometask7.t01;

public class Account {
    private final int id;
    private double balance;

    public Account(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {

        return id;
    }

    public double getBalance() {
        return balance;
    }


}
