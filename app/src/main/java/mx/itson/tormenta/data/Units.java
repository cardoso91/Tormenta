package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Units implements JSONPopulator {
    private String temperature;
    private String speed;

    public String getTemperature() {
        return temperature;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");
        speed = data.optString("speed");

    }
}
