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
    private String address;
    private String phone;

    public Cashier(String snn, String name, String address, String phone) {
        this.ssn = snn;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public String getSsn(){
        return ssn;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPhone() {
        return phone;
    }
    
}
