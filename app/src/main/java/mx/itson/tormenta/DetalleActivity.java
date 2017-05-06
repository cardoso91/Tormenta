package mx.itson.tormenta;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mx.itson.tormenta.data.Admosphere;
import mx.itson.tormenta.data.Channel;
import mx.itson.tormenta.data.Item;
import mx.itson.tormenta.data.Wind;
import mx.itson.tormenta.service.WeatherServiceCallback;
import mx.itson.tormenta.service.YahooWeatherService;

public class DetalleActivity extends AppCompatActivity implements WeatherServiceCallback {

    private YahooWeatherService service;
    private ProgressDialog dialog;

    TextView descripcionClimaActual;
    TextView temperaturaActual;
    ImageView imagenClimaActual;
    TextView ubicacion;

    TextView bajaActual;
    TextView altaActual;

    TextView humedad;
    TextView velocidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        descripcionClimaActual = (TextView) findViewById(R.id.descripcionClimaActualtxt);
        temperaturaActual = (TextView) findViewById(R.id.temperaturaActualtxt);
        imagenClimaActual = (ImageView) findViewById(R.id.imagenClimaActual);
        ubicacion = (TextView) findViewById(R.id.ubicaciontxt);

        //bajaActual = (TextView) findViewById(R.id.bajaActualtxt);
        //altaActual = (TextView) findViewById(R.id.altaActualtxt);

        humedad = (TextView) findViewById(R.id.humedadtxt);
        velocidad = (TextView) findViewById(R.id.velocidadtxt);

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
        Admosphere admosphere = new Admosphere();
        Wind wind = new Wind();

        //int resourceId = getResources().getIdentifier("drawable/icon_" + channel.getItem().getCondition().getCode(), null, getPackageName());
        //@SuppressWarnings("deprecation")
        //Drawable iconoClima = getResources().getDrawable(resourceId);
        //imagenClimaActual.setImageDrawable(iconoClima);

        descripcionClimaActual.setText(item.getCondition().getDescription());
        temperaturaActual.setText(item.getCondition().getTemperature() + "\u00b0" + channel.getUnits().getTemperature());
        ubicacion.setText(service.getLocation());

        humedad.setText(admosphere.getHumidity() + " " + "%");
        velocidad.setText(wind.getSpeed() + " " + channel.getUnits().getSpeed());


    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
