package concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarierExample {

    public void start() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("All previous tasks are completed");
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "T");
        Thread t2 = new Thread(new Task(cyclicBarrier), "O");
        Thread t3 = new Thread(new Task(cyclicBarrier), "M");

        if (!cyclicBarrier.isBroken()){
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
