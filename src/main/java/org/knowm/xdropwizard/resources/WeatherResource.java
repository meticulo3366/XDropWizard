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
    private final String temperatureString;
    private final int c;
    private final int f;
    private final AtomicLong counter;;

    /**
     * Constructor
     *
     * @param location
     * @param f
     * @param c
     */

    public WeatherResource(String location, int f, int c) {
        this.counter = new AtomicLong();
        this.location = location;
        this.f = f;
        this.c = c;
        this.temperatureString = "It's "+ f + " degrees out.";
    }

    /** Dropwizard automatically records the duration and rate of its invocations as a Metrics Timer. */
    @GET
    public Weather getWeather() {
        return new Weather(counter.incrementAndGet(), temperatureString +  "\n " + Integer.toString(c) + " C");

    }
}
