package com.dosza.caraoucoroadz1309.Control;

import android.service.notification.NotificationListenerService;

import java.util.Random;

public class CaraCoroaJogo {
    public static final int CARA = 0;
    public static final int COROA = 1;
    public static final int QTFACES = 2;
    private int faceUsuario;
    private int faceApp;
    private int faceResultado;
    private Pontuacao pontuacao;

    public CaraCoroaJogo(int escolhaUsuario){
        faceResultado = new Random().nextInt(CaraCoroaJogo.QTFACES);
        faceUsuario = escolhaUsuario;
        pontuacao = Pontuacao.getInstance();
    }
    public void joga() {
        if (this.faceUsuario == CaraCoroaJogo.CARA) {
            this.faceApp = CaraCoroaJogo.COROA;
        } else {
            this.faceApp = CaraCoroaJogo.CARA;
        }
        atualizaPlacar();
    }

    public int getFaceResultado(){
        return faceResultado;
    }

    public int getFaceUsuario() {
        return faceUsuario;
    }

    public boolean usuarioVenceu(){
        boolean venceu = (this.faceResultado == this.faceUsuario);
        return venceu;
    }
    public void atualizaPlacar(){
        boolean venceu = this.usuarioVenceu();

        pontuacao.incTotalPartidas();

        if ( venceu ){
           pontuacao.incVitorias();
        }else{
            pontuacao.incDerrotas();
        }

    }


}
