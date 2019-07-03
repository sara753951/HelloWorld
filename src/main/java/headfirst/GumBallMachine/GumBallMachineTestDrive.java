package headfirst.GumBallMachine;

/**
 * Created by yanxinming on 2019/2/24
 */
public class GumBallMachineTestDrive {
    public static void main(String[] args) {
        GumBallMachine gumBallMachine = new GumBallMachine(5);
        System.out.println(gumBallMachine);

        try {

            gumBallMachine.insertQuerter();
            gumBallMachine.turnCrank();
            System.out.println(gumBallMachine);

            gumBallMachine.insertQuerter();
            gumBallMachine.turnCrank();
            System.out.println(gumBallMachine);

            gumBallMachine.insertQuerter();
            gumBallMachine.turnCrank();
            System.out.println(gumBallMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
