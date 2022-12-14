package tabuleiro;

public class Tabuleiro {

    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if(linhas < 1 || colunas < 1){
            throw new TabuleiroException("Erro ao criar tabuleiro: é necessário que haja pelo menos 1 linha e 1 coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }


    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna){
        if(!posicaoExiste(linha,coluna)){
            throw new TabuleiroException("Posição não está no tabuleiro");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não está no tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    //ColocarPeca
    public void colocarPeca(Peca peca, Posicao posicao){
            //se não existir nenhuma peça na posição
            if(temPecaNaPosicao(posicao)){
                throw new TabuleiroException("Já existe uma peça nessa posição "+posicao);
            }
            pecas[posicao.getLinha()][posicao.getColuna()] = peca;
            peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não existe no tabuleiro");
        }
        //não há nenhuma peça nessa posição
        if(peca(posicao) == null){
            return null;
        }
        //Retirar peça do tabuleiro
        Peca aux = peca(posicao);
        aux.posicao = null; //peça removida do tabuleiro
        pecas[posicao.getLinha()][posicao.getColuna()] = null; //não há mais peça nessa posição da matriz
        return aux;
    }


    private boolean posicaoExiste(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    //Programação Defensiva
    public boolean posicaoExiste(Posicao posicao){

        return posicaoExiste(posicao.getLinha(),posicao.getColuna());
    }

    public boolean temPecaNaPosicao(Posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new TabuleiroException("Posição não existe no tabuleiro");
        }
        return peca(posicao) != null;
    }
}
