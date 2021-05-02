package com.example.login_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass;
    Button BtnEntrar, BtnRegistrar;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.editTextTextPersonName);
        pass=(EditText)findViewById(R.id.editTextTextPassword); 
        BtnEntrar=(Button)findViewById(R.id.button);
        BtnEntrar.setOnClickListener(this);
        BtnRegistrar=(Button)findViewById(R.id.Registrar1);
        BtnRegistrar.setOnClickListener(this);
        dao = new daoUsuario(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this,"Error: Campos vacios", Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1){
                    Usuario ux = dao.getUsuario(u, p);
                    Toast.makeText(this,"Bienvenido", Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(MainActivity.this,Sesion.class);
                    i2.putExtra("Id",ux.getId());
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this,"usuario y/o password incorrecto", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.Registrar1:
                Intent i=new Intent(MainActivity.this,Registrar.class);
                startActivity(i);
                break;
        }
    }
}