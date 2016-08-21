package org.knowm.xdropwizard.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.knowm.xdropwizard.api.Weather;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

/**
 * Created by Sua on 8/20/16.
 */
@Path("weather")
@Produces(MediaType.APPLICATION_JSON)


public class WeatherResource {

    private final String location;
    private final int c;
    private final int f;

    /**
     * Constructor
     *
     * @param location
     * @param c
     * @param f
     */

    public WeatherResource(String location, int f, int c) {
        this.location = location;
        this.f = f;
        this.c = c;
    }

    /** Dropwizard automatically records the duration and rate of its invocations as a Metrics Timer. */
    @GET
    public Weather getWeather() {
        return new Weather(location, 3, 32);
    }
}
