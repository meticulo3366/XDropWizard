package org.knowm.xdropwizard.api;

/**
 * Created by Sua on 8/20/16.
 *
 * { "weather": "Partly Cloudy",
 "temperature_string": "66.3 F (19.1 C)",
 "temp_f": 66.3,
 "temp_c": 19.1,
 }

 */
public class Weather {

    private final String weather;
    private final String temperature_string;
    private final int temp_c;
    private final int temp_f;
    /**
     * Constructor
     *
     * @param content
     * @param content
     *
     * {
    "text": "It's 80 degrees right now.",
    "attachments": [
    {
    "text":"Partly cloudy today and tomorrow"
    }
    ]
    }
     */
    public Weather(String weather, int temp_c, int temp_f) {
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.weather = weather;
        this.temperature_string = Integer.toString(temp_f) + "F" + " (" + Integer.toString(temp_c) + " C)";
        System.out.print("TEMP STRING: " + temperature_string);
    }

//    public int getTempF() {
//        return temp_f;
//    }
//
//    public int getTempC() {
//        return temp_c;
//    }
//
//    public String getWeather() {
//        return weather;
//    }
//
//    public String getTemperatureString() {
//        return temperature_string;
//    }

    public String getText() {
        return  weather;
    }


}

