package concurrent.threadsafety.services;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private final AtomicInteger counter = new AtomicInteger();
    public AtomicCounter(){}

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public Integer getCounter() {
        return counter.get();
    }
}
