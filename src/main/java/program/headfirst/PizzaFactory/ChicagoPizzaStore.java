package program.headfirst.PizzaFactory;

/**
 * Created by yanxinming on 2019/1/21
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String item) {

        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (item.equals("clam")) {
            return new ChicagoStyleClamPizza();
        }

        return null;
    }
}
