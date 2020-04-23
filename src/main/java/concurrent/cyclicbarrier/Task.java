package concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier barrier) {
        cyclicBarrier = barrier;
    }
    @Override
    public void run() {
        try {
            System.out.println("Thread : " + Thread.currentThread().getName() + " is waiting");
            cyclicBarrier.await();
            System.out.println("Thread : " + Thread.currentThread().getName() + " is released");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
