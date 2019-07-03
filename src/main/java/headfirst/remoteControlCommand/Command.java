package headfirst.remoteControlCommand;

/**
 * Created by yanxinming on 2019/2/18
 */
public interface Command {
    public void execute();
    public void undo();
}
