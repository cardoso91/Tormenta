package mx.itson.tormenta;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mx.itson.tormenta.data.Channel;
import mx.itson.tormenta.service.WeatherServiceCallback;
import mx.itson.tormenta.service.YahooWeatherService;

public class DetalleActivity extends AppCompatActivity implements WeatherServiceCallback {

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Austin,TX");
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
