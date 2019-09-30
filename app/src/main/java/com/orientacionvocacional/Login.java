package com.orientacionvocacional;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Required;
import com.mobsandgeeks.saripaar.annotation.Select;

import idioma.varidioma;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class Login extends AppCompatActivity implements OnItemSelectedListener, Validator.ValidationListener {

    Validator validator;

    Profesiones pro=new Profesiones();
    varidioma clidioma=new varidioma();


    @Required(order=1, message = "Por favor ingrese un nombre")
    private EditText nombre2;

    @Select(order = 2, message = "Seleccione una opción")
    private Spinner spinner;



    String inicializado;
    Button mButton;
    Button mButton2;
    protected TextView customFont;
    protected TextView customFont2;
    protected TextView customFont3;
    protected TextView customFont4;
    protected TextView customFont5;
    protected TextView customFont6;
    protected TextView customFont7;
    private Button button;
    EditText Et1;
    String nombre;
    String genero = "";
    Spinner sp1;
    String edad;
    String rb;
    String item;
    RadioButton rb1;
    RadioButton rb2;
    public Locale locale;
    public Configuration config = new Configuration();
    String spinneridioma;


    private void showDialog(){

        final CharSequence[] photo = {"Ingles","Español"};

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Idioma");
        alert.setIcon(R.drawable.banderaidiomas);

        alert.setSingleChoiceItems(photo, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (photo[which] == "Ingles") {

                    locale = new Locale("en");
                    config.locale = locale;

                    getResources().updateConfiguration(config, null);
                    Intent refresh = new Intent(Login.this, Login.class);
                    startActivity(refresh);
                    clidioma.idioma="en";
                    spinneridioma="en";

                } else if (photo[which] == "Español") {
                    locale = new Locale("es");
                    config.locale = locale;

                    getResources().updateConfiguration(config, null);
                    Intent refresh = new Intent(Login.this, Login.class);
                    startActivity(refresh);
                   clidioma.idioma = "es";
                    spinneridioma="es";
                }
            }


        });

        alert.show();

    }



    public void RadioButtonClicked(View view) {
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        boolean checked = ((RadioButton) view).isChecked();
        rb1.setOnClickListener((View.OnClickListener) this);
        rb2.setOnClickListener((View.OnClickListener) this);


        switch (view.getId()) {
            case R.id.radioButton:
                genero = "Niño";

                break;
            case R.id.radioButton2:
                genero = "Niña";
                break;
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre2 = (EditText) findViewById(R.id.editText);
        spinner = (Spinner) findViewById(R.id.spinner);


        customFont = (Button) findViewById(R.id.button);
        Typeface font = Typeface.createFromAsset(getAssets(), "letras/gloriahallelujah.ttf");
        customFont.setTypeface(font);


        customFont2 = (TextView) findViewById(R.id.genero);
        customFont2.setTypeface(font);

        customFont3 = (EditText) findViewById(R.id.editText);
        customFont3.setTypeface(font);

        customFont4 = (RadioButton) findViewById(R.id.radioButton);
        customFont4.setTypeface(font);

        customFont5 = (RadioButton) findViewById(R.id.radioButton2);
        customFont5.setTypeface(font);

        customFont6 = (TextView) findViewById(R.id.titulo);
        customFont6.setTypeface(font);

        customFont7 = (Button) findViewById(R.id.button2);
        customFont7.setTypeface(font);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ;
        button = ((Button) findViewById(R.id.button2));

        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View vi) {
                        showDialog();
                    }
                });
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);



        if(spinneridioma.equals("es")){
            // Spinner Drop down elements
            List<String> categories = new ArrayList<String>();
            categories.add("Cuantos años tienes?");
            categories.add("4");
            categories.add("5");
            categories.add("6");
            categories.add("7");
            categories.add("8");
            categories.add("9");
            categories.add("10");
            categories.add("++");
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);

        }else{
// Spinner Drop down elements
            List<String> categories = new ArrayList<String>();
            categories.add("How years old??");
            categories.add("4");
            categories.add("5");
            categories.add("6");
            categories.add("7");
            categories.add("8");
            categories.add("9");
            categories.add("10");
            categories.add("++");
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);

        }


        final DataBaseManager manager = new DataBaseManager(this);
        mButton = (Button) findViewById(R.id.button);

        Et1 = (EditText) findViewById(R.id.editText);
        sp1 = (Spinner) findViewById(R.id.spinner);
        validator = new Validator(this);
        validator.setValidationListener(this);



        mButton.setOnClickListener(

                new View.OnClickListener() {
                    public void onClick(View view) {
                        RadioButton r1 = (RadioButton) findViewById(R.id.radioButton);
                        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
                        if (r1.isChecked() == false && r2.isChecked() == false) {
                            Toast.makeText(getApplicationContext(), "No selecciono ningun genero", Toast.LENGTH_SHORT).show();
                            validator.validate();
                        } else {
                            nombre = Et1.getText().toString();
                            edad = sp1.getSelectedItem().toString();
                            manager.insertar2(nombre, edad, genero);
                            Intent nuevo_form = new Intent (Login.this, Profesiones.class);
                            startActivity(nuevo_form);
                            if(clidioma.idioma!=("en") && clidioma.idioma!=("es")){
                                locale = new Locale("es");
                                config.locale = locale;
                                getResources().updateConfiguration(config, null);
                                Intent refresh = new Intent(Login.this, Login.class);
                                clidioma.idioma = "es";

                            }
                            pro.nombreus=nombre;
                        }
                    }
                });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Ha seleccionado : " + item, Toast.LENGTH_LONG).show();

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onValidationSucceeded(){


        Toast.makeText(this, "Ingreso Exitoso", Toast.LENGTH_SHORT).show();


    }



    @Override
    public void onValidationFailed(View view, Rule<?> rule) {
        final String failureMessage = rule.getFailureMessage();
        if (view instanceof EditText){
            EditText failed=(EditText) view;
            failed.requestFocus();
            failed.setError(failureMessage);
        }else{
            Toast.makeText(getApplicationContext(), failureMessage, Toast.LENGTH_SHORT).show();
        }
    }


}

