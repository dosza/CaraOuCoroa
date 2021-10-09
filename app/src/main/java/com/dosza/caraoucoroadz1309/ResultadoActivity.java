package com.dosza.caraoucoroadz1309;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView image;
    private Button botaoVoltar;
    private TextView textResult;
    private int resultado;
    private int escolhaUsuario;

    //função jogar
    public void jogar(){
        if ( resultado == 0)
            image.setImageResource(R.drawable.moeda_cara);
        else
            image.setImageResource(R.drawable.moeda_coroa);

        if ( resultado == escolhaUsuario)
            textResult.setText("Você venceu!!");
        else
            textResult.setText("Você perdeu!!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        Bundle dados = getIntent().getExtras();
        resultado = new Random().nextInt(2);
        escolhaUsuario = dados.getInt("usuarioescolha");
        textResult = findViewById(R.id.textResult);
        image = (ImageView) findViewById(R.id.imageResultado);


        botaoVoltar = findViewById(R.id.botaoVoltar);

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        jogar();
    }
}
