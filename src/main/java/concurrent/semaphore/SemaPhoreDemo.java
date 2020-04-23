package concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class SemaPhoreDemo {

    static Semaphore semaPhore = new Semaphore(10);

    public void execute(){
        System.out.println("Available permit : " + semaPhore.availablePermits());

        if (semaPhore.tryAcquire()){
            try{

            }finally {

                semaPhore.release();
            }
        }
    }
}
