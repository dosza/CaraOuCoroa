package com.cursoandroid.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ResultadoActivity extends AppCompatActivity {
    private ImageView image;
    private Button botaoVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        Bundle dados = getIntent().getExtras();
        int flag = dados.getInt("numero");
       // Toast.makeText(getApplicationContext(),Integer.toString(flag),Toast.LENGTH_SHORT).show();
        image = findViewById(R.id.imageResultado);
        botaoVoltar = findViewById(R.id.botaoVoltar);

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        if ( flag == 0){
            image.setImageResource(R.drawable.moeda_cara);
        }else{
            image.setImageResource(R.drawable.moeda_coroa);
        }
    }
}
