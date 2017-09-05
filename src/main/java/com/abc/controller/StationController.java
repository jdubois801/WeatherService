package com.abc.controller;

import com.abc.model.Observation;
import com.abc.model.Station;
import com.abc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@Path("/stations")
public class StationController {

    @Autowired
    StationService service;

    @GET
    @Path("")
    @Produces("application/json")
    public List<Station> listAll(
            @QueryParam("state") String state,
            @QueryParam("rest") String rest,
            @QueryParam("city") String city) {

        if (state != null && !state.isEmpty()) {
            return service.findByState(state);
        }
        else if (rest != null && !rest.isEmpty()) {
            return service.findByRest(rest);
        }
        else if (city != null && !city.isEmpty()) {
            return service.findByCity(city);
        }

        return service.findAll();
    }

}
