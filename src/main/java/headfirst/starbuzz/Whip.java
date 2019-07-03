package headfirst.starbuzz;

/**
 * Created by yanxinming on 2019/1/20
 */
public class Whip extends CondimentDecorator{
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "\t+\tWhip";
    }

    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }
}
