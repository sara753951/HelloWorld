package headfirst.GumBallMachine;

/**
 * Created by yanxinming on 2019/2/24
 */
public class SoldOutState implements State {
    GumBallMachine gumBallMachine;

    public SoldOutState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, tou haven't inserted a quarted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
