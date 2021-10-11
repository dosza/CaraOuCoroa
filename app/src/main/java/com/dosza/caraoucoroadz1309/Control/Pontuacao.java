package com.dosza.caraoucoroadz1309.Control;

public class Pontuacao {
    private int totalPartidas;
    private int qtVitorias;
    private int qtDerrotas;

    private static  Pontuacao pontuacao;

    public static Pontuacao getInstance(){
        if ( Pontuacao.pontuacao == null ){
            pontuacao = new Pontuacao();
        }
        return pontuacao;
    }

    private Pontuacao(){
        resetPontuacao();
    }

    public void resetPontuacao(){
        totalPartidas = 0;
        qtVitorias = 0;
        qtDerrotas = 0;
    }

    public void incDerrotas(){
        qtDerrotas+=1;
    }
    public void incVitorias(){
        qtVitorias+=1;
    }
    public void incTotalPartidas(){
        totalPartidas+=1;
    }
    public int getQtDerrotas(){
        return  qtDerrotas;
    }
    public  int getTotalPartidas(){
        return  totalPartidas;
    }
    public int getQtVitorias(){
        return qtVitorias;
    }

}
