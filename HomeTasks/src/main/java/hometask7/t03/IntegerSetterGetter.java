package hometask7.t03;

import java.util.Random;

class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;
        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    resource.setGetterCount(resource.getGetterCount() + 1);
                    if (resource.getGetterCount() > resource.getThreadCount() / 2)
                        setIntegersIntoResource();
                    else getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void getIntegersFromResource() throws InterruptedException {
        Integer number;

        System.out.println("Поток " + getName() + " хочет извлечь число.");
        synchronized (resource) {
            while (resource.getList().isEmpty()) {
                System.out.println(" Поток " + getName() + " ждет пока очередь заполнится.");
                resource.wait();
            }
            System.out.println("Поток " + getName() + " возобновил работу. ");
            number = resource.getElement();
            System.out.println(" Поток " + getName() + " извлек число " + number);
            resource.notifyAll();
        }
    }

    private synchronized void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notifyAll();
        }
    }
}