package com.vegas.labo7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vegas.labo7.Datos.Persona;
import com.vegas.labo7.entidades.DBHelper;

/**
 * Created by uca on 05-17-18.
 */

public class RegistrarActivity extends AppCompatActivity {
    private EditText txtId, txtNombre;
    private Button btnEnviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        //inicializando los constroles

        inicializarControles();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(
                        txtId.getText().toString(),
                        txtNombre.getText().toString()
                ));
                if (flag){
                    Log.d("Edit", txtNombre.getText().toString());
                }
            }
        });
    }

    public void inicializarControles(){
        btnEnviar = findViewById(R.id.btnRegistrar);
        txtId = findViewById(R.id.txtDui);
        txtNombre=findViewById(R.id.txtNombre);
    }
}
