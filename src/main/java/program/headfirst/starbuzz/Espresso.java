package program.headfirst.starbuzz;

/**
 * Created by yanxinming on 2019/1/20
 */
public class Espresso extends Beverage{

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
