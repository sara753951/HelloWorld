package program.headfirst.PizzaFactory;

/**
 * Created by yanxinming on 2019/1/21
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("clam")) {
            return new NYStyleClamPizza();
        }
        return null;
    }
}
