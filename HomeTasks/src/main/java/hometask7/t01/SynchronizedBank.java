package hometask7.t01;

import java.util.List;

public class SynchronizedBank extends Bank {
    List<Account> accounts;

    public SynchronizedBank(int size) {
        super(size);
        accounts = getAccounts();
    }

    @Override
    public void transfer(Transfer transferInfo) {
        Account accountFrom = accounts.get(transferInfo.getAccountFrom());
        Account accountTo = accounts.get(transferInfo.getAccountTo());
        if (accountFrom.getId() < accountTo.getId()) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    transferOperation(transferInfo, accountFrom, accountTo);
                }
            }
        } else {
            synchronized (accountTo) {
                synchronized (accountFrom) {
                    transferOperation(transferInfo, accountFrom, accountTo);
                }
            }
        }
    }

    private synchronized void transferOperation(Transfer transferInfo, Account accountFrom, Account accountTo) {
        if (accountFrom.getBalance().compareTo(transferInfo.getValue()) < 0) return;
        System.out.print(Thread.currentThread());
        accountFrom.setBalance(accountFrom.getBalance().add(transferInfo.getValue().negate()));
        System.out.printf(" %10.2f from %d to %d", transferInfo.getValue(), accountFrom.getId(), accountTo.getId());
        accountTo.setBalance(accountTo.getBalance().add(transferInfo.getValue()));
        System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
    }

}
