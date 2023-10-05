package com.vilonovlev.WeathersApi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class WeatherForecast {
    private LocalDateTime dateTime;
    private int TemperatureC;

    public int getTemperatureF() {
        return 32 + (int)(TemperatureC / 0.5556);
    }

}
