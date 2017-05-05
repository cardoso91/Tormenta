package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Forecast implements JSONPopulator {

    private int code;
    private String date;
    private int high;
    private int low;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void populate(JSONObject data) {
        code = data.optInt("code");
        date = data.optString("date");
        high = data.optInt("high");
        low = data.optInt("low");
        description = data.optString("text");

    }
}
