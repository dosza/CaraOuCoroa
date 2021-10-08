package com.dosza.caraoucoroadz1309;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class EscolhaActivity extends AppCompatActivity {
    private int escolhaUsuario;
    private int escolhadoApp;

    public void setEscolhadoApp(int escolha){
        this.escolhadoApp = escolha;
    }

    public void setEscolhaUsuario(int escolha){
        this.escolhaUsuario = escolha;
    }

    public void setCara(View view){
       // Toast.makeText(getApplicationContext(),"Você escolheu cara!!",Toast.LENGTH_SHORT).show();
        setEscolhaUsuario(0);
        setEscolhadoApp(1);
        iniciaJogo();
    }
    public void setCoroa(View view){
        //Toast.makeText(getApplicationContext(),"Você escolheu coroa!!",Toast.LENGTH_SHORT).show();
        setEscolhaUsuario(1);
        setEscolhadoApp(0);
        iniciaJogo();
    }
    public void iniciaJogo(){
        Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
        intent.putExtra("numero", new Random().nextInt(2));
        intent.putExtra("usuarioescolha",escolhaUsuario);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);
    }
}
