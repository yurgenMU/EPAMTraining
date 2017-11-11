package hometask7.t01;

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
            accounts.add(new Account(i).setBalance(INITIAL_BALANCE));

        }

    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (Account account : accounts)
            sum += account.getBalance();
        return sum;
    }

    public abstract void transfer(Transfer t);

}
