/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io;

/**
 *
 * @author guilherme
 */
public interface ImageHandlerI {
    public int[][] readFromFile();
    public void saveToFile(int[][] matrix, int maxVal);
}
