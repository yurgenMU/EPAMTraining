package hometask7.t01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import hometask7.t01.Bank.Account;

public class Parser {
    private String path;
    private Bank bank;

    public Parser(Bank bank, String path) {
        this.path = path;
        this.bank = bank;
    }

    public List<Transfer> getTransfers() {
        List<Transfer> transfers = new ArrayList<>();
        List<Account> accounts = bank.getAccounts();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"
        ))) {
            String sCurrentLine;
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                String[] params = sCurrentLine.split(" ");
                transfers.add(new Transfer(Integer.parseInt(params[0]),
                        Integer.parseInt(params[1]),
                        new BigDecimal(params[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transfers;
    }
}
