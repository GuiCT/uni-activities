package pdi;

import matrix.MatrixPGM;
import matrix.OperationI;

public class Exercicio5 {
    public static void main(String[] args) {
        try {
            MatrixPGM lena = MatrixPGM.readFile("resources/lena256.pgm");
            MatrixPGM lenaPrimeiraFuncao = lena.copy();
            OperationI primeiraFuncao = (value, maxVal) -> {
                if (value > 100 && value < 200) {
                    return 150;
                }
                
                return 0;
            };
            lenaPrimeiraFuncao = lenaPrimeiraFuncao
                    .applyElementWiseOperation(primeiraFuncao);
            MatrixPGM lenaSegundaFuncao = lena.copy();
            OperationI segundaFuncao = (value, maxVal) -> {
                if (value > 100 && value < 200) {
                    return 150;
                }
                
                return value;
            };
            lenaSegundaFuncao = lenaSegundaFuncao
                    .applyElementWiseOperation(segundaFuncao);
            lenaPrimeiraFuncao.saveToFile("resources/aula5/lenaex5a.pgm");
            lenaSegundaFuncao.saveToFile("resources/aula5/lenaex5b.pgm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
