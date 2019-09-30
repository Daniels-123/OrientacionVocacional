package com.orientacionvocacional;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ahorcadopoli extends Activity {
    String pl;
    static String mWord;
    int nFails = 0;
    int aciertos = 0;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcadopoli);
        setRandomWord();
    }

    public void introduceLetter(View v){
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString();

        myEditText.setText("");

        if(letter.length() == 1){

            checkLetter(letter.toUpperCase());

        } else {
            Toast.makeText(this, "No es valido o no ha introducido nada", Toast.LENGTH_SHORT).show();
            Vibrator c = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            c.vibrate(3000);

        }
    }
    public void checkLetter(String letter) {

        char letterIntroduced = letter.charAt(0);
        boolean checkletter = false;

        for (int i = 0; i < mWord.length(); i++) {
            if (mWord.charAt(i) == letterIntroduced) {
                checkletter = true;
                points++;
                aciertos++;
                showLettersAtIndex(i, letterIntroduced);
            }
        }

        if (!checkletter) {
            letterFailed(letter);
        }
        if (aciertos == mWord.length()) {

            clearScreen();
            setRandomWord();

            Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            v.vibrate(3000);
            AlertDialog alertDialog4 = new AlertDialog.Builder(this).create();
            alertDialog4.setTitle("Orientacion Vocacional");
            alertDialog4.setMessage(" Tus puntos fueron " + points + " puntos"+'\n'+"Te has equivocado "+ nFails+" veces");

            alertDialog4.setButton("Aceptar", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });

            alertDialog4.setIcon(R.mipmap.policia);
            alertDialog4.show();


        }
    }
    public void clearScreen(){
        TextView failsLettersView = (TextView) findViewById(R.id.failsLetter);
        failsLettersView.setText("");

        aciertos=0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        for( int i = 0; i < layoutLetters.getChildCount(); i++){
            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");
        }
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.ahorcado2);
    }
    public void letterFailed(String letter){
        nFails++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView failsLettersView = (TextView) findViewById(R.id.failsLetter);
        String failsLetters = failsLettersView.getText().toString();

        failsLettersView.setText(failsLetters + letter);

        switch (nFails) {
            case 1:
                imageView.setImageResource(R.mipmap.ahorcado0);
                break;
            case 2:
                imageView.setImageResource(R.mipmap.ahorcado1);
                break;
            case 3:
                imageView.setImageResource(R.mipmap.ahorcado2);
                break;
            case 4:
                imageView.setImageResource(R.mipmap.ahorcado3);
                break;
            case 5:
                imageView.setImageResource(R.mipmap.ahorcado4);
                break;
            case 6:
                imageView.setImageResource(R.mipmap.ahorcado5);
                break;
            case 7:
                imageView.setImageResource(R.mipmap.ahorcado6);
                break;

            case 8:
                imageView.setImageResource(R.mipmap.ahorcado7);

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Orientacion Vocacional");
                alertDialog.setMessage("Has acertado " + aciertos + " veces" + '\n' + "Te has equivocado " + nFails + " veces");
                alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialog.setIcon(R.mipmap.policia);
                alertDialog.show();

                Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                v.vibrate(3000);
        }

    }


    public void showLettersAtIndex(int position, char letter){

        Log.d("Prueba", "Entra");

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letter));
    }

    public void setRandomWord(){
        String words = "PROTEGER GUARDIAN ";

        String[] arrayWords = words.split(" ");

        int random = (int) (Math.random() * arrayWords.length);

        mWord = arrayWords[random];

    }
    public void puntaje(){

    }

}
