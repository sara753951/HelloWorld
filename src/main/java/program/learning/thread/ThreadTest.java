package program.learning;

/**
 * Created by yanxinming on 2019/12/24
 */
public class ThreadTest {

    private SimpleTask task = new SimpleTask();
    public static void main(String[] args) {
        ThreadTest plan = new ThreadTest();
        plan.start();
    }

    public void start(){
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(e.getMessage());
            start();
        });
        thread.start();
    }

    static class SimpleTask implements Runnable{

        private int task = 10;

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"--"+"启动");
            while(task>0){
                try {
                    Thread.sleep(500);

                    if(System.currentTimeMillis()%3==0){
                        throw new RuntimeException("模拟异常");
                    }
                    System.out.println(threadName+"--"+"执行task"+task);
                    task--;
                }catch (Exception e){
                    System.out.println("异常");
                    e.printStackTrace();
                }
            }
            System.out.println(threadName+"--"+"正常终止");
        }
    }

}
