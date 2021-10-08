package com.cursoandroid.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        Toast.makeText(getApplicationContext(),"Você escolheu cara!!",Toast.LENGTH_SHORT).show();
        setEscolhaUsuario(0);
        setEscolhadoApp(1);
    }
    public void setCoroa(View view){
        Toast.makeText(getApplicationContext(),"Você escolheu coroa!!",Toast.LENGTH_SHORT).show();
        setEscolhaUsuario(1);
        setEscolhadoApp(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);
    }
}
