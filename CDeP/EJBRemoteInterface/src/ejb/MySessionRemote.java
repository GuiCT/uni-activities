/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author guilherme
 */
@Remote
public interface MySessionRemote {

    String getResult();
    Double sum(Double x, Double y);
    Double multiply(Double x, Double y);
    
}
