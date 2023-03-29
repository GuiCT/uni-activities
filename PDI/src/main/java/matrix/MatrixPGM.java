package matrix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MatrixPGM {
  public int[][] values;
  public int maxVal;
  public int lines;
  public int columns;

  public static MatrixPGM readFile(String path) throws InvalidObjectException, FileNotFoundException {
    // Abrindo arquivo
    Scanner fileScanner = new Scanner(new File(path));
    // Verificando se é igual a P2 ou P5
    String magicIdentifier = fileScanner.nextLine();
    // Se não é, trata exceção
    if (!magicIdentifier.equals("P2") && !magicIdentifier.equals("P5"))
      throw new InvalidObjectException("Arquivo não obedece ao cabeçalho PGM.");

    // Ignora todas as entradas até chegar no próximo inteiro.
    while (!fileScanner.hasNextInt()) {
      fileScanner.next();
    }

    // Guarda número de colunas e linhas
    int columns = fileScanner.nextInt();
    int lines = fileScanner.nextInt();
    // Valor máximo assumido por um pixel
    int maxVal = fileScanner.nextInt();

    // Aloca espaço para a matriz
    int[][] values = new int[lines][columns];
    // Se é formato P2, lê cada número decimal em ASCII e armazena
    if (magicIdentifier.equals("P2")) {
      for (int i = 0; i < lines; i++) {
        for (int j = 0; j < columns; j++) {
          values[i][j] = fileScanner.nextInt();
        }
      }
    } else {
      // Se é formato P5, avisa que ainda não foi implementado
      throw new UnsupportedOperationException("Leitura de cabeçalho P5 ainda não está implementada.");
    }

    // Fecha o scanner e gera o objeto contendo a matriz lida
    fileScanner.close();
    MatrixPGM retMatrix = new MatrixPGM();
    retMatrix.lines = lines;
    retMatrix.columns = columns;
    retMatrix.maxVal = maxVal;
    retMatrix.values = values;
    return retMatrix;
  }

  public void saveToFile(String path) throws IOException {
    File fileOut = new File(path);
    FileOutputStream fileOutStream = new FileOutputStream(fileOut);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutStream));
    // Montando cabeçalho, primeiro escreve P2.
    bw.write("P2");
    bw.newLine();
    // Escreve dimensões: linha coluna
    bw.write(String.format("%d %d", this.lines, this.columns));
    bw.newLine();
    // Escreve valor máximo
    bw.write(String.format("%d", this.maxVal));
    // Começa a escrever valores
    for (int i = 0; i < lines; i++) {
      for (int j = 0; j < columns; j++) {
        bw.newLine();
        bw.write(String.format("%d", this.values[i][j]));
      }
    }

    bw.close();
    fileOutStream.close();
  }

  public MatrixPGM copyStructure() {
    MatrixPGM copied = new MatrixPGM();
    copied.lines = this.lines;
    copied.columns = this.columns;
    copied.maxVal = this.maxVal;
    copied.values = new int[this.lines][this.columns];

    return copied;
  }

  public MatrixPGM copyStructureTranspose() {
    MatrixPGM copied = new MatrixPGM();
    copied.lines = this.columns;
    copied.columns = this.lines;
    copied.maxVal = this.maxVal;
    copied.values = new int[this.columns][this.lines];

    return copied;
  }

  public MatrixPGM copy() {
    MatrixPGM copied = this.copyStructure();

    for (int i = 0; i < copied.lines; i++) {
      for (int j = 0; j < copied.columns; j++) {
        copied.values[i][j] = this.values[i][j];
      }
    }

    return copied;
  }

  public MatrixPGM applyElementWiseOperation(OperationI operation) {
    MatrixPGM transformedMatrix = this.copy();
    for (int i = 0; i < transformedMatrix.lines; i++) {
      for (int j = 0; j < transformedMatrix.columns; j++) {
        transformedMatrix.values[i][j] = operation.call(transformedMatrix.values[i][j], transformedMatrix.maxVal);
      }
    }

    return transformedMatrix;
  }

  public MatrixPGM rotate90() {
    MatrixPGM rotated = this.copyStructureTranspose();

    for (int i = 0; i < this.lines; i++) {
      for (int j = 0; j < this.columns; j++) {
        rotated.values[j][this.lines - 1 - i] = this.values[i][j];
      }
    }

    return rotated;
  }

  public MatrixPGM rotate180() {
    MatrixPGM rotated = this.copyStructure();

    for (int i = 0; i < lines; i++) {
      for (int j = 0; j < columns; j++) {
        rotated.values[this.lines - 1 - i][this.columns - 1 - j] = this.values[i][j];
      }
    }

    return rotated;
  }

  public MatrixPGM rotate270() {
    MatrixPGM rotated = this.copyStructureTranspose();

    for (int i = 0; i < lines; i++) {
      for (int j = 0; j < columns; j++) {
        rotated.values[this.columns - 1 - j][i] = this.values[i][j];
      }
    }

    return rotated;
  }

  public MatrixPGM mirrorVertical() {
    MatrixPGM mirrored = this.copyStructure();

    for (int i = 0; i < mirrored.lines; i++) {
      for (int j = 0; j < mirrored.columns; j++) {
        mirrored.values[i][j] = this.values[this.lines - 1 - i][j];
      }
    }

    return mirrored;
  }

  public MatrixPGM mirrorHorizontal() {
    MatrixPGM mirrored = this.copyStructure();

    for (int i = 0; i < mirrored.lines; i++) {
      for (int j = 0; j < mirrored.columns; j++) {
        mirrored.values[i][j] = this.values[i][this.columns - 1 - j];
      }
    }

    return mirrored;
  }

  public MatrixPGM dropGrayScale(int newMaxVal) {
    // Nova quantidade de níveis
    int levels = newMaxVal + 1;
    // Divisor
    int divisor = (this.maxVal + 1) / levels;
    // Novo valor máximo, arredonda para um valor obtido dividindo valores anteriores
    newMaxVal = (this.maxVal + 1) / divisor - 1;

    MatrixPGM dropped = this.copyStructure();
    for (int i = 0; i < this.lines; i++) {
      for (int j = 0; j < this.columns; j++) {
        // Divisão por inteiro sempre arredonda para baixo
        dropped.values[i][j]  = this.values[i][j] / divisor;
      }
    }
    dropped.maxVal = newMaxVal;

    return dropped;
  }
}
