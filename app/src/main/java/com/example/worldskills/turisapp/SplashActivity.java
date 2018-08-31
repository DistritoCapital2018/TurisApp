package com.example.worldskills.turisapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.turisapp.fragments.MainActivity;

public class SplashActivity extends AppCompatActivity {

    //Se instancian los componentes del layout.
    ImageView imgLogo;
    TextView tvWSS;

    Typeface typeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Instancio el componente junto con el xml.
        imgLogo = findViewById(R.id.imgLogoT);
        tvWSS = findViewById(R.id.tvWSS);

        typeface = Typeface.createFromAsset(getAssets(),"fonts/poorich.ttf");

        tvWSS.setTypeface(typeface);

        //Creo un nuevo hilo
        Thread hilo = new Thread(){

            //Creo el metodo run para que empiece a correr el splash.
            //Se coloca dentro de un try catch para que capture el error

            @Override
            public void run() {
                try {
                    //Duración del metodo run.
                    sleep(2000);
                    //Capturo el error
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Creo una una nueva intención, y lanzo la actividad.
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                //Finalizo el splash en caso de que el usuario se devuelva
                finish();
            }
        };
        //Inicio el hilo
        hilo.start();

    }
}
