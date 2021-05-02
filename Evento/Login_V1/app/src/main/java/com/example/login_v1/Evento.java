package com.example.login_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Evento extends AppCompatActivity implements View.OnClickListener {
    daoUsuario dao;
    int id=0;
    Usuario u;
    Button Btn_Regresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        Btn_Regresa=(Button)findViewById(R.id.regresar);
        Btn_Regresa.setOnClickListener(this);
        dao = new daoUsuario(this);
        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        u=dao.getUsuarioById(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regresar:
                Intent i = new Intent(Evento.this, Sesion.class);
                i.putExtra("Id",u.getId());
                startActivity(i);
                finish();
                break;
        }
    }
}