package com.vegas.labo7.entidades;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vegas.labo7.Datos.Persona;
import com.vegas.labo7.R;

/**
 * Created by uca on 05-17-18.
 */

public class ModificarActivity extends AppCompatActivity {

    private EditText id, nombre;
    private Button btnBuscar, btnEliminar, btnActualizar, btnLimpiar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        //seteamos controladores
        inicializarControles();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = DBHelper.myDB.findUser(id.getText().toString());
                if (p==null){
                    Toast.makeText(getApplicationContext(), "El usuario no fue encontrado", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    nombre.setText(p.getNombre());
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(),
                        nombre.getText().toString()));
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                limpiar();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });


    }

    public void inicializarControles(){
        id= findViewById(R.id.txtIdM);
        nombre = findViewById(R.id.txtNombreM);
        btnBuscar = findViewById(R.id.btnBuscarM);
        btnEliminar = findViewById(R.id.btnEliminarM);
        btnActualizar = findViewById(R.id.btnActualizarM);
        btnLimpiar = findViewById(R.id.btnLimpiarM);
    }

    public  void limpiar(){
        nombre.setText("");
        id.setText("");
    }

}
