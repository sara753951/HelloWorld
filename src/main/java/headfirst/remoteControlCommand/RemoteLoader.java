package headfirst.remoteControlCommand;

/**
 * Created by yanxinming on 2019/2/18
 */
public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
//
        LightOnComamnd livingRoomLightOnCommand = new LightOnComamnd(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);

        LightOnComamnd kitchenLightOnCommand = new LightOnComamnd(kitchenLight);
        LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);
//
//        remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
//        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);
//
//
//        remoteControl.onButtonWasPressed(0);
//        remoteControl.offButtonWasPressed(0);
//        remoteControl.onButtonWasPressed(1);
//        remoteControl.offButtonWasPressed(1);
//        System.out.println(remoteControl);
//        remoteControl.undoButtonWasPressed();
//        remoteControl.offButtonWasPressed(1);
//        remoteControl.onButtonWasPressed(1);
//        System.out.println(remoteControl);
//        remoteControl.undoButtonWasPressed();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

//        remoteControl.setCommand(0, ceilingFanMediumCommand, ceilingFanOffCommand);
//        remoteControl.setCommand(1, ceilingFanHighCommand, ceilingFanOffCommand);
//
//        remoteControl.onButtonWasPressed(0);
//        remoteControl.offButtonWasPressed(0);
//        System.out.println(remoteControl);
//        remoteControl.undoButtonWasPressed();
//
//        remoteControl.onButtonWasPressed(1);
//        System.out.println(remoteControl);
//        remoteControl.undoButtonWasPressed();

        Command[] partyOn = {livingRoomLightOnCommand, kitchenLightOnCommand, ceilingFanMediumCommand};
        Command[] partyOff = {livingRoomLightOffCommand, kitchenLightOffCommand, ceilingFanOffCommand};

        MacroCommand partyOnCommand = new MacroCommand(partyOn);
        MacroCommand partyOffCommand = new MacroCommand(partyOff);

        remoteControl.setCommand(0, partyOnCommand, partyOffCommand);

        System.out.println(remoteControl);
        System.out.println("\n--- Pushing Macro On ---\n");
        remoteControl.onButtonWasPressed(0);
        System.out.println("\n--- Pushing Macro Off ---\n");
        remoteControl.offButtonWasPressed(0);



    }
}
