package program.javaassist;

import java.lang.management.ManagementFactory;

public class Base {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:"+pid);
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }


    public static void process(){
        System.out.println("process");
    }
}


