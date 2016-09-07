package com.johnfe.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.johnfe.login.R;

public class Main extends AppCompatActivity {

    EditText etUsuario, etPassword;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etUsuario= (EditText) findViewById(R.id.etusuario);
        etPassword = (EditText) findViewById(R.id.etcontrasena);
    }

    public void ingresar(View v){
        DBHelper admin=new DBHelper(this,"clase",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario=etUsuario.getText().toString();
        String contrasena= etPassword.getText().toString();
        fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'",null);

        if (fila.moveToFirst()){
            String usua=fila.getString(0);
            String pass=fila.getString(1);
            if (usuario.equals(usua)&&contrasena.equals(pass)){
                Intent ven=new Intent(this,Menu.class);
                startActivity(ven);
                etUsuario.setText("");
                etPassword.setText("");
            }

        }



    }
    public void registro(View v){
        Intent ven=new Intent(this,Registro.class);
        startActivity(ven);
    }

    public void salir(View v){
   finish();
        //System.exit(0);
    }
}
