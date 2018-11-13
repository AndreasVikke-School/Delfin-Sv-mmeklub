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
public class Cashier implements PersonInterface {
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
    
    @Override
    public String getSsn(){
        return ssn;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getAddress(){
        return adress;
    }
    
    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivityInfo getActivityInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
