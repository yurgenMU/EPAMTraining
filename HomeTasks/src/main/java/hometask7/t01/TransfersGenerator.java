package hometask7.t01;

import java.io.*;
import java.util.List;
import java.util.Random;

public class TransfersGenerator {
    private int size;
    private String path;
    private Bank bank;

    public TransfersGenerator(Bank bank, int size, String path) {
        this.size = size;
        this.path = path;
        this.bank = bank;
    }

//    public String readAsUTF8(String path) {
//        StringBuilder stringBuilder = new StringBuilder();
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"
//        ))) {
//            String sCurrentLine;
//            while ((sCurrentLine = bufferedReader.readLine()) != null) {
//                stringBuilder.append(sCurrentLine).append("\n");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return stringBuilder.toString();
//    }

    public String generateTransfers() {
        List<Account> accounts = bank.getAccounts();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            int count = 0;
            while (count < size) {
                Account from = accounts.get((int) (accounts.size() * Math.random()));
                Account to = accounts.get((int) (accounts.size() * Math.random()));
                double value = Bank.MAX_AMOUNT * Math.random();
                if (from != to) {
                    writer.write(from.getId() + " " + to.getId() + " " + value + "\n");
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
