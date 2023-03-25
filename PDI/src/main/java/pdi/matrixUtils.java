package pdi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class matrixUtils {
    static int[][] getMatrixFromFile(String path) throws FileNotFoundException {
        int[][] matrix = null;
        int columns = 0, lines = 0;
        int i = 0, j = 0;
        Scanner fileScanner = new Scanner(new File(path));
        while (fileScanner.hasNextLine()) {
            String nextLine = fileScanner.nextLine();
            // Se primeiro caractere é cerquilha, ignora linha
            if (nextLine.matches("#.*")) {
                continue;
            }
            // Se há dois números na mesma linha, separados por espaço
            // Inicializa a matriz com as dimensões especificadas
            if (nextLine.matches("[0-9]+ +[0-9]+")) {
                String[] dimensions = nextLine.strip().split(" ");
                columns = Integer.parseInt(dimensions[0]);
                lines = Integer.parseInt(dimensions[1]);
                matrix = new int[lines][columns];
                continue;
            }
            // Se há apenas um número, é um elemento da matriz
            if (nextLine.matches("[0-9]+")) {
                matrix[i][j] = Integer.parseInt(nextLine);
                j = (j + 1) % columns;
                if (j == 0)
                    i++;
            }
        }
        
        fileScanner.close();
        return matrix;
    }
    
    static int[][] matrixSum(int[][] matrixA, int[][] matrixB) {
        int lines = matrixA.length;
        int columns = matrixA[0].length;
        int[][] matrixC = new int[lines][columns];
        
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrixC[i][j] = Math.min(matrixA[i][j] + matrixB[i][j], 100);
            }
        }
        
        return matrixC;
    }
    
    static int[][] matrixDifference(int[][] matrixA, int[][] matrixB) {
        int lines = matrixA.length;
        int columns = matrixA[0].length;
        int[][] matrixC = new int[lines][columns];
        
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrixC[i][j] = Math.max(matrixB[i][j] - matrixA[i][j], 0);
            }
        }
        
        return matrixC;
    }
    
    static void writeMatrixToFile(int[][] matrix, String path) throws IOException {
        int lines = matrix.length;
        int columns = matrix[0].length;
        try {
            File fout = new File(path);
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            // Salva dimensões (colunas e linhas)
            bw.write(String.format("%d %d", columns, lines));
            // Salva linhas e colunas
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < columns; j++) {
                    bw.newLine();
                    bw.write(Integer.toString(matrix[i][j]));
                }
            }
            bw.close();
            fos.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não disponível.");
        }
    }
}
