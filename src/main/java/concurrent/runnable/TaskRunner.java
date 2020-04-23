package concurrent.runnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskRunner {

    private static ExecutorService executorService;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        executeTask();
    }

    private static void executeTask() throws ExecutionException, InterruptedException {
        executorService = Executors.newSingleThreadScheduledExecutor();

        EventLogginTask task = new EventLogginTask();
        Future future = executorService.submit(task);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
