package com.orientacionvocacional;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import idioma.varidioma;

public class Profesiones extends AppCompatActivity {
    public static String nombreus;

    TextView nombre;
    protected TextView customFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesiones);

        customFont = (TextView) findViewById(R.id.textView12);
        Typeface font = Typeface.createFromAsset(getAssets(), "letras/gloriahallelujah.ttf");
        customFont.setTypeface(font);

        nombre = (TextView) findViewById(R.id.textView12);
        nombre.setText("Bienvenido: " + nombreus);
        findViewById(R.id.medico).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profesiones.this, FullscreenMedico.class));
            }
        });
        findViewById(R.id.veterinario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profesiones.this, FullscreenVeterinario.class));
            }
        });

        findViewById(R.id.policia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profesiones.this, FullscreenPolicia.class));
            }
        });
        findViewById(R.id.cantante).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profesiones.this, FullscreenCantante.class));
            }
        });
        findViewById(R.id.ingeniero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profesiones.this, FullscreenIngeniero.class));
            }
        });
        findViewById(R.id.bombero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profesiones.this, FullscreenBombero.class));
            }
        });


    }
}
