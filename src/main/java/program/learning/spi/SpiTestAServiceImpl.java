package program.learning.spi;

/**
 * Created by yanxinming on 2020/9/21
 */
public class SpiTestAServiceImpl implements SpiTestService {
    @Override
    public void print() {
        System.out.println("A");
    }
}
