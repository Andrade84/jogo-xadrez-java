package xadrez;

//Regras do jogo de xadrez

import tabuleiro.Peca;
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


    public boolean[][] movimentosPossiveis(XadrezPosition posicaoOrigem){
        Posicao posicao = posicaoOrigem.toPosition();
        validarPosicaoDeOrigem(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    public PecaXadrez movimentarPeca(XadrezPosition posicaoOrigem, XadrezPosition posicaoDestino){
       //converter posições para posições da matriz
        Posicao origem = posicaoOrigem.toPosition();
        Posicao destino = posicaoDestino.toPosition();

        //Há peça na posição de origem antes do movimento
        validarPosicaoDeOrigem(origem);
        validarPosicaoDeDestino(origem,destino);
        Peca pecaCapturada = fazerMovimento(origem,destino);
        return (PecaXadrez) pecaCapturada;
    }



    private Peca fazerMovimento(Posicao origem, Posicao destino){
        //remover peça que está na posição de origem
        Peca p = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);//remover peça da posição de destino
        //Colocar a peça da posição de origem na posição de destino
        tabuleiro.colocarPeca(p,destino);
        return pecaCapturada;
    }

    private void validarPosicaoDeOrigem(Posicao pos){
        //se não existir uma peça nessa posição
        if(!tabuleiro.posicaoExiste(pos)){
            throw new XadrezException("Não existe peça na posição de origem!");
        }
        //tem algum movimento possível??
        if(!tabuleiro.peca(pos).existeAlgumMovimentoPossivel()){
            throw new XadrezException("Não existe movimentos possíveis para a peça escolhida!");
        }
    }

    private void validarPosicaoDeDestino(Posicao origem, Posicao destino) {
        if(!tabuleiro.peca(origem).movimentoPossivel(destino)){
            throw new XadrezException("A peça escolhida não pode se mover para posição de destino");
        }
    }

    //receber as coordenadas do xadrez
    //Informar coordenadas no sistema do xadrez e não da matriz
    private void colocarNovaPeca(char coluna, int linha , PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new XadrezPosition(coluna,linha).toPosition());
    }

    //Iniciar partida
    private void iniciarPartida(){
        colocarNovaPeca('c', 1, new Torre(tabuleiro, Color.WHITE));
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Color.WHITE));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Color.WHITE));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Color.WHITE));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Color.WHITE));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Color.WHITE));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Color.BLACK));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Color.BLACK));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Color.BLACK));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Color.BLACK));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Color.BLACK));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Color.BLACK));

    }
}
