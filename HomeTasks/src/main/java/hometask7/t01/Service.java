package hometask7.t01;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Service {


    static void transaction(Bank bank, List<Transfer> transferList) {
        ExecutorService executor = Executors.newFixedThreadPool(transferList.size());
        for (Transfer t : transferList) {
            Runnable r = () -> {
                bank.transfer(t);
            };
            executor.execute(r);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
