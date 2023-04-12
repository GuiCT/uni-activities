package pdi;

import matrix.MatrixPGM;

// Aula 05 - Exercícios de Redimensionamento
public class Exercicio7 {
    public static void main(String[] args) {
        try {
            MatrixPGM lena = MatrixPGM.readFile("resources/lena256.pgm");
            MatrixPGM lenaDoubled = lena.doubleSize();
            MatrixPGM lenaHalf = lena.halfSize();
            lenaDoubled.saveToFile("resources/lena512.pgm");
            lenaHalf.saveToFile("resources/lena128.pgm");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
