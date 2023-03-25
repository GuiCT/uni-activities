/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transform;

/**
 *
 * @author guilherme
 */
public class Rotation {
    public static int[][] rotate90(int[][] matrix) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        
        int[][] matrixCopy = new int[columns][lines];
        
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrixCopy[j][lines - 1 - i] = matrix[i][j];
            }
        }
        
        return matrixCopy;
    }
    
    public static int[][] rotate180(int[][] matrix) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        
        int[][] matrixCopy = new int[lines][columns];
        
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrixCopy[lines - 1 - i][columns - 1 - j] = matrix[i][j];
            }
        }
        
        return matrixCopy;
    }
    
    public static int[][] rotate270(int[][] matrix) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        
        int[][] matrixCopy = new int[columns][lines];
        
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrixCopy[columns - 1 - j][i] = matrix[i][j];
            }
        }
        
        return matrixCopy;
    }
}
