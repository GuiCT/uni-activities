package pdi;

import matrix.MatrixPGM;
import matrix.MatrixPPM;

// Exercícios sobre o formato PPM, do dia 10/05/2023
public class ExerciciosPPM {
  public static void main(String[] args) {
    try {
      MatrixPPM lena = MatrixPPM.readFile("resources/lenna.ppm");
      
      // Extrair os 3 canais e salvar cada um separadamente...
      MatrixPGM redChannel = lena.channels[0];
      MatrixPGM greenChannel = lena.channels[1];
      MatrixPGM blueChannel = lena.channels[2];
      redChannel.saveToFile("resources/ppm/lenaRedChannel.pgm");
      greenChannel.saveToFile("resources/ppm/lenagreenChannel.pgm");
      blueChannel.saveToFile("resources/ppm/lenablueChannel.pgm");
      
      // Alteração de um canal e recomposição do PPM
      // Diminuir o vermelho:
      MatrixPGM newRedChannel = redChannel.applyElementWiseOperation((v, p) -> Math.max(v - 100, 0));
      lena.channels[0] = newRedChannel;
      lena.saveToFile("resources/ppm/lenaRedDarkened.ppm");
      lena.channels[0] = redChannel; // Voltando o anterior
      // Aumentando o azul:
      MatrixPGM newBlueChannel = blueChannel.applyElementWiseOperation((v, p) -> Math.min(v + 100, p));
      lena.channels[2] = newBlueChannel;
      lena.saveToFile("resources/ppm/lenaBlueBrightned.ppm");
      lena.channels[2] = blueChannel;

      // Exercício de misturas
      // C1, C3, C2
      MatrixPPM lenaRedBlueGreen = new MatrixPPM(redChannel, blueChannel, greenChannel);
      lenaRedBlueGreen.saveToFile("resources/ppm/lenaRedBlueGreen.ppm");
      // C2, C1, C3
      MatrixPPM lenaGreenRedBlue = new MatrixPPM(greenChannel, redChannel, blueChannel);
      lenaGreenRedBlue.saveToFile("resources/ppm/lenaGreenRedBlue.ppm");
      // C3, C1, C2
      MatrixPPM lenaBlueRedGreen = new MatrixPPM(blueChannel, redChannel, greenChannel);
      lenaBlueRedGreen.saveToFile("resources/ppm/lenaBlueRedGreen.ppm");
      // C3, C2, C1
      MatrixPPM lenaBlueGreenRed = new MatrixPPM(blueChannel, greenChannel, redChannel);
      lenaBlueGreenRed.saveToFile("resources/ppm/lenaBlueGreenRed.ppm");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
