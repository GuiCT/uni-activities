/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transform;

/**
 *
 * @author guilherme
 */
public class Mirror {
    public static int[][] mirrorVertically(int[][] matrix) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        
        int[][] matrixCopy = new int[columns][lines];
        
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrixCopy[i][j] = matrix[lines - 1 - i][j];
            }
        }
        
        return matrixCopy;
    }
    
    public static int[][] mirrorHorizontally(int[][] matrix) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        
        int[][] matrixCopy = new int[columns][lines];
        
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrixCopy[i][j] = matrix[i][columns - 1 - j];
            }
        }
        
        return matrixCopy;
    }
}
