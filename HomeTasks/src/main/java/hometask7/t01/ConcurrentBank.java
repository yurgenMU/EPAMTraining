package hometask7.t01;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentBank extends Bank {
    private final Lock lock;

    public ConcurrentBank(int size) {
        super(size);
        lock = new ReentrantLock();
    }

    @Override
    public void transfer(Transfer transferInfo) {
        List<Account> accounts = getAccounts();
        Account accountFrom = accounts.get(transferInfo.getAccountFrom().getId());
        Account accountTo = accounts.get(transferInfo.getAccountTo().getId());
        lock.lock();
        try {
            transferOperation(transferInfo, accountFrom, accountTo);
        } finally {
            lock.unlock();
        }

    }

    private void transferOperation(Transfer transferInfo, Account accountFrom, Account accountTo) {
        if (accountFrom.getBalance() < transferInfo.getValue()) return;
        lock.lock();
        try {
            System.out.print(Thread.currentThread());
            accountFrom.setBalance(accountFrom.getBalance() - transferInfo.getValue());
            System.out.printf(" %10.2f from %d to %d", transferInfo.getValue(), accountFrom.getId(), accountTo.getId());
            accountTo.setBalance(accountTo.getBalance() + transferInfo.getValue());
            System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
        } finally {
            lock.unlock();
        }

    }
}
