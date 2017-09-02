package com.abc.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class MyController {

    @GET
    @Path("/world")
    public String endpoint() {
        return "hello world";
    }
}
