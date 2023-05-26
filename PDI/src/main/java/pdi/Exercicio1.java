package pdi;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercicio1 {
    public static void main(String[] args) {
        try {
            int[][] matrix1 = matrixUtils.getMatrixFromFile("resources/aula1/matriz1.txt");
            int[][] matrix2 = matrixUtils.getMatrixFromFile("resources/aula1/matriz2.txt");
            int[][] matrixSum = matrixUtils.matrixSum(matrix1, matrix2);
            int[][] matrixDifference = matrixUtils.matrixDifference(matrix1, matrix2);
            // Salvando os resultados em arquivos
            matrixUtils.writeMatrixToFile(matrixSum, "resources/aula1/matrizSoma.txt");
            matrixUtils.writeMatrixToFile(matrixDifference, "resources/aula1/matrizDiferenca.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não disponível.");
        } catch (IOException ex) {
            System.out.println("Não foi possível escrever arquivo.");
        }
    }
}
