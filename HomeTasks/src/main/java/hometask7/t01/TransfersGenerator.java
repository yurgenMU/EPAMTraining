package hometask7.t01;

import java.io.*;
import java.util.Random;

public class TransfersGenerator {
    private int size;
    private String path;

    public TransfersGenerator(int size, String path) {
        this.size = size;
        this.path = path;
    }

    public String readAsUTF8(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"
        ))) {
            String sCurrentLine;
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(sCurrentLine).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String generateTransfers() {
        int from;
        int to;
        double value;
        Random random = new Random();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            for (int i = 0; i < size; i++) {
                from = random.nextInt();
            }
//            writer.write(arg);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return arg;
        return null;
    }
}
