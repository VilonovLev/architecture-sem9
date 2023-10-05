package com.vilonovlev.WeathersApi;


import com.vilonovlev.WeathersApi.models.WeatherForecast;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class WeatherForecastHolder {

    private List<WeatherForecast> values;

    public WeatherForecastHolder() {
        values = new ArrayList<>();
        values.add(new WeatherForecast(LocalDateTime.of(1983, 6, 1, 20, 0), 12));
        values.add(new WeatherForecast(LocalDateTime.of(2025, 4, 1, 22, 0), 24));
        values.add(new WeatherForecast(LocalDateTime.of(1423, 7, 1, 12, 0), 23));
    }


    public boolean addForecast(WeatherForecast weatherForecast) {
        return values.add(weatherForecast);
    }

    public boolean deleteForecast(WeatherForecast weatherForecast){
        return values.remove(weatherForecast);
    }

    public boolean updateForecast(WeatherForecast weatherForecast) {
        for (WeatherForecast weather :values) {
            if (weather.getDateTime().equals(weatherForecast.getDateTime())) {
                weather.setDateTime(weatherForecast.getDateTime());
                return true;
            }
        }
        return false;
    }

    public List<WeatherForecast> getForecastsInInterval(LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<WeatherForecast> list = new ArrayList<WeatherForecast>();
        for(WeatherForecast weatherForecast:values) {
            if (weatherForecast.getDateTime().isAfter(dateFrom)
                    && weatherForecast.getDateTime().isBefore(dateTo))
                list.add(weatherForecast);
        }
        return list;
    }


}
