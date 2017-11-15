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
        Account accountFrom = accounts.get(transferInfo.getAccountFrom());
        Account accountTo = accounts.get(transferInfo.getAccountTo());
        transferOperation(transferInfo, accountFrom, accountTo);

    }

    private void transferOperation(Transfer transferInfo, Account accountFrom, Account accountTo) {
        if (accountFrom.getBalance().compareTo(transferInfo.getValue()) < 0) return;
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        lock1.lock();
        try {
            System.out.print(Thread.currentThread());
            accountFrom.setBalance(accountFrom.getBalance().add(transferInfo.getValue().negate()));
            System.out.printf(" %10.2f from %d to %d", transferInfo.getValue(), accountFrom.getId(), accountTo.getId());
            lock2.lock();
            try {
                accountTo.setBalance(accountTo.getBalance().add(transferInfo.getValue()));
                System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
            } finally {
                lock2.unlock();
            }
        } finally {
            lock1.unlock();

        }

    }
}
