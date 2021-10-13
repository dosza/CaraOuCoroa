package com.dosza.caraoucoroadz1309.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dosza.caraoucoroadz1309.Control.CaraCoroaJogo;
import com.dosza.caraoucoroadz1309.Control.Pontuacao;
import com.dosza.caraoucoroadz1309.R;



public class EscolhaActivity extends AppCompatActivity {
    private TextView textVitorias;
    private TextView textDerrotas;
    private Pontuacao pontuacao;

    public void iniciaJogo(int escolha){
        Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
        intent.putExtra("escolhaUsuario",escolha);
        startActivity(intent);
        atualizaVisualizacaoPlacar();
    }

    public void atualizaVisualizacaoPlacar(){
        textVitorias.setText("Vitórias: "+ String.valueOf(pontuacao.getQtVitorias()));
        textDerrotas.setText("Derrotas: "+ String.valueOf(pontuacao.getQtDerrotas()));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);
        textDerrotas = findViewById(R.id.textDerrotas);
        textVitorias = findViewById(R.id.textVitorias);
        pontuacao = Pontuacao.getInstance();
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

    @Override
    protected void onStart() {
        super.onStart();
        atualizaVisualizacaoPlacar();
    }

    public void abrirDialog(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.AlertDialog); // esse metodo usa o contexto da activity atual (this),
        dialog.setTitle("Resetar placar");
        dialog.setMessage("Gostaria de resetar o placar?");
        dialog.setCancelable(true);
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        dialog.setPositiveButton("sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pontuacao.resetPontuacao();
                atualizaVisualizacaoPlacar();
            }
        });


        dialog.setNegativeButton("não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.create();
        dialog.show();
    }
}
