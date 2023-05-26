/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entappclient;

import ejb.MySessionRemote;
import javax.ejb.EJB;

/**
 *
 * @author guilherme
 */
public class Main {

    @EJB
    private static MySessionRemote mySession;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Sum of 10.0 and 5.0: " + mySession.sum(10.0, 5.0));
        System.out.println("Multiply 10.0 and 5.0: " + mySession.multiply(10.0, 5.0));
    }
    
}
