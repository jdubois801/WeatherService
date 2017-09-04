package com.abc.service.impl;

import com.abc.model.AirportCode;
import com.abc.model.AirportCodes;
import com.abc.model.Observation;
import com.abc.model.Station;
import com.abc.repository.AirportCodesRepository;
import com.abc.repository.StationRepository;
import com.abc.service.StationService;
import com.abc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationRepository stationRepo;

    private AirportCode[] knownAirportCodes = null;

    public Station getStation(String stationId) {
        return stationRepo.findOne(stationId);
    }

    public List<Station> findAll() {
        List<Station> result = new ArrayList<>();

        for (Station sta : stationRepo.findAll()) {
            result.add(sta);
        }

        return result;
    }

    public List<Station> findByState(String state) {
        return stationRepo.findByState(state);
    }
    public List<Station> findByCity(String city) {
        return stationRepo.findByCity(city);
    }
}
