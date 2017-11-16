package hometask7.t01;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class BankTest {

    @Test
    public void bankTest() {
        Bank synchronizedBank = new SynchronizedBank(10);
        String path = "src/main/resources/bank/transfersList";
        TransfersGenerator transfersGenerator = new TransfersGenerator(synchronizedBank, 25, path);
        transfersGenerator.generateTransfers();
        Parser parser = new Parser(synchronizedBank, path);
        List<Transfer> transferList = parser.getTransfers();
        Bank concurrentBank = new ConcurrentBank(10);
        Service.transaction(synchronizedBank, transferList);
        System.out.println("================================================");
        Service.transaction(concurrentBank, transferList);
    }
}
