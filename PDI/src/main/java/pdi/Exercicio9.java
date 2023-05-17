package pdi;

import java.io.FileNotFoundException;
import java.io.InvalidObjectException;

import matrix.MatrixPGM;

/**
 * Exercícios da Aula de Histograma 2 (17/05/2023)
 */
public class Exercicio9 {
    public static void main(String[] args) {
        try {
            MatrixPGM quadrados = MatrixPGM.readFile("resources/quadrados.pgm");
            MatrixPGM[][] quadradosDivididos = quadrados.subdivideMatrix(3);
            for (int i = 0; i < quadradosDivididos.length; i++) {
                for (int j = 0; j < quadradosDivididos[0].length; j++) {
                    quadradosDivididos[i][j] = quadradosDivididos[i][j].equalizeHistogram();
                }
            }
            MatrixPGM quadradosEqualizados = MatrixPGM.combineChunks(quadradosDivididos);
            quadradosEqualizados.saveToFile("resources/quadradosEqualizados.pgm");
            quadrados.equalizeHistogram().saveToFile("resources/histogramaTotal.pgm");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
