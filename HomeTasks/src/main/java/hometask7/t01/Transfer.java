package hometask7.t01;

public class Transfer {
    private final Account accountFrom;
    private final Account accountTo;
    private final double value;

    public Account getAccountFrom() {
        return accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public double getValue() {
        return value;
    }

    public Transfer(Account accountFrom, Account accountTo, double value) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.value = value;
    }


}
