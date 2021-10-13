package com.dosza.caraoucoroadz1309.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.dosza.caraoucoroadz1309.Control.CaraCoroaJogo;
import com.dosza.caraoucoroadz1309.Control.Pontuacao;
import com.dosza.caraoucoroadz1309.R;

import java.util.Timer;
import java.util.TimerTask;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView image;
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

        voltarActivity();
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
    }

    public void voltarActivity(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        },2000);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
