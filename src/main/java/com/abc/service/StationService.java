package com.abc.service;

import com.abc.model.Observation;
import com.abc.model.Station;

import java.util.List;

public interface StationService {
    List<Station> findAll();
    Station getStation(String stationId);
    List<Station> findByState(String state);
    List<Station> findByCity(String city);
}
