package headfirst.PizzaFactory;

/**
 * Created by yanxinming on 2019/1/21
 */
public class NYStyleCheesePizza extends Pizza{

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Raggiano Cheese");
    }
}
