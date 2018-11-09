/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic;

/**
 *
 * @author Nina
 */
public class Cashier {
    private String ssn;
    private String name;
    private String adress;
    private String phone;

    public Cashier(String snn, String name, String adress, String phone) {
        this.ssn = snn;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }
    
    public String getSsn(){
        return ssn;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAdress(){
        return adress;
    }
    
    public String getPhone() {
        return phone;
    }
    
}
