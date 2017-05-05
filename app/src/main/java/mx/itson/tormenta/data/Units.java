package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");

    }
}
