package program.headfirst.remoteControlCommand;

/**
 * Created by yanxinming on 2019/2/18
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(){}

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
