/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdi;

import io.PGMHandler;
import transform.ElementWiseOperation;
import transform.OperationI;
import transform.Rotation;

/**
 *
 * @author guilherme
 */
public class Exercicio2 {
    public static void main(String[] args) {
        PGMHandler handler = new PGMHandler();
        handler.filePath = "resources/lena256.pgm";
        int[][] matrix = handler.readFromFile();
        
        // Escurecer
        ElementWiseOperation darkenOperation = new ElementWiseOperation();
        OperationI darken = (value, argument) -> Math.max(value - argument, 0);
        darkenOperation.operation = darken;
        int[][] darkenedMatrix = darkenOperation.applyOperation(matrix, 60);
        handler.filePath = "resources/lena256darkened.pgm";
        handler.saveToFile(darkenedMatrix, 255);
        
        // Clarear
        ElementWiseOperation lightenOperation = new ElementWiseOperation();
        OperationI lighten = (value, argument) -> Math.min(value + argument, 255);
        lightenOperation.operation = lighten;
        int[][] lightenedMatrix = lightenOperation.applyOperation(matrix, 60);
        handler.filePath = "resources/lena256lightened.pgm";
        handler.saveToFile(lightenedMatrix, 255);
        
        // Negativar
        ElementWiseOperation invertOperation = new ElementWiseOperation();
        OperationI invert = (value, argument) -> 255 - value;
        invertOperation.operation = invert;
        int[][] invertedMatrix = invertOperation.applyOperation(matrix, 0);
        handler.filePath = "resources/lena256inverted.pgm";
        handler.saveToFile(invertedMatrix, 255);
        
        // Rotacionar 90, 180 e 270
        int[][] rotate90 = Rotation.rotate90(matrix);
        handler.filePath = "resources/lena256rotate90.pgm";
        handler.saveToFile(rotate90, 255);
        
        int[][] rotate180 = Rotation.rotate180(matrix);
        handler.filePath = "resources/lena256rotate180.pgm";
        handler.saveToFile(rotate180, 255);

        int[][] rotate270 = Rotation.rotate270(matrix);
        handler.filePath = "resources/lena256rotate270.pgm";
        handler.saveToFile(rotate270, 255);       
    }
}
