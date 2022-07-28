package xadrez;

import tabuleiro.Posicao;

public class XadrezPosition {

    private char coluna;
    private int linha;

    //Programação defensiva
    //Não aceitar posições fora do intervalo de a e h
    public XadrezPosition(char coluna, int linha) {
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new XadrezException("Erro ao instanciar. Valores válidos são de a1 até h8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }


    public int getLinha() {
        return linha;
    }

    //converter a posição do xadrez em posição normal
    //Ex: a8 = mat[0][0] // a7 = mat[1][0]
    //matriz_linha = 8 - linhaXadrez
    //matriz_coluna = colunaXadrez - 'a'
    protected Posicao toPosition(){
        //formula
        return new Posicao(8 - linha, coluna - 'a');
    }

    protected static XadrezPosition fromPosition(Posicao pos){
        return new XadrezPosition((char)('a' - pos.getColuna()),8 - pos.getLinha());
    }

    @Override
    public String toString(){
        return " " + coluna + linha;
    }
}
