package hometask7.t01;

import java.math.BigDecimal;

public class Transfer {
    private final int accountFrom;
    private final int accountTo;
    private final BigDecimal value;


    public int getAccountFrom() {
        return accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Transfer(int accountFrom, int accountTo, BigDecimal value) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.value = value;
    }


}
