package com.abc;

import com.abc.controller.MyController;
import com.abc.controller.StationController;
import com.abc.model.Station;
import org.springframework.stereotype.Component;
import org.glassfish.jersey.server.ResourceConfig;


@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(MyController.class);
        register(StationController.class);
    }
}
