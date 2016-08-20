package org.knowm.xdropwizard.api;

/**
 * Created by Sua on 8/20/16.
 */
public class Weather {

    private final String content;
    /**
     * Constructor
     *
     * @param content
     */
    public Weather(String content) {

        this.content = content;
    }

    public String getContent() {

        return content;
    }
}

