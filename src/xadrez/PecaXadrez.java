package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {

    private Color color;

    public PecaXadrez(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean temPecaAdversaria(Posicao posicao){
        PecaXadrez p  = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getColor() != color; //é adversário
    }
}
