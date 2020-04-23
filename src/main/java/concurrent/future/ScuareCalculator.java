package concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ScuareCalculator {

    private final ExecutorService executor;

    ScuareCalculator(ExecutorService executor){
        this.executor = executor;
    }

    Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}
