package mx.itson.tormenta;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mx.itson.tormenta.data.Astronomy;
import mx.itson.tormenta.data.Atmosphere;
import mx.itson.tormenta.data.Channel;
import mx.itson.tormenta.data.Day;
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
    TextView direccion;

    TextView sunrise;
    TextView sunset;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        descripcionClimaActual = (TextView) findViewById(R.id.descripcionClimaActualtxt);
        temperaturaActual = (TextView) findViewById(R.id.temperaturaActualtxt);
        imagenClimaActual = (ImageView) findViewById(R.id.imagenClimaActual);
        imagenClimaActual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //service.refreshWeather();
                Toast.makeText(DetalleActivity.this,
                        "Tranquilo viejo... Cargando...",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ubicacion = (TextView) findViewById(R.id.ubicaciontxt);

        bajaActual = (TextView) findViewById(R.id.bajaActualtxt);
        altaActual = (TextView) findViewById(R.id.altaActualtxt);

        humedad = (TextView) findViewById(R.id.humedadtxt);
        velocidad = (TextView) findViewById(R.id.velocidadtxt);
        direccion = (TextView) findViewById(R.id.direcciontxt);

        sunrise = (TextView) findViewById(R.id.sunrisetxt);
        sunset = (TextView) findViewById(R.id.sunsettxt);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("CIUDAD");
            //The key argument here must match that used in the other activity
            service.refreshWeather(value);
        }

    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();
        Atmosphere atmosphere = channel.getAtmosphere();
        Wind wind = channel.getWind();
        Astronomy astronomy = channel.getAstronomy();
        Day day = new Day();

        int resourceId = getResources().getIdentifier("drawable/icon_" + channel.getItem().getCondition().getCode(), null, getPackageName());
        @SuppressWarnings("deprecation")
        Drawable iconoClima = getResources().getDrawable(resourceId);
        imagenClimaActual.setImageDrawable(iconoClima);

        descripcionClimaActual.setText(item.getCondition().getDescription());
        temperaturaActual.setText(item.getCondition().getTemperature() + "\u00b0" + channel.getUnits().getTemperature());
        ubicacion.setText(service.getLocation());

        //bajaActual.setText(day.setCode(item.getForecast().getLong(Integer.parseInt("code"))));

        humedad.setText(atmosphere.getHumidity() + " " + "%");
        velocidad.setText(wind.getSpeed() + " " + channel.getUnits().getSpeed());
        int direccionLista = wind.getDirection();
        wind.setWindBearing(direccionLista);
        direccion.setText(wind.getmWindBearing());


        sunrise.setText(astronomy.getSunrise().toString());
        sunset.setText(astronomy.getSunset().toString());

    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }


}
