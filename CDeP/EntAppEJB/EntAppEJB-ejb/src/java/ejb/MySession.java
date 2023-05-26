/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author guilherme
 */
@Stateless
public class MySession implements MySessionRemote {

    public String getResult() {
        return "This is My Session Bean";
    }
    
    public Double sum(Double x, Double y) {
        return x + y;
    }
    
    public Double multiply(Double x, Double y) {
        return x * y;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
