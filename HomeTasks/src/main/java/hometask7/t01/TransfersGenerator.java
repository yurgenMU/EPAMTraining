package hometask7.t01;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class TransfersGenerator {
    private final int size;
    private final String path;
    private final Bank bank;
    private final Random random = new Random();

    public TransfersGenerator(Bank bank, int size, String path) {
        this.size = size;
        this.path = path;
        this.bank = bank;
    }


    public String generateTransfers() {
        List<Bank.Account> accounts = bank.getAccounts();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            int count = 0;
            while (count < size) {
                int from = random.nextInt(accounts.size());
                int to = random.nextInt(accounts.size());
                BigDecimal value = BigDecimal.valueOf((Bank.MAX_AMOUNT * Math.random()));
                if (from != to) {
                    writer.write(from + " " + to + " " + value + "\n");
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
