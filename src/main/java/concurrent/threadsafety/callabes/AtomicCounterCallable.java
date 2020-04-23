package concurrent.threadsafety.callabes;

import java.util.concurrent.Callable;
import concurrent.threadsafety.services.AtomicCounter;

public class AtomicCounterCallable implements Callable<Integer> {

    private final AtomicCounter counter;

    public AtomicCounterCallable(AtomicCounter counter){
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
