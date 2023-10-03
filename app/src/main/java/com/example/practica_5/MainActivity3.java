package com.example.practica_5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    TextView textView3;
    TextView textView5;

    static int puntosJugador1 = 0;
    static int puntosJugador2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);

        Bundle recibe = getIntent().getExtras();
        String valorRecibido = recibe.getString("KEY");

        if ("Jugador 1 (X)".equals(valorRecibido)) {
            puntosJugador1++;
        }
        if ("Jugador 2 (O)".equals(valorRecibido)) {
            puntosJugador2++;
        }

        textView3.setText("" + puntosJugador1);
        textView5.setText("" + puntosJugador2);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn1) {
            Intent i = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(i);
        }
    }
}
