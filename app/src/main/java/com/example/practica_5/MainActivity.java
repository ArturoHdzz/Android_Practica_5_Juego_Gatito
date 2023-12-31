package com.example.practica_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button[][] botones = new Button[3][3];
    boolean turnoJugador1 = true;
    int contadorRondas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botones[0][0] = findViewById(R.id.btn1);
        botones[0][1] = findViewById(R.id.btn2);
        botones[0][2] = findViewById(R.id.btn3);
        botones[1][0] = findViewById(R.id.btn4);
        botones[1][1] = findViewById(R.id.btn5);
        botones[1][2] = findViewById(R.id.btn6);
        botones[2][0] = findViewById(R.id.btn7);
        botones[2][1] = findViewById(R.id.btn8);
        botones[2][2] = findViewById(R.id.btn9);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Button boton = (Button) v;
        if (!boton.getText().toString().isEmpty()) {

            return;
        }

        if (turnoJugador1) {
            boton.setText("X");
        } else {
            boton.setText("O");
        }

        contadorRondas++;
        Bundle enviaDatos = new Bundle();

        if (comprobarGanador()) {
            String ganador = turnoJugador1 ? "Jugador 1 (X)" : "Jugador 2 (O)";
            mostrarMensaje(ganador + " gana!");
            reiniciarTablero();
            enviaDatos.putString("KEY", ganador);
            Intent i = new Intent(MainActivity.this, MainActivity3.class);
            i.putExtras(enviaDatos);
            startActivity(i);
        } else if (contadorRondas == 9) {
            mostrarMensaje("Empate");
            reiniciarTablero();
            enviaDatos.putString("KEY", "Empate");
            Intent i = new Intent(MainActivity.this, MainActivity3.class);
            i.putExtras(enviaDatos);
            startActivity(i);
        } else {
            turnoJugador1 = !turnoJugador1;
        }
    }

    private boolean comprobarGanador() {
        String jugadorActual = turnoJugador1 ? "X" : "O";


        for (int i = 0; i < 3; i++) {

            if (botones[i][0].getText().equals(jugadorActual) &&
                    botones[i][1].getText().equals(jugadorActual) &&
                    botones[i][2].getText().equals(jugadorActual)) {
                return true;
            }


            if (botones[0][i].getText().equals(jugadorActual) &&
                    botones[1][i].getText().equals(jugadorActual) &&
                    botones[2][i].getText().equals(jugadorActual)) {
                return true;
            }
        }


        if (botones[0][0].getText().equals(jugadorActual) &&
                botones[1][1].getText().equals(jugadorActual) &&
                botones[2][2].getText().equals(jugadorActual)) {
            return true;
        }

        if (botones[0][2].getText().equals(jugadorActual) &&
                botones[1][1].getText().equals(jugadorActual) &&
                botones[2][0].getText().equals(jugadorActual)) {
            return true;
        }

        return false;
    }


    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void reiniciarTablero() {

        contadorRondas = 0;
        turnoJugador1 = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j].setText("");
            }
        }
    }
}
