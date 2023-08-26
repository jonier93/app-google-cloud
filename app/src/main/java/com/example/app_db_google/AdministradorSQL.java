package com.example.app_db_google;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorSQL {
    Connection objConexion;
    String url = "jdbc:mysql://34.173.176.245:3306/db_pruebas";
    String usuario = "jonier";
    String password = "123";

    String table = "usuarios";

    public boolean conectarSQL(){
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            objConexion = DriverManager.getConnection(url, usuario, password);
            return true;
        }
        catch (Exception ex) {
            Log.e("MyTag", ex.toString());
            return false;
        }
    }

    public boolean insertar_registro(int identificacion, String nombre, String email) {
        try {
            String instructionSQL = "INSERT INTO " + table + " VALUES("+identificacion+
                    ", '"+nombre+"', '"+email+"')";
            objConexion.prepareStatement(instructionSQL).execute();
            return true;
        }
        catch (Exception ex) {
            Log.e("MyTag", ex.toString());
            return false;
        }
    }

}
