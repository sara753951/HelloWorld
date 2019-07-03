package headfirst.duck;

/**
 * Created by yanxinming on 2019/1/19
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I'm a model duck!!!");
    }
}
