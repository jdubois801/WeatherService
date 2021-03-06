package com.abc.controller;

import com.abc.model.Observation;
import com.abc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@RestController
@Path("/hello")
public class MyController {

    @Autowired
    WeatherService service;

    @GET
    @Path("/world")
    public String endpoint() {

        return "hello world";
    }

    @GET
    @Path("/current")
    public Observation endpoint(@QueryParam("station_id") String stationId) {

        System.err.println("station_id = " + stationId);

        return service.getCurrent(stationId);
    }

}
