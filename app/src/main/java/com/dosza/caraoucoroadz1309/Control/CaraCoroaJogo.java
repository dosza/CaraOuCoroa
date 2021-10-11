package com.dosza.caraoucoroadz1309.Control;

import java.util.Random;

public class CaraCoroaJogo {
    public static final int CARA = 0;
    public static final int COROA = 1;
    public static final int QTFACES = 2;
    private int faceUsuario;
    private int faceApp;
    private int faceResultado;
    private Pontuacao pontuacao;

    public CaraCoroaJogo(){
        faceResultado = -1;
        faceUsuario = -1;
        faceApp = -1;
        pontuacao = Pontuacao.getInstance();
    }
    public void joga(int escolhaUsuario){
        this.faceUsuario = escolhaUsuario;
        if ( this.faceUsuario == CaraCoroaJogo.CARA )
            this.faceApp = CaraCoroaJogo.COROA;
        else
            this.faceApp = CaraCoroaJogo.CARA;
        this.faceResultado = new Random().nextInt(CaraCoroaJogo.QTFACES);
        atualizaPlacar();



    }

    public int getFaceResultado(){
        return faceResultado;
    }
    public boolean usuarioVenceu(){
        return this.faceResultado == this.faceUsuario;
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
