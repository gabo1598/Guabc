package com.example.login_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
    EditText us, pass;
    Button reg, can;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        us=(EditText)findViewById(R.id.nombre);
        pass=(EditText)findViewById(R.id.pass);
        reg=(Button)findViewById(R.id.Registrar);
        can=(Button)findViewById(R.id.Cancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao = new daoUsuario(this);
        

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Registrar:
                Usuario u =new Usuario();
                u.setNombre(us.getText().toString());
                u.setPassword(pass.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this, "Error: Campos vacios", Toast.LENGTH_SHORT).show();
                }
                else if(dao.insertUsuario(u)){
                    Toast.makeText(this, "Quedaste registrado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Ya existe!!!!!!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.Cancelar:
                Intent i = new Intent(Registrar.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}