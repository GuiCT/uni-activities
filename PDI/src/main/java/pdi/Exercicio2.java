/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package pdi;

import matrix.MatrixPGM;
import matrix.OperationI;

/**
 *
 * @author guilherme
 */
public class Exercicio2 {
  public static void main(String[] args) {
    try {
      MatrixPGM matrix = MatrixPGM.readFile("resources/lena256.pgm");

      // Escurecer
      OperationI darken = (value, maxVal) -> Math.max(value - 30, 0);
      MatrixPGM darkenedMatrix = matrix.applyElementWiseOperation(darken);
      darkenedMatrix.saveToFile("resources/lena256darkened.pgm");

      // Clarear
      OperationI lighten = (value, maxVal) -> Math.min(value + 30, maxVal);
      MatrixPGM lightenedMatrix = matrix.applyElementWiseOperation(lighten);
      lightenedMatrix.saveToFile("resources/lena256lightened.pgm");

      // Negativar
      OperationI invert = (value, maxVal) -> maxVal - value;
      MatrixPGM invertedMatrix = matrix.applyElementWiseOperation(invert);
      invertedMatrix.saveToFile("resources/lena256inverted.pgm");

      // Rotacionar 90, 180 e 270
      MatrixPGM rotate90 = matrix.rotate90();
      rotate90.saveToFile("resources/lena256rotate90.pgm");

      MatrixPGM rotate180 = matrix.rotate180();
      rotate180.saveToFile("resources/lena256rotate180.pgm");

      MatrixPGM rotate270 = matrix.rotate270();
      rotate270.saveToFile("resources/lena256rotate270.pgm");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
