package pdi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import matrix.MatrixPGM;

// Aula 05 - Construção de Histograma
public class Exercicio8 {
    public static void main(String[] args) {
        try {
            MatrixPGM lena = MatrixPGM.readFile("resources/lena256.pgm");
            int[] histogramVector = new int[lena.maxVal];
            for (int i = 0; i < lena.lines; i++) {
                for (int j = 0; j < lena.columns; j++) {
                    histogramVector[lena.values[i][j]]++;
                }
            }
            FileWriter histogramFile = new FileWriter("resources/aula5/lenaHistogram.csv");
            BufferedWriter bfw = new BufferedWriter(histogramFile);
            for (int i = 0 ; i < lena.maxVal; i++)
                bfw.write(String.format("%d,", histogramVector[i]));
            bfw.close();
            histogramFile.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
