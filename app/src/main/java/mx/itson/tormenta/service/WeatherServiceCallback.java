package mx.itson.tormenta.service;

import mx.itson.tormenta.data.Channel;

/**
 * Created by Cardoso on 5/4/17.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
