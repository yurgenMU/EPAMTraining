package hometask7.t01;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Bank {
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public Bank(int size) {
        this.accounts = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            accounts.add(new Account(i));

        }

    }

    public synchronized BigDecimal getTotalBalance() {
        return accounts.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public abstract void transfer(Transfer t);

    public class Account {
        private final int id;
        private BigDecimal balance = BigDecimal.valueOf(1000);

        public Account(int id) {
            this.id = id;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

        public int getId() {

            return id;
        }

        public BigDecimal getBalance() {
            return balance;
        }


    }


}
