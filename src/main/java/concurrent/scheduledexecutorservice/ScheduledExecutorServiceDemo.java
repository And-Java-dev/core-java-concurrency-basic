package concurrent.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ScheduledExecutorServiceDemo {

    private void execute() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        getTasksRun().apply(executorService);
        executorService.shutdown();
    }

    private void executeWitMultiThread(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        getTasksRun().apply(executorService);
        executorService.shutdown();
    }

    private Function<ScheduledExecutorService, Void> getTasksRun() {
        return (executorService -> {
            ScheduledFuture<?> scheduledFuture1 = executorService.schedule(() -> {
                System.out.println("hello from scheduledFuture1");
            }, 1, TimeUnit.SECONDS);
            ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(() -> {
                System.out.println("hello from scheduledFuture");
            }, 1, 10, TimeUnit.SECONDS);
            ScheduledFuture<?> scheduledFuture2 = executorService.scheduleWithFixedDelay(() -> {
                System.out.println("hello from scheduledFuture2");
            }, 1, 10, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture3 = executorService.schedule(() -> {
                return "Hello World!!";
            }, 1, TimeUnit.SECONDS);
            return null;
        });

    }

    public static void main(String[] args) {
        ScheduledExecutorServiceDemo demo = new ScheduledExecutorServiceDemo();
        demo.execute();
        demo.executeWitMultiThread();
    }
}
