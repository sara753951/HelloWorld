package headfirst.duck;

/**
 * Created by yanxinming on 2019/1/19
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Can not fly!!!");
    }
}
