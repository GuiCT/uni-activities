/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class PGMHandler implements ImageHandlerI {
    public String filePath;
    
    @Override
    public int[][] readFromFile() {
        int[][] matrix = null;
        int columns = 0, lines = 0, maxValue = 0;
        int i = 0, j = 0;
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            if (!fileScanner.nextLine().equals("P2")) {
                System.out.println("Arquivo não obedece ao cabeçalho PGM.");
                return null;
            }
            
            if (!fileScanner.hasNextInt()) {
                fileScanner.nextLine();
            }
            
            columns = fileScanner.nextInt();
            lines = fileScanner.nextInt();
            maxValue = fileScanner.nextInt();
            
            matrix = new int[lines][columns];
            for (i = 0; i < lines; i++) {
                for (j = 0; j < columns; j++) {
                    matrix[i][j] = fileScanner.nextInt();
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            System.out.println(e.getMessage());
        }
        
        return matrix;
    }
    
    @Override
    public void saveToFile(int[][] matrix, int maxVal) {
        int lines = matrix.length, columns = matrix[0].length;
        try {
            File fileOut = new File(filePath);
            FileOutputStream fileOutStream = new FileOutputStream(fileOut);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutStream));
            // Montando cabeçalho, primeiro escreve P2.
            bw.write("P2");
            bw.newLine();
            // Escreve dimensões: linha coluna
            bw.write(String.format("%d %d", lines, columns));
            bw.newLine();
            // Escreve valor máximo
            bw.write(String.format("%d", maxVal));
            // Começa a escrever valores
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < columns; j++) {
                    bw.newLine();
                    bw.write(String.format("%d", matrix[i][j]));
                }
            }
            
            bw.close();
            fileOutStream.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Não foi possível criar o arquivo.");
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Não foi possível escrever arquivo.");
            System.out.println(e.getMessage());
        }
    }
}
