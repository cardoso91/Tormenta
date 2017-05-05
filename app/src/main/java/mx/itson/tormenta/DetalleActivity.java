package mx.itson.tormenta;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mx.itson.tormenta.data.Channel;
import mx.itson.tormenta.data.Item;
import mx.itson.tormenta.service.WeatherServiceCallback;
import mx.itson.tormenta.service.YahooWeatherService;

public class DetalleActivity extends AppCompatActivity implements WeatherServiceCallback {

    private YahooWeatherService service;
    private ProgressDialog dialog;

    TextView descripcionClimaActual;
    TextView temperaturaActual;
    ImageView imagenClimaActual;
    TextView ubicacion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        descripcionClimaActual = (TextView) findViewById(R.id.descripcionClimaActual);
        temperaturaActual = (TextView) findViewById(R.id.temperaturaActual);
        imagenClimaActual = (ImageView) findViewById(R.id.imagenClimaActual);
        ubicacion = (TextView) findViewById(R.id.ubicacion);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Austin,TX");
    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();

        //int resourceId = getResources().getIdentifier("drawable/icon_" + channel.getItem().getCondition().getCode(), null, getPackageName());

        //@SuppressWarnings("deprecation")
        //Drawable iconoClima = getResources().getDrawable(resourceId);

        //imagenClimaActual.setImageDrawable(iconoClima);
        descripcionClimaActual.setText(item.getCondition().getDescription());
        temperaturaActual.setText(item.getCondition().getTemperature() + "uDOBO" + channel.getUnits().getTemperature());
        ubicacion.setText(service.getLocation());
    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
