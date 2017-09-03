package com.abc.service.impl;

import com.abc.model.AirportCode;
import com.abc.model.AirportCodes;
import com.abc.model.Observation;
import com.abc.model.Station;
import com.abc.repository.AirportCodesRepository;
import com.abc.repository.StationRepository;
import com.abc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    StationRepository stationRepo;

    @Autowired
    AirportCodesRepository codesRepo;

    private AirportCode[] knownAirportCodes = null;

    public Observation getCurrent(String stationId) {
        Observation result = new Observation();

        validateAirportCode(stationId);

        for (Station sta :  stationRepo.findAll()) {
            System.err.println("station = " + sta);
            System.err.println("station.id = " + sta.getId());
            System.err.println("station.name = " + sta.getName());
        }

        return result;
    }

    private void loadKnownAirportCodes() {
        if (knownAirportCodes == null) {
            AirportCodes codes = codesRepo.findOne("AirportCodes");
            knownAirportCodes = codes.getCodes();
        }
    }

    private void validateAirportCode(String airportCode) {
        loadKnownAirportCodes();

        for (AirportCode code : knownAirportCodes) {
            if (code.getId().equals(airportCode)) {
                return;  // quiet success
            }
        }

        throw new IllegalArgumentException("Airport code '" + airportCode + "' is unknown");
    }

}
