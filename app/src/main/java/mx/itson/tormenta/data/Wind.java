package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Wind implements JSONPopulator {
    private int speed;
    private int direction;

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public void populate(JSONObject data) {
        speed = data.optInt("speed");

    }
}
