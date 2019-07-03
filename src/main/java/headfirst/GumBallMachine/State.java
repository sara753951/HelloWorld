package headfirst.GumBallMachine;

/**
 * Created by yanxinming on 2019/2/24
 */
public interface State {

    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
