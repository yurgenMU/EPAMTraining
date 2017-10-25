package hometask4.t03;


import java.io.*;

public class CharsetChanger {

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

    public String writeAsUTF16(String arg, String path) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF16"))) {
            writer.write(arg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arg;
    }
}
