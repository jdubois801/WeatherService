package com.abc.service;

import com.abc.model.Observation;

public interface WeatherService {
    Observation getCurrent(String stationId);
}
