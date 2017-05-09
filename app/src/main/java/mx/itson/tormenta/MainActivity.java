package mx.itson.tormenta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buscar;
    EditText ciudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ciudad = (EditText) findViewById(R.id.ciudadtxt);

        buscar = (Button) findViewById(R.id.btnBuscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ciudadBuscada = ciudad.getText().toString();
                Intent intent = new Intent(getBaseContext(), DetalleActivity.class);
                intent.putExtra("CIUDAD", ciudadBuscada);
                startActivity(intent);
            }
        });

    }
}
