package mx.itson.tormenta.data;

import org.json.JSONObject;

/**
 * Created by Cardoso on 5/4/17.
 */

public class Wind implements JSONPopulator {
    private int speed;
    private int direction;
    private String mWindBearing;

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public String getmWindBearing() {
        return mWindBearing;
    }

    @Override
    public void populate(JSONObject data) {
        speed = data.optInt("speed");
        direction = data.optInt("direction");

    }

    public void setWindBearing(double windBearing) {
        if (348.75 < windBearing && windBearing > 11.25) {
            this.mWindBearing = "N";
        }
        if (11.25 < windBearing && windBearing > 33.75) {
            this.mWindBearing = "NNE";
        }
        if (56.25 < windBearing && windBearing > 78.75) {
            this.mWindBearing = "NE";
        }
        if (33.75 < windBearing && windBearing > 56.25) {
            this.mWindBearing = "ENE";
        }
        if (78.75 < windBearing && windBearing > 101.25) {
            this.mWindBearing = "E";
        }
        if (101.25 < windBearing && windBearing > 123.75) {
            this.mWindBearing = "ESE";
        }
        if (123.75 < windBearing && windBearing > 146.25) {
            this.mWindBearing = "SE";
        }
        if (146.25 < windBearing && windBearing > 168.75) {
            this.mWindBearing = "SSE";
        }
        if (168.75 < windBearing && windBearing > 191.25) {
            this.mWindBearing = "S";
        }
        if (191.25 < windBearing && windBearing > 213.75) {
            this.mWindBearing = "SSO";
        }
        if (213.75 < windBearing && windBearing > 236.25) {
            this.mWindBearing = "SO";
        }
        if (236.25 < windBearing && windBearing > 258.75) {
            this.mWindBearing = "OSO";
        }
        if (258.75 < windBearing && windBearing > 281.25) {
            this.mWindBearing = "O";
        }
        if (281.25 < windBearing && windBearing > 303.75) {
            this.mWindBearing = "ONO";
        }
        if (303.75 < windBearing && windBearing > 326.25) {
            this.mWindBearing = "NO";
        }
        if (326.25 < windBearing && windBearing > 348.75) {
            this.mWindBearing = "NNO";
        }

    }

}
