package concurrent.threadfactory;

public class Demo {

    public void execute() {
        BaeldungthreadFactory factory = new BaeldungthreadFactory("BaeldungThreadFactory");
        for (int i = 0; i < 10; i++) {
            Thread t = factory.newThread(new Task());
            t.start();
        }
    }
}
