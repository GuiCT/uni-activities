package matrix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
    bw.write(String.format("%d %d", this.columns, this.lines));
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
  
  public MatrixPGM doubleSize() {
      MatrixPGM doubledSize = new MatrixPGM();
      doubledSize.lines = this.lines * 2;
      doubledSize.columns = this.columns * 2;
      doubledSize.maxVal = this.maxVal;
      doubledSize.values = new int[doubledSize.lines][doubledSize.columns];
      
      for (int i = 0; i < this.lines; i++) {
          for (int j = 0; j < this.columns; j++) {
              int pixelValue = this.values[i][j];
              int i2 = i * 2;
              int j2 = j * 2;
              doubledSize.values[i2][j2] = pixelValue;
              doubledSize.values[i2][j2 + 1] = pixelValue;
              doubledSize.values[i2 + 1][j2] = pixelValue;
              doubledSize.values[i2 + 1][j2 + 1] = pixelValue;
          }
      }
      
      return doubledSize;
  }
  
  public MatrixPGM halfSize() {
      MatrixPGM halfSize = new MatrixPGM();
      halfSize.lines = this.lines / 2;
      halfSize.columns = this.columns / 2;
      halfSize.maxVal = this.maxVal;
      halfSize.values = new int[halfSize.lines][halfSize.columns];
      
      for (int i = 0; i < halfSize.lines; i++) {
          for (int j = 0; j < halfSize.columns; j++) {
              int i2 = i * 2;
              int j2 = j * 2;
              halfSize.values[i][j] =
                      (this.values[i2][j2] +
                      this.values[i2][j2 + 1] +
                      this.values[i2 + 1][j2] +
                      this.values[i2 + 1][j2 + 1]) / 4;
          }
      }
      
      return halfSize;
  }

  public int[] getHistogram() {
    int[] levels = new int[maxVal + 1];
    for (int i = 0; i < lines; i++) {
      for (int j = 0; j < columns; j++) {
        levels[values[i][j]]++;
      }
    }

    return levels;
  }

  public MatrixPGM equalizeHistogram() {
    int[] histogram = getHistogram();
    int[] sumOfPrevious = new int[histogram.length];
    int[] newValues = new int[histogram.length];

    for (int k = 0; k < histogram.length; k++) {
      int sum = 0;
      for (int k2 = 0; k2 < k; k2++)
        sum += histogram[k2];

      sumOfPrevious[k] = sum;
    }

    double multiplier = ((double) (maxVal))/((double) (lines * columns));
    for (int k = 0; k < newValues.length; k++)
      newValues[k] = (int) Math.round(multiplier * sumOfPrevious[k]);

    MatrixPGM newMatrix = copyStructure();

    for (int i = 0; i < lines; i++) {
      for (int j = 0; j < columns; j++) {
        newMatrix.values[i][j] = newValues[values[i][j]];
      }
    }

    return newMatrix;
  }

  public MatrixPGM[][] subdivideMatrix(int pixelsInEachDimension) {
    MatrixPGM[][] chunks = new MatrixPGM[(int) Math.ceil(((double) this.lines) / ((double) pixelsInEachDimension))][];
    int sumLines = 0;
    int sumColumns;

    for (int i = 0; i < chunks.length; i++) {
      sumColumns = 0;
      int chunkLines = sumLines + pixelsInEachDimension > lines ?
        lines - sumLines :
        pixelsInEachDimension;
      chunks[i] = new MatrixPGM[(int) Math.ceil(((double) this.columns) / ((double) pixelsInEachDimension))];
      for (int j = 0; j < chunks[0].length; j++) {
        int chunkColumns = sumColumns + pixelsInEachDimension > columns ?
          columns - sumColumns :
          pixelsInEachDimension;
        MatrixPGM chunk = new MatrixPGM();
        chunk.lines = chunkLines;
        chunk.columns = chunkColumns;
        chunk.maxVal = maxVal;
        chunk.values = new int[chunkLines][chunkColumns];

        for (int k = 0; k < chunkLines; k++) {
          for (int k2 = 0; k2 < chunkColumns; k2++) {
            chunk.values[k][k2] = this.values[k + sumLines][k2 + sumColumns];
          }
        }

        chunks[i][j] = chunk;
        sumColumns += chunkColumns;
      }
      sumLines += chunkLines;
    }

    return chunks;
  }

  public static MatrixPGM combineChunks(MatrixPGM[][] chunks) {
    MatrixPGM newMatrix;
    int totalLines = 0;
    int totalColumns = 0;

    for (int k = 0; k < chunks.length; k++) {
      totalLines += chunks[k][0].lines;
      totalColumns += chunks[0][k].columns;
    }

    newMatrix = new MatrixPGM();
    newMatrix.lines = totalLines;
    newMatrix.columns = totalColumns;
    newMatrix.values = new int[totalLines][totalColumns];
    newMatrix.maxVal = chunks[0][0].maxVal;

    int sumLines = 0;
    int sumColumns;

    for (int i = 0; i < chunks.length; i++) {
      sumColumns = 0;
      int chunkLines = chunks[i][0].lines;
      for (int j = 0; j < chunks[0].length; j++) {
        int chunkColumns = chunks[i][j].columns;

        for (int k = 0; k < chunkLines; k++) {
          for (int k2 = 0; k2 < chunkColumns; k2++) {
            newMatrix.values[k + sumLines][k2 + sumColumns] = chunks[i][j].values[k][k2];
          }
        }
        
        sumColumns += chunkColumns;
      }
      sumLines += chunkLines;
    }

    return newMatrix;
  }
}
