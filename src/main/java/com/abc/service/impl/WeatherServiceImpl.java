package com.abc.service.impl;

import com.abc.model.Observation;
import com.abc.model.Station;
import com.abc.repository.StationRepository;
import com.abc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    StationRepository repo;

    public Observation getCurrent(String stationId) {
        Observation result = new Observation();

        Station station = repo.findOne(1L);

        return result;
    }
}
