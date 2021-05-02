package com.example.login_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Configuracion extends AppCompatActivity implements View.OnClickListener{
    Button BtnRegresar;
    daoUsuario dao;
    int id=0;
    Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        BtnRegresar=(Button)findViewById(R.id.Btnregresar);
        BtnRegresar.setOnClickListener(this);
        dao = new daoUsuario(this);
        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        u=dao.getUsuarioById(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Btnregresar:
                Intent i = new Intent(Configuracion.this, Sesion.class);
                i.putExtra("Id",u.getId());
                startActivity(i);
                finish();
                break;
        }
    }
}