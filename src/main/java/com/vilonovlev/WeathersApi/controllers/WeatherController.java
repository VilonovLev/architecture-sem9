package com.vilonovlev.WeathersApi.controllers;

import com.vilonovlev.WeathersApi.WeatherForecastHolder;
import com.vilonovlev.WeathersApi.models.WeatherForecast;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/weathers")
@NoArgsConstructor
public class WeatherController {

    public final WeatherForecastHolder weatherForecastHolder;

    {
        weatherForecastHolder = new WeatherForecastHolder();
    }

    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 200;
    private static final int AUTH_FAILURE = 400;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse post(@RequestBody WeatherForecast weatherForecast) {
            return weatherForecastHolder.addForecast(weatherForecast)?
            new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS):new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WeatherForecast>> get() {
        return ResponseEntity.ok(weatherForecastHolder.getValues());
    }

    @PutMapping(produces = APPLICATION_JSON_VALUE)
    public BaseResponse update(@RequestBody WeatherForecast weatherForecast) {
        return weatherForecastHolder.updateForecast(weatherForecast)?
                new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS):new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE)
    public BaseResponse delete(@RequestBody WeatherForecast weatherForecast) {
        return weatherForecastHolder.deleteForecast(weatherForecast)?
                new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS):new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
    }

}
