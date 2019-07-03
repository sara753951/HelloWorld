package headfirst.weather;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yanxinming on 2019/1/20
 */
public class CurrentConditionDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    Observable observable;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: temperature\"" + temperature + "\"\thumiditu\"" + humidity);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

}
