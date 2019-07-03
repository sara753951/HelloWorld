package headfirst.starbuzz;

/**
 * Created by yanxinming on 2019/1/20
 */
public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "\t+\tMocha";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}
