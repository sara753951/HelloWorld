package program.headfirst.PizzaFactory;

/**
 * Created by yanxinming on 2019/1/21
 */
public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        name = "NY Style Sauce and Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Raggiano Clam");
    }
}
