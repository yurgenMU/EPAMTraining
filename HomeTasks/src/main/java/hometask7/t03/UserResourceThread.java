package hometask7.t03;

import java.util.Arrays;
import java.util.List;

public class UserResourceThread {
    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();
        IntegerSetterGetter t1 = new IntegerSetterGetter("1", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", res);
        IntegerSetterGetter t5 = new IntegerSetterGetter("5", res);
        List<IntegerSetterGetter> threadsList = Arrays.asList(t1, t2, t3, t4, t5);
        res.setThreadCount(threadsList.size());
        threadsList.stream().forEach(t -> t.start());
        Thread.sleep(100);
        threadsList.stream().forEach(t -> t.stopThread());
        threadsList.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("main");
    }
}