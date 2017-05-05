package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Channel implements JSONPopulator {
    private Item item;
    private Units units;
    private Admosphere admosphere;
    private Astronomy astronomy;
    private Wind wind;

    public Item getItem() {
        return item;
    }

    public Units getUnits() {
        return units;
    }

    public Admosphere getAdmosphere() {
        return admosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public Wind getWind() {
        return wind;
    }

    @Override
    public void populate(JSONObject data) {

        units = new Units();
        units.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate(data.optJSONObject("item"));


    }
}
