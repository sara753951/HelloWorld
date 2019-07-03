package headfirst.remoteControlCommand;

/**
 * Created by yanxinming on 2019/2/18
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light("");
        LightOnComamnd lightOnComamnd = new LightOnComamnd(light);
        remoteControl.setCommand(lightOnComamnd);
        remoteControl.buttonWasPressed();

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        remoteControl.setCommand(garageDoorOpenCommand);
        remoteControl.buttonWasPressed();
    }
}
