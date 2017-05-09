package mx.itson.tormenta.data;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Forecast extends JSONArray {

    private String day1;
    private String day2;
    private String day3;
    private String day4;

    public String getDay1() {
        return day1;
    }

    public String getDay2() {
        return day2;
    }

    public String getDay3() {
        return day3;
    }

    public String getDay4() {
        return day4;
    }


    public void populate(JSONArray data) {
        day1 = data.optString(0);
        day2 = data.optString(1);
        day3 = data.optString(2);
        day4 = data.optString(3);

    }

}
