/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package transform;

/**
 *
 * @author guilherme
 */
public class ElementWiseOperation {
    public OperationI operation;
    
    public int[][] applyOperation(int matrix[][], int argument) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        
        int[][] matrixCopy = new int[lines][columns];
        
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrixCopy[i][j] = operation.call(matrix[i][j], argument);
            }
        }
        
        return matrixCopy;
    }
}
