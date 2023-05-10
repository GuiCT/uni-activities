package matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.Scanner;

public class MatrixPPM {
  public MatrixPGM[] channels;

  public MatrixPPM() {}

  public MatrixPPM(MatrixPGM red, MatrixPGM green, MatrixPGM blue) {
    if (channels == null) {
      channels = new MatrixPGM[3];
    }
    
    channels[0] = red;
    channels[1] = green;
    channels[2] = blue;
  }
  
  public static MatrixPPM readFile(String path) throws FileNotFoundException, InvalidObjectException {
    // Abrindo arquivo
    Scanner fileScanner = new Scanner(new File(path));
    // Verificando se é igual a P3 ou P6
    String magicIdentifier = fileScanner.nextLine();
    // Se não é, trata exceção
    if (!magicIdentifier.equals("P3") && !magicIdentifier.equals("P6"))
      throw new InvalidObjectException("Arquivo não obedece ao cabeçalho PPM.");

    // Ignora todas as entradas até chegar no próximo inteiro.
    while (!fileScanner.hasNextInt()) {
      fileScanner.next();
    }

    // Guarda número de colunas e linhas
    int columns = fileScanner.nextInt();
    int lines = fileScanner.nextInt();
    // Valor máximo assumido por um pixel
    int maxVal = fileScanner.nextInt();

    // Aloca espaço para as matrizes PGM
    MatrixPGM channelRed = new MatrixPGM();
    MatrixPGM channelGreen = new MatrixPGM();
    MatrixPGM channelBlue = new MatrixPGM();

    channelRed.columns = columns;
    channelGreen.columns = columns;
    channelBlue.columns = columns;

    channelRed.lines = lines;
    channelGreen.lines = lines;
    channelBlue.lines = lines;

    channelRed.maxVal = maxVal;
    channelGreen.maxVal = maxVal;
    channelBlue.maxVal = maxVal;

    channelRed.values = new int[lines][columns];
    channelGreen.values = new int[lines][columns];
    channelBlue.values = new int[lines][columns];

    // Se é formato P3, lê cada número decimal em ASCII e armazena
    if (magicIdentifier.equals("P3")) {
      for (int i = 0; i < lines; i++) {
        for (int j = 0; j < columns; j++) {
          channelRed.values[i][j] = fileScanner.nextInt();
          channelGreen.values[i][j] = fileScanner.nextInt();
          channelBlue.values[i][j] = fileScanner.nextInt();
        }
      }
    } else {
      // Se é formato P6, avisa que ainda não foi implementado
      throw new UnsupportedOperationException("Leitura de cabeçalho P6 ainda não está implementada.");
    }

    // Fecha o scanner e gera o objeto contendo a matriz lida
    fileScanner.close();

    MatrixPPM retMatrix = new MatrixPPM();
    retMatrix.channels = new MatrixPGM[] { channelRed, channelGreen, channelBlue };

    return retMatrix;
  }

  public void saveToFile(String path) throws IOException {
    int lines = channels[0].lines;
    int columns = channels[0].columns;
    int maxVal = channels[0].maxVal;

    File fileOut = new File(path);
    FileWriter fileWriter = new FileWriter(fileOut);
    // Montando cabeçalho, primeiro escreve P3.
    fileWriter.write("P3\n");
    // Escreve dimensões: linha coluna
    fileWriter.write(String.format("%d %d\n", columns, lines));
    // Escreve valor máximo
    fileWriter.write(String.format("%d", maxVal));
    // Começa a escrever valores
    for (int i = 0; i < lines; i++) {
      fileWriter.write("\n");
      for (int j = 0; j < columns; j++) {
        fileWriter.write(String.format(
          "%d %d %d ",
          channels[0].values[i][j],
          channels[1].values[i][j],
          channels[2].values[i][j]));
      }
    }

    fileWriter.close();
  }
}
