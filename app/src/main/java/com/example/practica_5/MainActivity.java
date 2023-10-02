package com.example.practica_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1.findViewById(R.id.btn1);
        btn2.findViewById(R.id.btn2);
        btn3.findViewById(R.id.btn3);
        btn4.findViewById(R.id.btn4);
        btn5.findViewById(R.id.btn5);
        btn6.findViewById(R.id.btn6);
        btn7.findViewById(R.id.btn7);
        btn8.findViewById(R.id.btn8);
        btn9.findViewById(R.id.btn9);
    }

    @Override
    public void onClick(View v) {

    }
}