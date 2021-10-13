package com.dosza.caraoucoroadz1309.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dosza.caraoucoroadz1309.Control.CaraCoroaJogo;
import com.dosza.caraoucoroadz1309.R;

import java.util.Timer;
import java.util.TimerTask;

public class ResultadoActivity extends AppCompatActivity {

    public static final int TIMEOUT=1500;
    private ImageView image;
    private TextView textResult;
    private CaraCoroaJogo caraCoroaJogo;
    private int escolhaUsuario;
    private Bundle dados;

    public void voltarActivity(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        },ResultadoActivity.TIMEOUT);
    }
    public void mostraResultado(){

        caraCoroaJogo.joga();
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
        textResult = findViewById(R.id.textResult);
        image =  findViewById(R.id.imageResultado);
        dados = getIntent().getExtras();
        escolhaUsuario = dados.getInt("escolhaUsuario");
        caraCoroaJogo = new CaraCoroaJogo(escolhaUsuario);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    protected void onStart() {
        super.onStart();
        mostraResultado();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
