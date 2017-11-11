package hometask7.t01;

import java.util.List;

public class SynchronizedBank extends Bank {


    public SynchronizedBank(int size) {
        super(size);

    }

    @Override
    public void transfer(Transfer transferInfo) {
        List<Account> accounts = getAccounts();
        Account accountFrom = accounts.get(transferInfo.getAccountFrom().getId());
        Account accountTo = accounts.get(transferInfo.getAccountTo().getId());
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
        if (accountFrom.getBalance() < transferInfo.getValue()) return;
        System.out.print(Thread.currentThread());
        accountFrom.setBalance(accountFrom.getBalance() - transferInfo.getValue());
        System.out.printf(" %10.2f from %d to %d", transferInfo.getValue(), accountFrom.getId(), accountTo.getId());
        accountTo.setBalance(accountTo.getBalance() + transferInfo.getValue());
        System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
    }

}
