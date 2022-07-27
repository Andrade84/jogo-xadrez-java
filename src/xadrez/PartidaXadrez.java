package xadrez;

//Regras do jogo de xadrez

import tabuleiro.Tabuleiro;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8,8);
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
}
