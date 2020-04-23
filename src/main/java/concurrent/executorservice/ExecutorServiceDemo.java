package concurrent.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void execute(){
        executorService.submit(() -> {
            new Task();
        });

        executorService.shutdown();
        executorService.shutdownNow();
        try {
            executorService.awaitTermination(20L, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
