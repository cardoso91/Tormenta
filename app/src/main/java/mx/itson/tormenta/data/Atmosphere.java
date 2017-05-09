package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Atmosphere implements JSONPopulator {
    private int humidity;
    private int pressure;

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    @Override
    public void populate(JSONObject data) {
        humidity = data.optInt("humidity");
        pressure = data.optInt("pressure");

    }
}
