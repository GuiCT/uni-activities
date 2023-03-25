/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdi;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author guilherme
 */
public class Exercicio1 {
    public static void main(String[] args) {
        try {
            int[][] matrix1 = matrixUtils.getMatrixFromFile("resources/matriz1.txt");
            int[][] matrix2 = matrixUtils.getMatrixFromFile("resources/matriz2.txt");
            int[][] matrixSum = matrixUtils.matrixSum(matrix1, matrix2);
            int[][] matrixDifference = matrixUtils.matrixDifference(matrix1, matrix2);
            // Salvando os resultados em arquivos
            matrixUtils.writeMatrixToFile(matrixSum, "resources/matrizSoma.txt");
            matrixUtils.writeMatrixToFile(matrixDifference, "resources/matrizDiferenca.txt");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Arquivo não disponível.");
        } catch (IOException ex) {
            System.out.println("Não foi possível escrever arquivo.");
        }
    }
}
