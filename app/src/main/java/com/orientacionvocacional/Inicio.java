package com.orientacionvocacional;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by intel on 5/21/2016.
 */
public class Inicio extends Activity {
    public static String inicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        WifiManager wifimgr =(WifiManager)getSystemService(Context.WIFI_SERVICE);
        if (wifimgr.isWifiEnabled()){

            Thread timer = new Thread() {
                public void run() {
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                        Intent openMainActivity2 = new Intent(Inicio.this, Login.class);
                        startActivity(openMainActivity2);

                    }
                }
            };
            timer.start();
        }else{

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Orientacion Vocacional");
            alertDialog.setMessage("Esta app necesita de internet, por favor verficar la conexión.");

            alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {



                public void onClick(DialogInterface dialog, int which) {

                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));

                }
            });

            alertDialog.show();

        }









    }



    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }



}