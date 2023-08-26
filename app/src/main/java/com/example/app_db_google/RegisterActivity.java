package com.example.app_db_google;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.app_db_google.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    ModelUser objUser;

    AdministradorSQL objBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicializar();

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int identification = Integer.parseInt(binding.txtIdentification.getText().toString());
                    String name = binding.txtName.getText().toString();
                    String email = binding.txtEmail.getText().toString();
                    objUser = new ModelUser(identification, name, email);
                    control_base();
                }
                catch (Exception ex) {
                    Log.e("MyTag", ex.toString());
                    Toast.makeText(RegisterActivity.this, "Error al ingresar datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializar() {
        objBase = new AdministradorSQL();
    }

    private void control_base() {
        boolean confirmacion_conexion = objBase.conectarSQL();
        if (confirmacion_conexion) {
            boolean confirmacion_registro = objBase.insertar_registro(objUser.getIdentification(), objUser.getName(),
                    objUser.getEmail());
            if (confirmacion_registro) {
                Toast.makeText(RegisterActivity.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(RegisterActivity.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(RegisterActivity.this, "Error en la conexión a google cloud", Toast.LENGTH_SHORT).show();
        }
    }
}