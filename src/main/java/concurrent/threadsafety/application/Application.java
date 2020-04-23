package concurrent.threadsafety.application;

import concurrent.threadsafety.callabes.*;
import concurrent.threadsafety.mathutils.MathUtils;
import concurrent.threadsafety.services.*;

import java.util.*;
import java.util.concurrent.*;

public class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new  Thread(() -> {
            System.out.println(MathUtils.factorial(10));
        }).start();
        new Thread(() -> {
            System.out.println(MathUtils.factorial(5));
        }).start();


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MessageService messageService = new MessageService("Welcome to Baeldung!");
        Future<String> future1 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        Future<String> future2 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        System.out.println(future1.get());
        System.out.println(future2.get());

        Counter counter = new Counter();
        Future<Integer> future3 = (Future<Integer>) executorService.submit(new CounterCallable(counter));
        Future<Integer> future4 = (Future<Integer>) executorService.submit(new CounterCallable(counter));
        System.out.println(future3.get());
        System.out.println(future4.get());

        ObjectLockCounter objectLockCounter = new ObjectLockCounter();
        Future<Integer> future5 = (Future<Integer>) executorService.submit(new ExtrinsicLockCounterCallable(objectLockCounter));
        Future<Integer> future6 = (Future<Integer>) executorService.submit(new ExtrinsicLockCounterCallable(objectLockCounter));
        System.out.println(future5.get());
        System.out.println(future6.get());

        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();
        Future<Integer> future7 = (Future<Integer>) executorService.submit(new ReentrantLockCounterCallable(reentrantLockCounter));
        Future<Integer> future8 = (Future<Integer>) executorService.submit(new ReentrantLockCounterCallable(reentrantLockCounter));
        System.out.println(future7.get());
        System.out.println(future8.get());

        ReentrantReadWriteLockCounter reentrantReadWriteLockCounter = new ReentrantReadWriteLockCounter();
        Future<Integer> future9 = (Future<Integer>) executorService.submit(new ReentrantReadWriteLockCounterCallable(reentrantReadWriteLockCounter));
        Future<Integer> future10 = (Future<Integer>) executorService.submit(new ReentrantReadWriteLockCounterCallable(reentrantReadWriteLockCounter));
        System.out.println(future9.get());
        System.out.println(future10.get());

        AtomicCounter atomicCounter = new AtomicCounter();
        Future<Integer> future11 = (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
        Future<Integer> future12 = (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
        System.out.println(future11.get());
        System.out.println(future12.get());

        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        Thread thread_11 = new Thread(() -> syncCollection.addAll(Arrays.asList(1,2,3,4,5,6)));
        Thread thread_12 = new Thread(() -> syncCollection.addAll(Arrays.asList(1,2,3,4,5,6)));
        thread_11.start();
        thread_12.start();


        Map<String ,String > coucurrentMap = new ConcurrentHashMap<>();
        coucurrentMap.put("1","one");
        coucurrentMap.put("2","two");
        coucurrentMap.put("3","tree");
    }
}
