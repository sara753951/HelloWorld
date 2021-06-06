package program.learning.thread;

public class YieldTest implements Runnable {



    public YieldTest() {
        System.out.println("constructor run...");
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "YieldTest run 1..");
//        Thread.yield();
        System.out.println(name + "YieldTest run 2..");
//        Thread.yield();
        System.out.println(name + "YieldTest run 3..");
//        Thread.yield();
        System.out.println("end");
    }
}
