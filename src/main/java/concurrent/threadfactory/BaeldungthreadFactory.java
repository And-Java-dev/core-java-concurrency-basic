package concurrent.threadfactory;

import java.util.concurrent.ThreadFactory;

public class BaeldungthreadFactory implements ThreadFactory {

    private int threadId;
    private String name;

    public BaeldungthreadFactory(String name) {
        this.name = name;
        threadId = 1;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "_Thread_" + threadId);
        System.out.println("created new Thread with id :" + threadId + " and name " + t.getName());
        threadId++;
        return t;
    }
}
