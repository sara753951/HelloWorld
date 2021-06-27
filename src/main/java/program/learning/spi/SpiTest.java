package program.learning.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by yanxinming on 2020/9/21
 */
public class SpiTest {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemResource(""));
        ServiceLoader<SpiTestService> serviceLoader = ServiceLoader.load(SpiTestService.class);
        Iterator<SpiTestService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            SpiTestService spiTestService = iterator.next();
            spiTestService.print();
        }
//        for (SpiTestService spiTestService : serviceLoader) {
//            spiTestService.print();
//        }
    }
}
