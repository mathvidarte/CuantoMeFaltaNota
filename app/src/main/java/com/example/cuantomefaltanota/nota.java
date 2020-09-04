package com.example.cuantomefaltanota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class nota extends AppCompatActivity {

    private TextView mensajeNombre;
    private TextView nota;
    private Button btnAgain;
    private ConstraintLayout backNota;
    private String colores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        mensajeNombre = findViewById(R.id.mensajeNombre);
        nota = findViewById(R.id.nota);
        btnAgain = findViewById(R.id.btnAgain);
        backNota = findViewById(R.id.backNota);

        SharedPreferences fondo = getSharedPreferences("locker",MODE_PRIVATE);
        colores = fondo.getString("colors", "NO_COLORES");

        if (colores.equals("Amarillo")) {
            backNota.setBackgroundColor(Color.rgb(241,246,0));
        }

        if (colores.equals("Rosa")) {
            backNota.setBackgroundColor(Color.rgb(156,0,159));
        }
        if (colores.equals("Blanco")) {
            backNota.setBackgroundColor(Color.rgb(255,255,255));
        }

        String name = getSharedPreferences("misNombres", MODE_PRIVATE).getString("nombres", "NO_USER");


        mensajeNombre.setText("Hola,"+" "+name+"."+" "+"Tu nota final es de:");

        double note = getIntent().getExtras().getDouble("notas");
        DecimalFormat decimales = new DecimalFormat("#.00");

        nota.setText(""+decimales.format(note));

        btnAgain.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, MainActivity.class);

                    startActivity(i);
                }
        );

    }
}