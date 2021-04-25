package com.example.login_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;


public class Sesion extends AppCompatActivity implements View.OnClickListener {
    TextView nombre;
    Button BtnSalir;
    daoUsuario dao;
    int id=0;
    Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        nombre=(TextView)findViewById(R.id.nombre2);
        BtnSalir=(Button)findViewById(R.id.CerrarSesion);
        BtnSalir.setOnClickListener(this);
        dao = new daoUsuario(this);
        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.CerrarSesion:
                Intent i2 = new Intent(Sesion.this, MainActivity.class);
                startActivity(i2);
                finish();
                break;
        }
    }
}