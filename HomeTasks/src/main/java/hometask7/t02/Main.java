package hometask7.t02;

import hometask5.t02.NoPropertyFileException;
import hometask6.t02.PropertyWrapper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try {
            PropertyWrapper propertyWrapper = new PropertyWrapper("Hometasks/src/main/resources/wrapper.properties");
            ExecutorService executor = Executors.newFixedThreadPool(propertyWrapper.getProperties().size());
            for (Object obj : propertyWrapper.getProperties().keySet()) {
                Runnable r = () -> {
                    try {
                        System.out.println(Thread.currentThread().toString() + " " + propertyWrapper.getProperties().get(obj));

                    } catch (NoPropertyFileException e) {
                        e.printStackTrace();
                    }
                };
                executor.execute(r);
            }
            executor.shutdown();
        } catch (NoPropertyFileException e) {
            e.printStackTrace();
        }
    }

}
