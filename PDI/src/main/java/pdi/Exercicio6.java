package pdi;

import matrix.MatrixPGM;
import matrix.OperationI;

// Aula 05 - Exercícios de Função Gamma
public class Exercicio6 {
    public static void main(String[] args) {
        try {
            MatrixPGM spine = MatrixPGM.readFile("resources/spine.pgm");
            spine.saveToFile("resources/spine2.pgm");
            OperationI gamma06 = (value, maxVal) -> {
                return (int) Math.round(Math.pow(((double) value) / ((double) maxVal), 0.6) * maxVal);
            };
            OperationI gamma04 = (value, maxVal) -> {
                return (int) Math.round(Math.pow(((double) value) / ((double) maxVal), 0.4) * maxVal);
            };
            OperationI gamma03 = (value, maxVal) -> {
                return (int) Math.round(Math.pow(((double) value) / ((double) maxVal), 0.3) * maxVal);
            };
            MatrixPGM spine06 = spine.applyElementWiseOperation(gamma06);
            MatrixPGM spine04 = spine.applyElementWiseOperation(gamma04);
            MatrixPGM spine03 = spine.applyElementWiseOperation(gamma03);
            OperationI gamma30 = (value, maxVal) -> {
                return (int) Math.round(Math.pow(((double) value) / ((double) maxVal), 3.0) * maxVal);
            };
            OperationI gamma40 = (value, maxVal) -> {
                return (int) Math.round(Math.pow(((double) value) / ((double) maxVal), 4.0) * maxVal);
            };
            OperationI gamma50 = (value, maxVal) -> {
                return (int) Math.round(Math.pow(((double) value) / ((double) maxVal), 5.0) * maxVal);
            };
            MatrixPGM aerial = MatrixPGM.readFile("resources/aerial.pgm");
            MatrixPGM aerial30 = aerial.applyElementWiseOperation(gamma30);
            MatrixPGM aerial40 = aerial.applyElementWiseOperation(gamma40);
            MatrixPGM aerial50 = aerial.applyElementWiseOperation(gamma50);
            spine06.saveToFile("resources/spine06.pgm");
            spine04.saveToFile("resources/spine04.pgm");
            spine03.saveToFile("resources/spine03.pgm");
            aerial30.saveToFile("resources/aerial30.pgm");
            aerial40.saveToFile("resources/aerial40.pgm");            
            aerial50.saveToFile("resources/aerial50.pgm");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
