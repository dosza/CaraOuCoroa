package com.dosza.caraoucoroadz1309.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.dosza.caraoucoroadz1309.Control.Pontuacao;
import com.dosza.caraoucoroadz1309.R;

public class MainActivity extends AppCompatActivity {
    private Button jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jogar = findViewById(R.id.buttonJogar);
        jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EscolhaActivity.class);
                startActivity(intent);

            }
        });

       Pontuacao.getInstance();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
