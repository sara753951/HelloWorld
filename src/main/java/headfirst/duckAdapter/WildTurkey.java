package headfirst.duckAdapter;

import headfirst.duckAdapter.Turkey;

/**
 * Created by yanxinming on 2019/2/21
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
