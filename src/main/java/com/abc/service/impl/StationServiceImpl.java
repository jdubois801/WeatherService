package com.abc.service.impl;

import com.abc.model.AirportCode;
import com.abc.model.Station;
import com.abc.repository.StationRepository;
import com.abc.service.StationService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationRepository stationRepo;

    private CloseableHttpClient httpclient;

    @Value("${weather.service.host}")
    String weatherHost;


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

    /*
        An example of how to call an external RESTful service.  This one uses the Apache HttpClient to
        call this same application through the StationController and eventually this same StationServiceImpl
        through the findByState method.

        The orchestration happens synchronously
     */
    public List<Station> findByRest(String state) {
        CloseableHttpResponse response = null;

        List<Station> result = null;

        try {
            httpclient = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(weatherHost + "/stations?state=" + state);
            response = httpclient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode >= 300) {
                throw new Exception("Error " + statusCode + " encountered in HTTP transaction.");
            }

            ObjectMapper mapper = new ObjectMapper();
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Station.class);

            result = mapper.readValue(response.getEntity().getContent(), type);
        }
        catch (Exception e) {
            // TODO: better exception handling
            e.printStackTrace();
        }
        finally {
            try {
                response.close();
                httpclient.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
