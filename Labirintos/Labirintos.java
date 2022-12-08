package Labirintos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labirintos {

    private static final int OPEN  = 1;     // Caminho livre
    private static final int TRIED = 2;     // Caminho tentado
    private static final int PATH  = 3;     // Substitui pelo caminho livre

    private int numeroLinhas, numeroColunas;
    private int finalLinha, finalColuna;    // Coordenadas do endpoint
    private int [][] matriz;

    public Labirintos(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        numeroLinhas  = sc.nextInt();
        numeroColunas = sc.nextInt();

        this.matriz = new int [numeroLinhas][numeroColunas];
        for(int i = 0; i < numeroLinhas; i++){  
            for(int j = 0; j < numeroColunas; j++){
                this.matriz[i][j] = sc.nextInt();    
                sc.close();

                finalLinha  = getLinhas() - 1;
                finalColuna = getColunas() - 1;
            }      
        }
    }

    public void tryPosition(int linha, int coluna){ //Função de tentativa de posição
        this.matriz[linha][coluna] = TRIED;
    }

    public boolean solved(int linha, int coluna){
        return (linha == finalLinha && coluna == finalColuna);
    }

    public int getLinhas() {
        return this.matriz.length;
    }

    public int getColunas() {
        return this.matriz[0].length; 
    }

    public void markPath(int linha, int coluna){
        this.matriz[linha][coluna] = PATH;
    }

    public boolean validPosition(int linha, int coluna) { // Função verifica se é possível passar pelo caminho
        boolean resultado = false;


        if(linha >= 0 && linha < matriz.length && coluna >= 0 && coluna < matriz[linha].length)
            if(matriz[linha][coluna] == OPEN)
                resultado = true;
        
        return resultado;
    }

    public String toString(){
        String resultado = "\n";
    
        for (int linha = 0; linha <matriz.length; linha++){
            for (int coluna = 0; coluna <matriz[linha].length; coluna++){
                resultado += matriz[linha][coluna] + "";
                resultado += "\n";
            }
        }
        return resultado;
    }
}
