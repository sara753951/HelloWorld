package program.learning.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {

        test2();
    }

    private static void test2() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executor.execute(new YieldTest());
        }
        executor.shutdown();
        System.out.println("Main End!");
    }

    private static void test1() {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new YieldTest(), "Thread-" + i);
            t.start();
            t.getName();
        }
        System.out.println("Main End!");
    }
}
