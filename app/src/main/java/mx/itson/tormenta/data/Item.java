package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Item implements JSONPopulator {
    public Condition getCondition() {
        return condition;
    }

    private Condition condition;

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}
