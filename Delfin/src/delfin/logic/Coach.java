/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.logic;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Celina
 */
public class Coach implements PersonInterface{
    private String ssn;
    private String name;
    private String address;
    private String phone;
    private ActivityInfo info;

    public Coach(String ssn, String name, String address, String phone, ActivityInfo info) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.info = info;
    }
    
    @Override
    public String getId() {
        return ssn;
    }
    
    @Override
    public String getSsn() {
        return ssn;
    }
    
    @Override
    public int getAge() {
        int day = Integer.parseInt(ssn.substring(0, 2));
        int month = Integer.parseInt(ssn.substring(2, 4));
        int year = 1900 + Integer.parseInt(ssn.substring(4, 6));
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public ActivityInfo getInfo() {
        return info;
    }  
}
