package tabuleiro;

public abstract class Peca {

    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        posicao = null; //posicao de uma peça recém criada

    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract boolean[][] movimentosPossiveis();//retorna uma matriz de boleano

    public boolean movimentoPossivel(Posicao posicao){
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
    }

    //existe pelo menos um movimento possível?
    public boolean existeAlgumMovimentoPossivel(){
        boolean [][] mat = movimentosPossiveis();
        for(int i = 0; i < mat.length; i++){
            for(int j=0; j < mat.length; j++){
                if(mat[i][j]){ //se for verdadeiro
                    return true; //existe um movimento possível
                }
            }
        }
        return false; //movimento não é possível
    }
}
