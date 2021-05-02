package com.example.login_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;


public class Sesion extends AppCompatActivity implements View.OnClickListener {
    TextView nombre;
    ImageButton BtnSalir, Btn_Ajustes, Btn_Evento;
    daoUsuario dao;
    int id=0;
    Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        nombre=(TextView)findViewById(R.id.nombre2);
        BtnSalir=(ImageButton)findViewById(R.id.CerrarSesion);
        BtnSalir.setOnClickListener(this);
        Btn_Ajustes=(ImageButton)findViewById(R.id.Btn_Ajustes);
        Btn_Ajustes.setOnClickListener(this);
        Btn_Evento=(ImageButton)findViewById(R.id.Btn_Evento);
        Btn_Evento.setOnClickListener(this);
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
            case R.id.Btn_Ajustes:
                Intent i3 = new Intent(Sesion.this, Configuracion.class);
                i3.putExtra("Id",u.getId());
                startActivity(i3);
                finish();
                break;
            case R.id.Btn_Evento:
                Intent i4 = new Intent(Sesion.this, Evento.class);
                i4.putExtra("Id",u.getId());
                startActivity(i4);
                finish();
                break;
        }
    }
}