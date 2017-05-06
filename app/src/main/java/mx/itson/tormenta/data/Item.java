package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Item implements JSONPopulator {

    private Condition condition = new Condition();
    private Forecast forecast = new Forecast();

    public Forecast getForecast() {
        return forecast;
    }

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition.populate(data.optJSONObject("condition"));

        //forecast.populate(data.optJSONObject("forecast"));


    }
}
