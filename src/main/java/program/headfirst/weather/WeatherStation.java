package program.headfirst.weather;

/**
 * Created by yanxinming on 2019/1/20
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(25, 65, 30.4f);

        weatherData.setMeasurements(27, 70, 29.2f);
    }
}
