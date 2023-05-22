package pdi;

import matrix.MatrixPGM;
import matrix.OperationI;

public class Exercicio2 {
  public static void main(String[] args) {
    try {
      MatrixPGM matrix = MatrixPGM.readFile("resources/lena256.pgm");

      // Escurecer
      OperationI darken = (value, maxVal) -> Math.max(value - 30, 0);
      MatrixPGM darkenedMatrix = matrix.applyElementWiseOperation(darken);
      darkenedMatrix.saveToFile("resources/aula2/lena256darkened.pgm");

      // Clarear
      OperationI lighten = (value, maxVal) -> Math.min(value + 30, maxVal);
      MatrixPGM lightenedMatrix = matrix.applyElementWiseOperation(lighten);
      lightenedMatrix.saveToFile("resources/aula2/lena256lightened.pgm");

      // Negativar
      OperationI invert = (value, maxVal) -> maxVal - value;
      MatrixPGM invertedMatrix = matrix.applyElementWiseOperation(invert);
      invertedMatrix.saveToFile("resources/aula2/lena256inverted.pgm");

      // Rotacionar 90, 180 e 270
      MatrixPGM rotate90 = matrix.rotate90();
      rotate90.saveToFile("resources/aula2/lena256rotate90.pgm");

      MatrixPGM rotate180 = matrix.rotate180();
      rotate180.saveToFile("resources/aula2/lena256rotate180.pgm");

      MatrixPGM rotate270 = matrix.rotate270();
      rotate270.saveToFile("resources/aula2/lena256rotate270.pgm");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
