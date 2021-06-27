package program.headfirst.weather;

/**
 * Created by yanxinming on 2019/1/20
 */
public interface Observer {
    //这里是不是应该把这三个数据封装成一个对象
    public void update(float temp, float humidity, float pressure);
}
