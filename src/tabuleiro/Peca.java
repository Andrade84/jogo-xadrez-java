package tabuleiro;

public class Peca {

    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        posicao = null; //posicao de uma peça recém criada

    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

}
