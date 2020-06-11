package program.headfirst.weather;

/**
 * Created by yanxinming on 2019/1/20
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
