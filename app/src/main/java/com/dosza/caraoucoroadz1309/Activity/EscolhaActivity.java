package com.dosza.caraoucoroadz1309.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dosza.caraoucoroadz1309.Control.CaraCoroaJogo;
import com.dosza.caraoucoroadz1309.R;

public class EscolhaActivity extends AppCompatActivity {
    public void iniciaJogo(int escolha){
        Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
        intent.putExtra("escolhaUsuario",escolha);
        startActivity(intent);
    }

    public void botaoSair(View view){
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);
    }
    public void escolheCara(View view){
        iniciaJogo(CaraCoroaJogo.CARA);
    }
    public void escolhaCoroa(View view){
        iniciaJogo(CaraCoroaJogo.COROA);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
