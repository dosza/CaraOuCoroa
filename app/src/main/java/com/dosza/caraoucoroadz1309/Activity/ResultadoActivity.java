package com.dosza.caraoucoroadz1309.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dosza.caraoucoroadz1309.Control.CaraCoroaJogo;
import com.dosza.caraoucoroadz1309.Control.Pontuacao;
import com.dosza.caraoucoroadz1309.R;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView image;
    private Button botaoVoltar;
    private TextView textResult;
    private CaraCoroaJogo caraCoroaJogo;
    private int escolhaUsuario;

    public void mostraResultado(){
        caraCoroaJogo.joga(escolhaUsuario);
        if ( caraCoroaJogo.getFaceResultado() == CaraCoroaJogo.CARA ){
            image.setImageResource(R.drawable.moeda_cara);
        }else{
            image.setImageResource(R.drawable.moeda_coroa);
        }
        if ( caraCoroaJogo.usuarioVenceu()){
            textResult.setText("Você venceu \uD83D\uDE04️!!");
        }else{
            textResult.setText("Você perdeu \uD83D\uDE25️!!");
        }
        Pontuacao p = Pontuacao.getInstance();
        String mensagem = "Total de partidas = "+ String.valueOf(p.getTotalPartidas())
                +"\nTotal de vitórias = " + String.valueOf(p.getQtVitorias())
                +"\nTotal de derrotas = " + String.valueOf(p.getQtDerrotas());
        //Toast.makeText(getApplicationContext(),mensagem,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        Bundle dados = getIntent().getExtras();
        escolhaUsuario = dados.getInt("usuarioescolha");
        textResult = findViewById(R.id.textResult);
        image =  findViewById(R.id.imageResultado);
        caraCoroaJogo = new CaraCoroaJogo();
        botaoVoltar = findViewById(R.id.botaoVoltar);

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mostraResultado();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        caraCoroaJogo = null;
    }
}
