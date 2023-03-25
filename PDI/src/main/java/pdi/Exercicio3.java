package pdi;

import transform.Mirror;
import io.PGMHandler;

public class Exercicio3 {
  public static void main(String[] args) {
    PGMHandler handler = new PGMHandler();
    handler.filePath = "resources/lena256.pgm";
    int[][] matrix = handler.readFromFile();

    int[][] verticalMirror = Mirror.mirrorVertically(matrix);
    int[][] horizontalMirror = Mirror.mirrorHorizontally(matrix);

    handler.filePath = "resources/mirrorVertical.pgm";
    handler.saveToFile(verticalMirror, 255);
    handler.filePath = "resources/mirrorHorizontal.pgm";
    handler.saveToFile(horizontalMirror, 255);
  }
}
