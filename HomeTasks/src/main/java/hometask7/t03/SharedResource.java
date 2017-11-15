package hometask7.t03;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private int getterCount = 0;
    private int threadCount = 0;
    private List<Integer> list;


    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public int getGetterCount() {
        return getterCount;
    }

    public void setGetterCount(int getterCount) {
        this.getterCount = getterCount;
    }

    public SharedResource() {
        list = new ArrayList<>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getElement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

    public List<Integer> getList() {
        return list;
    }
}