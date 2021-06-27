package program.learning.spi;

/**
 * Created by yanxinming on 2020/9/21
 */
public class SpiTestBServiceImpl implements SpiTestService{
    @Override
    public void print() {
        System.out.println("B");
    }
}
