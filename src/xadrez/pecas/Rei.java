package xadrez.pecas;

import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {


    public Rei(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }


    @Override
    public String toString() {
        return "K";
    }

    //movimentos possíveis do Rei
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        return mat;
    }
}
