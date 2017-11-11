package hometask7.t01;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Bank synchronizedBank = new SynchronizedBank(10);
        String path = "HomeTasks/src/main/resources/bank/transfersList";
        TransfersGenerator transfersGenerator = new TransfersGenerator(synchronizedBank, 25, path);
        transfersGenerator.generateTransfers();
        Parser parser = new Parser(synchronizedBank, path);
        List<Transfer> transferList = parser.getTransfers();
        Bank concurrentBank = new ConcurrentBank(10);
        transaction(synchronizedBank, transferList);
        System.out.println("================================================");
        transaction(concurrentBank, transferList);

    }

    static void transaction(Bank bank, List<Transfer> transferList) {
        ExecutorService executor = Executors.newScheduledThreadPool(transferList.size());
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
