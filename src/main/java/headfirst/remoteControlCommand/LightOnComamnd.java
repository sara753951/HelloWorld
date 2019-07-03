package headfirst.remoteControlCommand;

/**
 * Created by yanxinming on 2019/2/18
 */
public class LightOnComamnd implements Command{
    Light light;

    public LightOnComamnd(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
