package Labirintos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class algoritmo {
    
    public static String filePath = "C:\\Users\\PlanetaNote2\\Desktop\\S.I\\ATP\\Trabalho_Labirinto\\Labirintos";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com o nome do mapa: ");
        String filename = sc.nextLine();  

        Labirintos mapas = new Labirintos (filePath + filename);

        System.out.print(mapas);

        LabirintoResolucao resolucao = new LabirintoResolucao(mapas);

        if(resolucao.travessia(0,0)){
            System.out.print("O NPC atravessou com sucesso!");
        }
        else {
            System.out.println("Erro");
        }

        System.out.print(mapas);
        sc.close();
    }
}