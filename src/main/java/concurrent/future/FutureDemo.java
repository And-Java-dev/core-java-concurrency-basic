package concurrent.future;

import java.util.concurrent.*;

public class FutureDemo {

    public String invoke() {
        String str = null;

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String > future = executorService.submit(() -> {
            System.out.println("Zig Hainz");
            Thread.sleep(10000L);
            return "Good morning!";
        });

        future.cancel(false);

        try {
            future.get(20, TimeUnit.SECONDS) ;
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            e.printStackTrace();
        }

        if (future.isDone() && !future.isCancelled()){
            try {
                str = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return str;
    }
}
