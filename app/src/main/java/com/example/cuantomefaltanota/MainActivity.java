package com.example.cuantomefaltanota;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button btnContinuar;
    private Button btnConfig;
    private ConstraintLayout backG;
    private String colores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        btnConfig = findViewById(R.id.btnConfig);
        btnContinuar = findViewById(R.id.btnContinuar);
        backG = findViewById(R.id.backG);

        btnContinuar.setOnClickListener(
                (v) -> {

                    String myName = name.getText().toString();

                    Intent i = new Intent(this, sumas.class);



                    SharedPreferences preferences = getSharedPreferences("misNombres",MODE_PRIVATE);
                    preferences.edit().putString("nombres", myName).apply();

                    SharedPreferences prefereness = getSharedPreferences("locker", MODE_PRIVATE);
                    prefereness.edit().putString("colors", colores).apply();

                    startActivity(i);

                }
        );

        btnConfig.setOnClickListener(

                    (v) -> {

                        SharedPreferences preferences = getSharedPreferences("locker", MODE_PRIVATE);
                        preferences.edit().putString("colors", colores).apply();


                        Intent i = new Intent(this, Config.class);

                        startActivityForResult(i,11);



                    }

        );



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == RESULT_OK) {
           // Toast.makeText(this, "Azul", Toast.LENGTH_LONG).show();
            colores = data.getExtras().getString("color");
            if (colores.equals("Amarillo")) {
                backG.setBackgroundColor(Color.rgb(241,246,0));
            }
            if (colores.equals("Rosa")) {
                backG.setBackgroundColor(Color.rgb(156,0,159));
            }
            if (colores.equals("Blanco")) {
                backG.setBackgroundColor(Color.rgb(255,255,255));
            }
        }

    }
}