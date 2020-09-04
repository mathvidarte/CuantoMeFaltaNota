package com.example.cuantomefaltanota;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class Config extends AppCompatActivity {

private Button btnAzul;
private Button btnBlanco;
private Button btnNegro;
private ConstraintLayout backConfig;
private String colores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        btnAzul = findViewById(R.id.btnAzul);
        btnBlanco = findViewById(R.id.btnBlanco);
        btnNegro = findViewById(R.id.btnNegro);
        backConfig = findViewById(R.id.backConfig);

        SharedPreferences fondo = getSharedPreferences("locker",MODE_PRIVATE);
                colores = fondo.getString("colors", "NO_COLOR");

        if (colores.equals("Amarillo")) {
            backConfig.setBackgroundColor(Color.rgb(241,246,0));
        }

        if (colores.equals("Rosa")) {
            backConfig.setBackgroundColor(Color.rgb(156,0,159));
        }
        if (colores.equals("Blanco")) {
            backConfig.setBackgroundColor(Color.rgb(255,255,255));
        }

        btnAzul.setOnClickListener(
                (v) -> {
                    Intent i = new Intent();
                    i.putExtra("color", "Amarillo");
                    setResult(RESULT_OK, i);
                    finish();
                }
        );

        btnNegro.setOnClickListener(
                (v) -> {
                    Intent n = new Intent();
                    n.putExtra("color", "Rosa");
                    setResult(RESULT_OK, n);
                    finish();
                }
        );

        btnBlanco.setOnClickListener(
                (v) -> {
                    Intent b = new Intent();
                    b.putExtra("color", "Blanco");
                    setResult(RESULT_OK, b);
                    finish();
                }
        );



    }




}