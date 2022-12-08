package Labirintos;

public class LabirintoResolucao {

    private Labirintos labirinto;

    // construção da classe LabirintoResolucao
    public LabirintoResolucao(Labirintos labirinto){
        this.labirinto = labirinto;
    }

    // função recursiva
	public boolean travessia(int linha, int coluna){
        boolean done = false;

        if (labirinto.validPosition(linha, coluna)){
            labirinto.tryPosition(linha, coluna);  // marca a célula como tentada
        }
        else {
            if(!done){
                done = travessia(linha - 1, coluna); // CIMA
                System.out.print("C");
            }
            if(!done){
                done = travessia(linha, coluna -1); // ESQUERDA
                System.out.print("E");
            }
            if(!done){
                done = travessia(linha +1, coluna); // BAIXO
                System.out.print("B");
            }
            if(!done){
                done = travessia(linha, coluna +1);   // DIREITA
                System.out.print("D");
            }
        }
        if(done) //localização da parte final do labitirinto
            labirinto.markPath(linha, coluna);
    return done;
    }
}
