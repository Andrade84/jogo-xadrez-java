package xadrez;

//Regras do jogo de xadrez

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        iniciarPartida();
    }

    public PartidaXadrez(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    //retornar uma matriz de pecas de xadrez
    //de acordo com a partida
    public PecaXadrez[][] getPieces() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        //percorrer a matriz de peças do tabuleiro
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++){
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j); //downcasting
            }
        }
        return mat;
    }

    //Iniciar partida
    private void iniciarPartida(){
        tabuleiro.colocarPeca(new Torre(tabuleiro,Color.WHITE),new Posicao(2,1));
        tabuleiro.colocarPeca(new Rei(tabuleiro,Color.BLACK), new Posicao(0,4));
        tabuleiro.colocarPeca(new Rei(tabuleiro,Color.WHITE), new Posicao(7,4));

    }
}
