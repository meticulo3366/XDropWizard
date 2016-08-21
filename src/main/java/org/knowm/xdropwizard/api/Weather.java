package org.knowm.xdropwizard.api;

/**
 * Created by Sua on 8/20/16.
 *
 */
public class Weather {
    private final long id;
    private final String text;
    /**
     * Constructor
     *
     * @param id
     * @param text
     *
     * EX. SLACK PAYLOAD
     * {
    "text": "It's 80 degrees right now.",
    "attachments": [
    {
    "text":"Partly cloudy today and tomorrow"
    }
    ]
    }
     */
    public Weather(long id, String text) {
        this.id = id;
        this.text = text;
    }


    public long getId() {

        return id;
    }

    public String getText() {

        return  text;
    }


}

