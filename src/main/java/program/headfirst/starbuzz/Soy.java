package program.headfirst.starbuzz;

/**
 * Created by yanxinming on 2019/1/20
 */
public class Soy extends CondimentDecorator{
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "\t+\tSoy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
