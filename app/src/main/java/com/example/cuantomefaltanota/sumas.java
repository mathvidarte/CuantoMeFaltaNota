package com.example.cuantomefaltanota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class sumas extends AppCompatActivity {

    private EditText proyectoUno;
    private EditText proyectoDos;
    private EditText quices;
    private EditText parcialUno;
    private EditText parcialDos;
    private EditText ejercicios;
    private Button btnCalcular;
    private ConstraintLayout backCalcular;
    private String colores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumas);

        proyectoUno = findViewById(R.id.proyectoUno);
        proyectoDos = findViewById(R.id.proyectoDos);
        quices = findViewById(R.id.quices);
        parcialUno = findViewById(R.id.parcialUno);
        parcialDos = findViewById(R.id.parcialDos);
        ejercicios = findViewById(R.id.ejercicios);
        btnCalcular =findViewById(R.id.btnCalcular);
        backCalcular = findViewById(R.id.backCalcular);

        SharedPreferences fondo = getSharedPreferences("locker",MODE_PRIVATE);
        colores = fondo.getString("colors", "NO_COLORES");

        if (colores.equals("Amarillo")) {
            backCalcular.setBackgroundColor(Color.rgb(241,246,0));
        }

        if (colores.equals("Rosa")) {
            backCalcular.setBackgroundColor(Color.rgb(156,0,159));
        }
        if (colores.equals("Blanco")) {
            backCalcular.setBackgroundColor(Color.rgb(255, 255, 255));
        }

        btnCalcular.setOnClickListener(
                (v) -> {

                    String proyectoOne = proyectoUno.getText().toString();
                    double one = Double.parseDouble(proyectoOne);
                    String proyectoTwo = proyectoDos.getText().toString();
                    double two = Double.parseDouble(proyectoTwo);
                    String quiz = quices.getText().toString();
                    double quizz = Double.parseDouble(quiz);
                    String parcialOne = parcialUno.getText().toString();
                    double pOne = Double.parseDouble(parcialOne);
                    String parcialTwo = parcialDos.getText().toString();
                    double pTwo = Double.parseDouble(parcialTwo);
                    String ejercicio = ejercicios.getText().toString();
                    double ejer = Double.parseDouble(ejercicio);

                    double nota = (one*0.25) + (two*0.25) + (quizz*0.15) + (pOne*0.15) + (pTwo*0.15) + (ejer*0.05);

                    Intent i = new Intent(this, nota.class);


                    i.putExtra("notas", nota);


                    startActivity(i);
                }
        );
    }
}