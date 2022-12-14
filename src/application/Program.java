package application;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezException;
import xadrez.XadrezPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        while(true) {
            try {
                UI.limparTela();
                UI.imprimeTabuleiro(partidaXadrez.getPieces());
                System.out.println();
                System.out.print("Origem: ");
                XadrezPosition origem = UI.lerPosicaoNoXadrez(sc);

                boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
                UI.limparTela();
                UI.imprimeTabuleiro(partidaXadrez.getPieces(),movimentosPossiveis);

                System.out.println();
                System.out.print("Destino: ");
                XadrezPosition destino = UI.lerPosicaoNoXadrez(sc);

                PecaXadrez pecaCapturada = partidaXadrez.movimentarPeca(origem, destino);
            }
            catch (XadrezException e){
                System.out.println(e.getMessage());
                sc.nextLine(); //programa aguardar apertar enter
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

    }
}
