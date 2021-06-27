package program.learning.thread;

/**
 * Created by yanxinming on 2020/11/29
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread" + i + "print.");
        }
    }
}
