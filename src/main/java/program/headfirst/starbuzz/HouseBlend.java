package program.headfirst.starbuzz;

/**
 * Created by yanxinming on 2019/1/20
 */
public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "House Bleng Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
