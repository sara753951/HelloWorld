package program.headfirst.duckAdapter;

/**
 * Created by yanxinming on 2019/2/21
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
