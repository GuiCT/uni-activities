package pdi;

import matrix.MatrixPGM;

public class Exercicio3 {
  public static void main(String[] args) {
    try {
      MatrixPGM lena = MatrixPGM.readFile("resources/lena256.pgm");
      MatrixPGM mirrorVertical = lena.mirrorVertical();
      MatrixPGM mirrorHorizontal = lena.mirrorHorizontal();
      mirrorVertical.saveToFile("resources/aula3/lena_mirrorVertical.pgm");
      mirrorHorizontal.saveToFile("resources/aula3/lena_mirrorHorizontal.pgm");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
