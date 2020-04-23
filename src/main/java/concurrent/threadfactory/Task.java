package concurrent.threadfactory;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Task from package threadFactory");
    }
}
