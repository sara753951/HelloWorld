package program.headfirst.duck;

/**
 * Created by yanxinming on 2019/1/19
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Quacking!!!");
    }
}
