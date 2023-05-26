/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculatorws_client_application;

import org.me.calculator.CalculatorWS;
import org.me.calculator.CalculatorWS_Service;

/**
 *
 * @author guilherme
 */
public class CalculatorWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int i = 3;
            int j = 4;
            int result = add(i, j);
            System.out.println("Result = " + result);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private static int add(int i, int j) {
        CalculatorWS_Service service = new CalculatorWS_Service();
        CalculatorWS port = service.getCalculatorWSPort();
        return port.add(i, j);
    }
}
