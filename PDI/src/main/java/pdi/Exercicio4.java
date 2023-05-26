package pdi;

import matrix.MatrixPGM;
public class Exercicio4 {
    public static void main(String[] args) {
        try {
            MatrixPGM lena = MatrixPGM.readFile("resources/lena256.pgm");
            MatrixPGM lena16levels = lena.dropGrayScale(15);
            MatrixPGM lena8levels = lena.dropGrayScale(7);
            MatrixPGM lena4levels = lena.dropGrayScale(3);
            MatrixPGM lena2levels = lena.dropGrayScale(1);
            lena16levels.saveToFile("resources/aula4/lena_16levels.pgm");
            lena8levels.saveToFile("resources/aula4/lena_8levels.pgm");
            lena4levels.saveToFile("resources/aula4/lena_4levels.pgm");
            lena2levels.saveToFile("resources/aula4/lena_2levels.pgm");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
