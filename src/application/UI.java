package application;

import xadrez.Color;
import xadrez.PecaXadrez;
import xadrez.XadrezPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Ler posicao do usuário a1 ler a = linha 1 = coluna
    public static XadrezPosition lerPosicaoNoXadrez(Scanner sc){
        try {
            String s = sc.nextLine();
            char coluna = s.charAt(0); // ler a
            int linha = Integer.parseInt(s.substring(1));//ler 1
            return new XadrezPosition(coluna,linha);
        }
        catch (RuntimeException e){
            throw new InputMismatchException("Erro ao ler posicao no xadrez. valido apenas posicoes de a1 até h8 ");
        }
    }

    public static void imprimeTabuleiro(PecaXadrez[][] pecas) {
        for (int i = 0; i < pecas.length; i++){
            System.out.print((8 - i) + " ");//começa pelo 8
            for (int j = 0; j<pecas.length; j++){
                imprimePeca(pecas[i][j],false); //fundo sem cor
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    //Imprimir tabuleiro com posições marcadas (colorir o fundo)
    public static void imprimeTabuleiro(PecaXadrez[][] pecas,boolean[][] movimentosPossiveis) {
        for (int i = 0; i < pecas.length; i++){
            System.out.print((8 - i) + " ");//começa pelo 8
            for (int j = 0; j<pecas.length; j++){
                imprimePeca(pecas[i][j],movimentosPossiveis[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    //Imprime uma peça
    private static void imprimePeca(PecaXadrez peca, boolean background){
        if(background){
            System.out.print(ANSI_BLUE_BACKGROUND);//Colocar cor de fundo
        }
         if(peca == null){
             System.out.print("-" + ANSI_RESET);
         }
         else{
             if(peca.getColor() == Color.WHITE){
                 System.out.print(ANSI_WHITE + peca + ANSI_RESET);
             }
             else{
                 System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
             }
         }
        System.out.print(" ");
    }
}
