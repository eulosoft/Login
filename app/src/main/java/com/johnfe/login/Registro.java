package com.johnfe.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.johnfe.login.R;

public class Registro extends AppCompatActivity {

      EditText et2,et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        et2= (EditText) findViewById(R.id.etuser);
        et3= (EditText) findViewById(R.id.etcontra);

    }
    public void registrar(View view){

        DBHelper admin=new DBHelper(this,"clase",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String usuario=et2.getText().toString();
        String contrasena=et3.getText().toString();


        db.execSQL("insert into usuarios (usuario,contrasena) values('"+usuario+"','"+contrasena+"')");
        db.close();

        Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
        Intent ven=new Intent(this,Main.class);
        startActivity(ven);

    }

    public void cancelar(View view){
        finish();

    }



}
