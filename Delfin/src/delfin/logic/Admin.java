/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic;

/**
 *
 * @author vikke
 */
public class Admin {
    
    private String ssn;
    private String name;
    private String address;
    private String phone;
    private ActivityInfo activityInfo;

    public Admin(String ssn, String name, String address, String phone, ActivityInfo activityInfo) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.activityInfo = activityInfo;
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    
    public ActivityInfo getActivityInfo() {
        return activityInfo;
    }
    
}
