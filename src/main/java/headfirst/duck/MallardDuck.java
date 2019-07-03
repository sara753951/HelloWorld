package headfirst.duck;

/**
 * Created by yanxinming on 2019/1/19
 */
public class MallardDuck extends Duck{
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a mallard duck!!!");
    }
}
