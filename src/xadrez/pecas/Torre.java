package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {


    public Torre(Tabuleiro tabuleiro, Color color) {
        super(tabuleiro, color);
    }

    @Override
    public String toString() {
        return "T";
    }

    //Movimentos possíveis da torre
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0,0);

        //Verificar posições livres ACIMA da peça
        p.setValues(posicao.getLinha() - 1, posicao.getColuna());
        //equanto existir casas vazias avance
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPecaNaPosicao(p)){
                mat[p.getLinha()][p.getColuna()] = true; //pode mover!!
                p.setLinha(p.getLinha() - 1);
        }
        //tem peça adversária no final
        if(getTabuleiro().posicaoExiste(p) && temPecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true; //pegar peça adversária
        }


        //Verificar posições livres ESQUERDA da peça
        p.setValues(posicao.getLinha() , posicao.getColuna() - 1);
        //equanto existir casas vazias avançar
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPecaNaPosicao(p)){
            mat[p.getLinha()][p.getColuna()] = true; //pode mover!!
            p.setColuna(p.getColuna() - 1);
        }

        //tem peça adversária no final?
        if(getTabuleiro().posicaoExiste(p) && temPecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true; //pegar peça adversária
        }



        //Verificar posições livres DIREITA da peça
        p.setValues(posicao.getLinha() , posicao.getColuna() + 1);
        //equanto existir casas vazias avançar
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPecaNaPosicao(p)){
            mat[p.getLinha()][p.getColuna()] = true; //pode mover!!
            p.setColuna(p.getColuna() + 1);
        }

        //tem peça adversária no final?
        if(getTabuleiro().posicaoExiste(p) && temPecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true; //pegar peça adversária
        }


        //Verificar posições livres BAIXO da peça
        p.setValues(posicao.getLinha() + 1 , posicao.getColuna());
        //equanto existir casas vazias avançar
        while(getTabuleiro().posicaoExiste(p) && !getTabuleiro().temPecaNaPosicao(p)){
            mat[p.getLinha()][p.getColuna()] = true; //pode mover!!
            p.setColuna(p.getColuna() +  1);
        }

        //tem peça adversária no final?
        if(getTabuleiro().posicaoExiste(p) && temPecaAdversaria(p)){
            mat[p.getLinha()][p.getColuna()] = true; //pegar peça adversária
        }


        return mat;
    }
}