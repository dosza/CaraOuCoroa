package com.dosza.caraoucoroadz1309;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {
    private ImageView image;
    private Button botaoVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        Bundle dados = getIntent().getExtras();
        int flag = dados.getInt("numero");
        int escolhaUsuario = dados.getInt("usuarioescolha");
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
        if ( flag == escolhaUsuario){
            Toast.makeText(getApplicationContext(),"Você venceu !!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Você perdeu !!",Toast.LENGTH_LONG).show();
        }
    }
}
